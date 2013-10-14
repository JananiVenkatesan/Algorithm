/*
    Author: Bowen Li
    Andrew ID: bowenl

    Answer: Yes, radius assumes the value 1 after RoundGlyph's constructor calls its 
            superclass's constructor and before RoundGlyph's constructor assigns r 
            to radius.
*/

abstract class Glyph {
    abstract void draw();
    Glyph() {
        System.out.println("Glyph() before draw");
        draw();
        System.out.println("Glyph() after draw");
    }
}
