package original;

import gameSpeed.*;
import gameSpeed.GameLevel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {
    static JFrame Frame = new JFrame("Game");   //delcaring JFrame out of main method for easier access later
    static boolean parallaxscrolling = false;

    public static void main(String[] args) {                        //making a main menu
        if(args.length > 0){
            parallaxscrolling = true;
//            System.out.println("true");
        }
        GridLayout layout = new GridLayout(0,1);         //buttons in grid layout
        JPanel Menu = new JPanel();                                 //initialising the Menu Panel
        JButton slow = new JButton("Slow");                     //defining buttons
        JButton medium = new JButton("Medium");
        JButton fast = new JButton("Fast");
        JFrame fr = new JFrame();
        Menu.setLayout(layout);
        Menu.add(slow);
        Menu.add(medium);
        Menu.add(fast);


        slow.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                fr.dispose();                                       //starting the game with PlayerSpeed 1
                game(new Slow());
            }
        });

        medium.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fr.dispose();                                       //starting the game with PlayerSpeed up = 2, down =1
                game(new Medium());
            }
        });

        fast.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fr.dispose();                                       //starting the game with PlayerSpeed 2
                game(new Fast());

            }
        });

        fr.add(new MenuIcon(), BorderLayout.CENTER);            //adding graphics
        fr.add(Menu, BorderLayout.SOUTH);                           //adding buttons
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //initializing basic stuff like size and position
        fr.setSize(300, 300);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void game(GameLevel level){
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //initializing basic stuff like position and size
        Frame.setSize(800,400);
        Frame.add(new MySnake(level));                       //add the custom JPanel
        Frame.setIconImage(new ImageIcon("src/com/sebi/dot.png").getImage());   //trying to add an ImageIcon, succeeded in my IDE, but as soon as I compiled the Jar, it stopped working
        Frame.setResizable(false);
        Frame.setVisible(true);             //setVisible AFTER adding the JPanel
        Frame.setLocationRelativeTo(null);

    }
}
