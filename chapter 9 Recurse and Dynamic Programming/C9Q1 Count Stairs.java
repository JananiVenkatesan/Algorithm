/*
Problem:

	  A child is running up a staircase with n steps, and can hop either 1 step, 
2 steps, or 3 steps at a time. Implement a method to count how many possible 
ways the child can run up the stairs.


Solution:

	  page 316

*/

public int countWays(int n){
	  if(n < 0){
		    return 0
	  }else if(n == 0){
		    return 1;   // 1 way to run up the stairs
	  }else{
		    return countWays(n - 1) 
				    + countWays(n - 2)
				    + countWays(n - 3);
	  }
}

/*

Dynamic Programming

	  Like the Fibonacci problem, the runtime of this algorithm is exponential 
(specifically, 0(3^N)), since each call branches out to three more calls. 
This means that countWays is called many times for the same values, which is 
unnecessary. 

*/

public static int countWaysDP(int n, int[] map){
    map[1] = 1;
   	map[2] = 2;
   	map[3] = 4;
   	if(n < 0){
   		return 0;
   	}else if(n == 0){
   		return 1;
   	}else if(map[n] > 0){
    	return map[n];
   	}else{
    	  map[n] = countWaysDP(n - 1, map)
    			+ countWaysDP(n - 2, map)
    			+ countWaysDP(n - 3, map);
    	  return map[n];
    }
}



