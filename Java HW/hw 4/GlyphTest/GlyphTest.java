/*
	Author: Bowen Li
	Andrew ID: bowenl
	
	Answer: Yes, radius assumes the value 1 after RoundGlyph's constructor calls its 
	        superclass's constructor and before RoundGlyph's constructor assigns r 
	        to radius.
*/

public class GlyphTest{
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}