/*
	Author: Bowen Li
	Andrew ID: bowenl
	
	Description: main method, produces five random arithmetic problems of length four
*/

import java.util.*;

public class TestArithmetic{
	static Random r = new Random();

    public static void main(String[] args) {
    	// produces five random arithmetic problems of length four
        RandomGenerator[] rg = new RandomGenerator[5]; 
        // define root of the trees
        Binop root; 
        for(int i=0; i<5; i++){
        	// generate each arithmetic tree
        	rg[i] = new RandomGenerator();
        	root = rg[i].generateTree();
        	// print out equation
        	System.out.println(root.toString()+" = "+ root.eval());
        }
    }
}
