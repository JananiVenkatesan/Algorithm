/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: OperatorFactory class, maintains an array of operator objects
*/

import java.util.Random;

public class OperatorFactory{
    // maintains an array of operator objects
    private Node[] currentOps;
    
    // constructor
    public OperatorFactory(Node[] n){ 
    	currentOps = new Node[n.length];
    	for(int i = 0; i < n.length; i++){
    		currentOps[i] = n[i];
    	}
    }
    // randomly return the clone object of one operator
    public Node getOperator(Random rand){
    	int i = rand.nextInt(currentOps.length);

		if(i == 0)
			return (Node) currentOps[0].clone();
		else if(i == 1)
			return (Node) currentOps[1].clone();
		else if(i == 2)
			return (Node) currentOps[2].clone();
		else 
			return (Node) currentOps[3].clone();
    }
    
    public int getNumOps(){
    	return currentOps.length;
    }
}
