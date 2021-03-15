package sun;

import java.awt.Color;

public class SunDown extends SunState {
    
    public SunDown(Sun owner){
        this.owner = owner;
        this.next = new MoonUp(owner);
    }

    @Override
    Color getColor() {
        return Color.red;
    }

    @Override
    void calculateXY() {
        owner.x--;
        owner.y++;
        if(owner.y + owner.size >= 400){
            owner.setInitPos();
            owner.changeState(next);
        }
    }
    
}
