/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.awt.Color;

/**
 *
 * @author mts
 */
public class DownState extends PlayerState {
    int tempHeight;
    public DownState( Player player) {
        this.owner = player;
        tempHeight = 0;
    }
    
    @Override
    Color getColor() {
        return Color.GREEN;
    }

    @Override
    int getPosY() {
        owner.y+=owner.downSpeed;
        tempHeight+=owner.downSpeed;
        if(tempHeight>=owner.jumpHeight){
                owner.setInitState();
                tempHeight = 0;
        }
        return owner.y;
    }
    
}
