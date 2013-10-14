/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Answer: Yes, radius assumes the value 1 after RoundGlyph's constructor calls its 
            superclass's constructor and before RoundGlyph's constructor assigns r 
            to radius.
*/

public class RoundGlyph extends Glyph{
    int radius = 1;
    RoundGlyph(int r) {        
        //  super(); 
        System.out.println("RoundGlyph(), radius=" + radius); // print out RoundGlyph(), radius=1
        radius = r;
        System.out.println("RoundGlyph(), radius=" + radius); // print out RoundGlyph(), radius=5
    }
    void draw() {
        System.out.println("RoundGlyph.draw(), radius=" + radius);
    }
}

