package health;

import java.awt.Color;
import java.util.Vector;

public class Health {
    private int helthLevel,temp;
    Vector<HealthSymbol> symbols;
    private int itarator = 0;
    public Health(){
        helthLevel = 5;
        temp = helthLevel;
        symbols = new Vector<HealthSymbol>(helthLevel);
        initSymbols();
        
    }
    
    void initSymbols(){     // add 5 symbols
        int count = 0;
        symbols.add(new Love(count++*30,0, Color.red));
        symbols.add(new Love(count++*30,0, Color.red));
        symbols.add(new Love(count++*30,0, Color.green));
        symbols.add(new Love(count++*30,0, Color.green));
        symbols.add(new Love(count++*30,0, Color.green));
    }
    
    public HealthSymbol getSymbol(){
        if(itarator==helthLevel){
            itarator = 0;
            return null;
        }
        return symbols.get(itarator++);
        
    }
    public void decrease(){
        if(helthLevel>0)
            helthLevel--;
    }
    public int getLevel(){
        return this.helthLevel;
    }
    public void restart(){
        this.helthLevel = temp;
    }
    
}
