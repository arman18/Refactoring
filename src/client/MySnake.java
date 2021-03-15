package client;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import player.Player;
import gameSpeed.GameLevel;
import health.Health;
import health.HealthSymbol;
import hindernis.Hind;
import java.util.Vector;
import sun.Sun;
public class MySnake extends JPanel implements ActionListener {
                                                        //init Objects
    private Player me = null;
    private Sun sun = new Sun(800,400);
    private BufferedImage bg1;
    private BufferedImage bg2;
    private int bgp1 = 0;
    private int bgp2 = 0;
    private int fx = 0;

    private Timer timer;
    private Color backgr;
    private JFrame debuggConsole = new JFrame("console");
    private JTextArea debugDisplay = new JTextArea();

    private boolean imune = false;                      //init variables
    private boolean gameover = false;
    private boolean darker = false;
    private float bright = 0.97f;
    private int sunIdle = 0;
    private int iters = 0;
    private int count = 0;

    private Vector<Hind> hinds = new Vector<Hind>(3);
    private Health health;
    private HealthSymbol helthSymbol;
    enum SUNSTATE {sunUp, sunDown, moonUp, moonDown}
    

    MySnake(GameLevel level){
        try{
            URL resource = MySnake.class.getResource("bg1.png");
            bg1 = ImageIO.read(resource);
            URL resource2 = MySnake.class.getResource("bg2.png");
            bg2 = ImageIO.read(resource2);
        } catch (Exception e){
            e.printStackTrace();
        }
        me =  new Player(400,310,level.upSpeed,level.downSpeed);
        backgr = Color.getHSBColor(0.6f, 0.8f, 0.97f/2);
        setBackground(backgr);                                    //init JPanel properties
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new TAdapter());
        setPreferredSize(new Dimension(800, 400));
        initConsole();
        hinds.add(new Hind(1,Color.green));
        hinds.add(new Hind(2,Color.green.darker()));
        hinds.add(new Hind(3,Color.green.darker().darker()));
        hinds.get(0).Hx = 600;
        hinds.get(1).Hx = 800;
        hinds.get(2).Hx = 1200;
        health = new Health();
        timer = new Timer(5, this);
        timer.start();
    }


    private void initConsole(){                                 //making a console Frame with Text
        debuggConsole.setResizable(false);
        debuggConsole.setLocation(10, 10);
        debugDisplay.setAlignmentY(JLabel.TOP_ALIGNMENT);
        debugDisplay.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        debugDisplay.setOpaque(true);
        debugDisplay.setEditable(false);
        debugDisplay.setText("");
        debugDisplay.setForeground(Color.GREEN);
        debugDisplay.setBackground(Color.BLACK);
        debugDisplay.setFont(new Font("Unispace", Font.BOLD, 13));
        debugDisplay.setLineWrap(true);
        debuggConsole.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        debuggConsole.add(debugDisplay);
        debuggConsole.setVisible(false);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(sun.getColor());
        g.fillOval(sun.x - sun.size, sun.y - sun.size, sun.size, sun.size);
        if( Main.parallaxscrolling ) {
            g.drawImage(bg1, bgp1, -80, this);
            g.drawImage(bg1, bgp1 + 800, -80, this);
            g.drawImage(bg2, bgp2, -80, this);
            g.drawImage(bg2, bgp2 + 800, -80, this);
        }
        g.setColor(me.getColor());
        g.fillRect(me.getPosX(), me.getPosY(), 10, 10);                   //Player rendern


        helthSymbol = health.getSymbol();
        while(helthSymbol!=null){
            g.setColor(helthSymbol.getColor());
            g.fillPolygon(helthSymbol.getXpoints(), helthSymbol.getYpoints(), 13);
            helthSymbol = health.getSymbol();
        }
        for(int i=0;i<hinds.capacity();i++){
            Hind tempHind = hinds.get(i);
            g.setColor(tempHind.getColor());
            g.fillRect(tempHind.getPosX(), tempHind.getPosY(), tempHind.Hw, 400);
        }


        g.setColor(Color.orange);
        g.fillRect(0, 320, 800, 399);                     //Boden rendern
        if(Main.parallaxscrolling) {
            g.drawImage(bg2, fx, -20, this);
            g.drawImage(bg2, fx + 800, -20, this);
        }


        if(gameover){
            String msg = "Game Over";
            String msg2 = "Your score: " + count;
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (800 - metr.stringWidth(msg)) / 2, 400 / 2 - 9);
            g.drawString(msg2, (800 - metr.stringWidth(msg2)) / 2, 400 / 2 + 9);
        }

    }


    private boolean collision(){
    for(int i=0;i<hinds.capacity();i++){
        Hind tempHind = hinds.get(i);
        if (tempHind.Hx < me.x + 10 && me.x + 10 < tempHind.Hx + tempHind.Hw){      //check for each obstacle
            if (me.y + 11 >= tempHind.Hy){
                return true;
            }
        }
    }

        return false;
    }


    private void doStuff(){
        count++;
                                                //nach einiger Zeit immer schneller werden
        if (5 - count/10000 >= 0){
            timer.setDelay((5 - count/10000));
        }
                                        //Hintergrund und Tageszeit
        //if(count % 1 == 0){
            if (bright <= 0.2684843){
                darker = true;
            }

            if (bright >= 0.97f){
                darker = false;
                //-1781
            }

            if (darker){
                bright += 0.0005/2;
            } else {
                bright -= 0.0005;
            }

            backgr = Color.getHSBColor(0.6f, 0.8f, bright);
            setBackground(backgr);


        //}
                                                    //sonnenzyklus

        if(count % 1.5 == 0){
            sun.changePosition();
        }
        
        if(count % 4 == 0){
            bgp1 -= 1;
        }
        if(bgp1 == -800){
            bgp1 = 0;
        }
        if(count % 2 == 0){
            bgp2 -= 1;
        }
        if(bgp2 == -800){
            bgp2 = 0;
        }
        fx--;
        if(fx == -800){
            fx = 0;
        }




                                                //jump mechanic

        if (collision()) {                  //player fuer 12 ticks imun machen
            if (!imune) {
                health.decrease();
                imune = true;
                iters = count;
            }
        }

        if (count - iters == 12){
            imune = false;
        }

        if (health.getLevel() == 0){      //wenn tot, gameOver
            gameOver();
        }


                                                                                //update Text in Console
//        debugDisplay.setText("H1: " + hind1.Hx + System.lineSeparator()
//                + "H2: " + hind2.Hx + System.lineSeparator()
//                + "H3: " + hind3.Hx + System.lineSeparator()
//				+ "S:  " + count + System.lineSeparator()
//                + "P:  " + me.y + System.lineSeparator()
//                + "HP: " + health.count + System.lineSeparator()
//                + "DN: " + darker + System.lineSeparator()
//                + "p1: " + bgp1 + System.lineSeparator()
//                + "p2: " + bgp2 + System.lineSeparator()
//        );

    }


    private void gameOver(){
        timer.stop();
        gameover = true;
    }
        
    @Override
    public void actionPerformed(ActionEvent e){
        doStuff();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {


            if(e.getKeyCode() == KeyEvent.VK_NUMPAD7){

                if(!debuggConsole.isVisible()){
                    debuggConsole.setSize(300, 400);
                    debuggConsole.setVisible(true);
                } else {
                    debuggConsole.setVisible(false);
                }

                Main.Frame.toFront();

            } else {
                if (e.getKeyCode() == KeyEvent.VK_P){
                    if(timer.isRunning()){
                        timer.stop();
                    } 
                    else {
                        timer.restart();
                    }
                }else {
                    me.jump();
                }
            }

            if(gameover && e.getKeyCode() == KeyEvent.VK_ENTER){
                count = 0;
                iters = 0;
                gameover = false;
                health.restart();
                timer.start();
            }

            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                System.exit(0);
            }

        }

    }

}
