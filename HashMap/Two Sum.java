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
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(numbers == null)
            return null;
        if(numbers.length < 2)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] index = new int[2];
        for(int i = 0; i < numbers.length; i ++){
            int complement = target - numbers[i];
            if(hm.get(complement) == null){
                hm.put(numbers[i], i);
            }
            else{
                index[0] = hm.get(complement) + 1;
                index[1] = i + 1;
                return index;
            }
        }
        return null;
    }
}