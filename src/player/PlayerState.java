
package player;

import java.awt.Color;

abstract class PlayerState{
	Player owner ;
	PlayerState nextState ;
	void jump(){};
	abstract Color getColor();
	abstract int getPosY();
}