/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: Variable class, contains index
*/
import java.util.Random;

public class Variable extends Node{
    private int index;  // used for calling data[index]
    
    // constructor
    public Variable(int i){ 
    	index = i; 
    }
    
    // return data[index]
    public double eval(double[] data){ 
    	return data[index]; 
    }
    public String toString(){
    	return "X" + index;
    }
	@Override
	public void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random rand) {
		// doing nothing	
	}
}
