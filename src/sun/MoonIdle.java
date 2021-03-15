package sun;

import java.awt.Color;

public class MoonIdle extends SunState{
    
    public MoonIdle(Sun owner){
        this.owner = owner;
        this.next = new MoonDown(owner);
    }

    @Override
    Color getColor() {
        return Color.pink;
    }

    @Override
    void calculateXY() {
        owner.x--;
        if(owner.x<= 315) owner.changeState(next);
    }
    
}
