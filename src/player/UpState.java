
package player;

import java.awt.Color;


class UpState extends PlayerState{
	int tempHeight;
	UpState(Player player){
		this.owner = player;
		nextState = new DownState(player);
		tempHeight = 0;
	}
	
	
	int getPosY(){
		owner.y-=owner.upSpeed;
		tempHeight+=owner.upSpeed;
		if(tempHeight>=owner.jumpHeight){
			owner.changeState(nextState);
			tempHeight = 0;
		}
                return owner.y;
                
	}

    @Override
    Color getColor() {
        return Color.BLUE;
    }
}