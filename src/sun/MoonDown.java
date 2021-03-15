
package sun;

import java.awt.Color;

public class MoonDown extends SunState{
    
    public MoonDown(Sun owner){
        this.owner = owner;
//        this.next = new SunUpState(owner);
    }

    @Override
    Color getColor() {
        return Color.yellow;
    }

    @Override
    void calculateXY() {
        owner.x--;
        owner.y++;
        if(owner.y + owner.size >= 400){
            owner.setInitPos();
            owner.setInitState();
        }
    }
    
}
