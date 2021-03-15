package health;

import java.awt.Color;

public abstract class HealthSymbol {
    protected Color color;
    protected int cenX,cenY;
    
    public abstract int[] getXpoints();
    public abstract int[] getYpoints();
    public Color getColor(){
        return this.color;
    }
}
