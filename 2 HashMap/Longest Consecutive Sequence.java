/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        for(int n : num){
            hm.put(n, false);
        }
        
        int max = 0;
        for(int n : num){
            if(!hm.get(n)){
                hm.put(n, true);
                int len = 1 + findConsecutive(hm, n + 1, 1);
                len += findConsecutive(hm, n - 1, -1);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    
    private int findConsecutive(HashMap<Integer, Boolean> hm, int num, int step){
        int length = 0;
        while(hm.containsKey(num)){
            length ++;
            hm.put(num, true);
            num += step;
        }
        return length;
    }
}