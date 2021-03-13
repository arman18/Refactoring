
package player;

import java.awt.Color;


public class Player {
    public int x;
    public int y;
    private int tempX,tempY;
    int  upSpeed,downSpeed;   
    int jumpHeight = 60;  
    
    PlayerState state;
    PlayerState initState;


    public Player(int posX,int posY,int upSpeed,int downSpeed){
        
        this.upSpeed = upSpeed;
        this.downSpeed = downSpeed;
        this.x = posX;
        this.y = posY;
        tempX = posX;
        tempY = posY;
        state = new NutralState(this);
        initState = state;
            
    }
    public int getPosX(){
            return x;
    }

    public int getPosY(){
            return state.getPosY();
    }

    public void jump(){
            state.jump();
    }
    public Color getColor(){
            return state.getColor();
    }

    void changeState(PlayerState state) {	// should private
            this.state = state;
    }

    void setInitState(){
            state = initState;
            x = tempX;
            y = tempY;
    }
}
