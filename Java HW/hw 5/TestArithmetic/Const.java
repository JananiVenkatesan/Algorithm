/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: Const class, contains double
*/

public class Const extends Node{
	 private double value;
	    
	 // constructor
	 public Const(double d){ 
	  	value = d; 
	 }
	    
	 public double eval(double[] data){ 
	    return value; 
	 }
	 public String toString(){
	    return value+"";
	 }
}
