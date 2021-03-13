
package player;

import java.awt.Color;


class NutralState extends PlayerState{
	
	
    NutralState(Player player){
            this.owner = player;
            nextState = new UpState(player);
    }

    @Override
    void jump(){
            owner.changeState(nextState);
    }
    @Override
    int getPosY(){
            return owner.y;
    }

    @Override
    Color getColor() {
        return Color.yellow;
    }
}
