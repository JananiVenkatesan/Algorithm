import java.util.*;

class Solution{
    public int findMaxLength(int[] numbers){
        int sum = 0;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < numbers.length; i ++){
            sum += numbers[i];
            if(hm.containsKey(sum)){
                ((ArrayList<Integer>)hm.get(sum)).add(i);
            }
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                hm.put(sum, list);
            }
        }
        int start = 0, end = 0, max = 0;
        for(ArrayList<Integer> l : hm.values()){
            if(l.size() > 1){
                int length = l.get(l.size() - 1) - l.get(0);
                if(length > maxLength){
                    max = length;
                    end =  l.get(l.size() - 1);
                    start = l.get(0);
                }
            }
        }
        System.out.println("start="+start+"  end="+end);
        return max;
    }
}

public class Leetcode{
    public static void main(String[] args){
        int[] numbers = {1,0,7,6,-4,-2,3,2,-8,3,8};
        Solution s = new Solution();
        System.out.println(s.findMaxLength(numbers));
    }
}
