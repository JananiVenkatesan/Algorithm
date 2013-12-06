/*

    Given an array of integers, find two numbers such that they add 
up to a specific target number.

    The function twoSum should return indices of the two numbers such 
that they add up to the target, where index1 must be less than index2.  
    Please note that your returned answers (both index1 and index2) are 
not zero-based.

    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2

*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2)
            return null;
            
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i ++){
            int complement = target - numbers[i];
            if(hm.containsKey(complement)){
                int[] solution = new int[2];
                solution[0] = hm.get(complement) + 1;
                solution[1] = i + 1;
                return solution;
            }
            else{
                hm.put(numbers[i], i);
            }
        }
        return null;
    }
}

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null)
            return null;
        if(numbers.length < 2)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] index = new int[2];
        for(int i = 0; i < numbers.length; i ++){
            int complement = target - numbers[i];
            if(hm.containsKey(complement)){
                index[0] = hm.get(complement) + 1;
                index[1] = i + 1;
                return index;
            }
            else{
                hm.put(numbers[i], i);
            }
        }
        return null;
    }
}