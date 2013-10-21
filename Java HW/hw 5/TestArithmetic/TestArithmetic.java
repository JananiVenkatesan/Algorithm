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
        RandomGenerator[] rg = new RandomGenerator[2];
        // two variable arrays
        int[] x1 = {1,2,3};
        int[] x2 = {4,5,6};
        // generate first arithmetic tree
        printArray(x1);
        rg[0] = new RandomGenerator(x1);
        RandomGenerator.displayTree(rg[0].generateTree());
        // generate second arithmetic tree
        printArray(x2);
        rg[1] = new RandomGenerator(x2);
        RandomGenerator.displayTree(rg[1].generateTree()); 
    }
    public static void printArray(int[] arr){
        System.out.println();
        for(int i = 0; i < arr.length; i++)
            System.out.print("X[" + i + "]=" + arr[i] + " ");
    }
}
