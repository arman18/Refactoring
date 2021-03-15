package sun;

import java.awt.Color;

public class Sun {
    int x,y;
    private int tempX,tempY;
    int size = 30;
    SunState state;
    SunState initiState;
    public Sun(int x,int y){
        this.x = x;
        this.y = y;
        tempX = x;
        tempY = y;
        state = new SunUpState(this);
        initiState = state;
        setInitPos();
    }
    
    public Color getColor(){
	return state.getColor();
    }
    public int getX(){// should call it first
            return this.x;
    }
    public int getY(){
            return this.y;
    }
    public void changePosition(){
        state.calculateXY();
    }
    public void setInitPos(){
            x = tempX;
            y = tempY;
    }
    public void setInitState(){
            state = initiState;
    }
    void changeState(SunState state){
        this.state = state;
    }
}
