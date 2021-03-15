package sun;

import java.awt.Color;

public class MoonUp extends SunState{
    
    public MoonUp(Sun owner){
        this.owner = owner;
        this.next = new MoonIdle(owner);
    }

    @Override
    Color getColor() {
        return Color.white;
    }

    @Override
    void calculateXY() {
        owner.x--;
        owner.y--;
        if(owner.y-owner.size<=30) owner.changeState(next);
    }
    
}
