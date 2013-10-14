/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: Const class, contains double
*/

public class Const extends Node {
    private double value;
    
    public Const(double d){ 
    	value = d; 
    }

    public double eval(){ 
    	return value; 
    }

    public String toString(){
    	StringBuilder sb = new StringBuilder();

    	sb.append(value);

    	return sb.toString();
    }
}
