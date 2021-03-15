/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sun;

import java.awt.Color;

/**
 *
 * @author mts
 */
public class SunUpIdle extends SunState{
    
    public SunUpIdle(Sun owner){
        this.owner = owner;
        this.next = new SunDown(owner);
    }
    
    @Override
    Color getColor() {
        return Color.white;
    }

    @Override
    void calculateXY() {
        owner.x--;
        if(owner.x<= 315) owner.changeState(next);
    }
    
}
