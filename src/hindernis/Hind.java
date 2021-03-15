package hindernis;

import java.awt.Color;

public class Hind {
    public int Hx;
    public int Hy;
    public int Hw;
    int id;
    public int speed;
    private final Color color;
    public Hind(int id,Color color){		// we can also set a color
        this.color = color;
        this.id = id;
        Hx = generateNewPositionX();
        Hy = generateNewPositionY();
        Hw = 12;
        speed = 1;
    }
    public Hind(int i){		// we can also set a color
        this.color = Color.GREEN;
        this.id = id;
        Hx = generateNewPositionX();
        Hy = generateNewPositionY();
        Hw = 12;
        speed = 1;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    public int getPosX(){		// should call it first
        Hx-=speed;
        if(Hx+Hw < 0){
            Hx = generateNewPositionX();
            Hy = generateNewPositionY();
        }

        return Hx;
    }
    public int getPosY(){	// call it second
        return Hy;
    }

    private int generateNewPositionX(){
        return (int)(Math.random() * 100) + 800+800*id;
    }
    private int generateNewPositionY(){
        return 300 - ((int) (Math.random() * 7))*3;
    }
    
}
