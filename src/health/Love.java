package health;

import java.awt.Color;

public class Love extends HealthSymbol{
    
    public Love(int cenX,int cenY,Color color){
        this.color = color;
        this.cenX = cenX;
        this.cenY = cenY;
    }

    @Override
    public int[] getXpoints() {
        int[] xPoints = {cenX, cenX,  12+cenX, 15+cenX,
                    27+cenX, 27+cenX, 23+cenX, 16+cenX, 16+cenX,
                    11+cenX, 11+cenX , 4+cenX, cenX};
        return xPoints;
    }

    @Override
    public int[] getYpoints() {
        int[] yPoints = {5, 15, 26, 26, 15,  5,  0,  0,  1, 1,  0  , 0, 5};
        return yPoints;
    }
    
}
