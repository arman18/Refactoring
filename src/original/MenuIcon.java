package original;
import health.Health;
import health.HealthSymbol;
import java.awt.*;
import javax.swing.*;

public class MenuIcon extends JPanel{

    Health health;
    HealthSymbol symbol;
    MenuIcon(){
        setBackground(Color.getHSBColor(0.6f, 0.8f, 0.97f));      //set background
        health = new Health();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.yellow);
        g.fillOval(200 - 30, 80 - 30, 30, 30);
        //g.fillRect(120, 140, 10, 10);                       //Player rendern
        g.fillRect(120, 140, 10, 5);                       //Player rendern
        for (int i = 0; i < 2; i++){                                                    //Herzen rendern
            symbol = health.getSymbol();
            g.setColor(Color.green);
            g.fillPolygon(symbol.getXpoints(),symbol.getYpoints(), 13);
        }

        g.setColor(Color.green);
        g.fillRect(170, 120, 12, 400);                              //Hindernisse Rendern
        g.setColor(Color.green.darker());
        g.fillRect(210, 135, 12, 400);
        g.setColor(Color.green.darker().darker());
        g.fillRect(260, 130, 12, 400);
        g.setColor(Color.orange);
        g.fillRect(0, 150, 800, 399);                           //Boden rendern

    }

}
