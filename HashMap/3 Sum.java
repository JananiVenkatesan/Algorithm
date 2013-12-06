/*

Given an array S of n integers, are there elements a, b, c in S such 
that a + b + c = 0? Find all unique triplets in the array which gives 
the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

*/


public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 3){
            return lists;
        }
        
        Arrays.sort(num);
        for(int i = 0; i < num.length; i ++){
            if(i > 0 && num[i - 1] == num[i]){
                continue;
            }
            int left = i + 1, right = num.length - 1;
            while(left < right){
                int sum = num[i] + num[left] + num[right];
                if(sum < 0){
                    left ++;
                }
                else if(sum > 0){
                    right --;
                }
                else{
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    lists.add(list);
                    
                    left ++;
                    while(left < right && num[left] == num[left - 1]){
                        left ++;
                    }
                    
                    right --;
                    while(left < right && num[right] == num[right + 1]){
                        right --;
                    }
                }
            }
        }
        return lists;
    }
}

// HashMap 1

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num){
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length < 3)
			return lists;
			
		HashMap<Integer, HashMap<Integer, Integer>> hm = new HashMap<Integer, HashMap<Integer, Integer>>();
		for(int i = 0; i < num.length - 1; i ++){
		    for(int j = i + 1; j < num.length - 1; j ++){
		        int sum = num[i] + num[j];
		        if(hm.containsKey(sum)){
		            (hm.get(sum)).put(i, j);
		        }
		        else{
		            HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
		            index.put(i, j);
		            hm.put(sum, index);
		        }
		    }
		}
		
		for(int i = 0; i < num.length; i ++){
		    int complement = 0 - num[i];
		    if(hm.containsKey(complement)){
		        HashMap<Integer, Integer> index = hm.get(complement);
		        Set<Integer> set = index.keySet();
		        Iterator<Integer> it = set.iterator();
		        while(it.hasNext()){
		            ArrayList<Integer> list = new ArrayList<Integer>();
		            int key = it.next();
		            int value = index.get(key);
		            list.add(num[i]);
		            list.add(key);
		            list.add(value);
		            Collections.sort(list);
		            if(lists.indexOf(list) == -1)
		                lists.add(list);
		        }
		    }
		}
		return lists;
    }
}

// HashMap 2

public class Solution {
     public ArrayList<ArrayList<Integer>> threeSum(int[] num){
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length < 3)
			return lists;

		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < num.length; i ++){
		    // If there are duplicates
			if(hm.containsKey(num[i])){
				(hm.get(num[i])).add(i);
			}
			else{
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(i);
				hm.put(num[i], al);
			}
		}

		// Iterate O(N^2)
		for(int i = 0; i < num.length; i ++){
			for(int j = 0; j < i; j ++){
				int complement = 0 - num[i] - num[j];
				if(hm.containsKey(complement)){
					ArrayList<Integer> al = hm.get(complement);
					for(int k : al){
						if(k != i && k != j){
							ArrayList<Integer> list = new ArrayList<Integer>();
							list.add(complement);
							list.add(num[i]);
							list.add(num[j]);
							Collections.sort(list);

							if(lists.indexOf(list) == -1){
								lists.add(list);
							}
						}
					}
				}
			}
		}
		return lists;
	}
}