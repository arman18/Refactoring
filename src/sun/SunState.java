package sun;

import java.awt.Color;

public abstract class SunState {
    Sun owner;
    SunState next;
    
    abstract Color getColor();
    abstract void calculateXY();
}
