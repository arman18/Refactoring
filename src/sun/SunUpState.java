
package sun;

import java.awt.Color;

public class SunUpState extends SunState{
    public SunUpState(Sun owner){
        this.owner = owner;
        this.next = new SunUpIdle(owner);
    }

    @Override
    Color getColor() {
        return Color.yellow;
    }

    @Override
    void calculateXY() {
        owner.x--;
        owner.y--;
        if(owner.y-owner.size<=30) owner.changeState(next);
    }
}
