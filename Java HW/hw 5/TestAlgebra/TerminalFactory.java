/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: TermianlFactory class, maintains number of independent variables
*/

import java.util.Random;

public class TerminalFactory {
    private int numIndepVars;
    
    public TerminalFactory(int n){
    	numIndepVars = n;
    }
    // return a Variable or a Const object according to random number generated
    public Node getTerminal(Random rand){
    	int i = rand.nextInt(numIndepVars+1);   // [0, numIndepvars]
    	if(i < numIndepVars)
    		return new Variable(i);
    	else 
    		return new Const(Math.ceil(rand.nextDouble()*1000)/1000);  // round up to 2 decimals
    }
    public int getNumIndepVars(){
		return numIndepVars;
    }
}
