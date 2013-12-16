public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4)
            return lists;
        
        Arrays.sort(num);
        for(int i = 0; i < num.length - 3; i ++){
            if(i > 0 && num[i - 1] == num[i])  // Skip duplicates
                continue;
            for(int j = i + 1; j < num.length - 2; j ++){
                if(j > i + 1 && num[j - 1] == num[j])  // Skip duplicates
                    continue;
                int complement = target - num[i] - num[j], left = j + 1, right = num.length - 1;
                while(left < right){
                    int temp = num[left] + num[right];
                    if(temp == complement){
                        ArrayList<Integer> l = new ArrayList<Integer>();
                        l.add(num[i]);
                        l.add(num[j]);
                        l.add(num[left]);
                        l.add(num[right]);
                        lists.add(l);
                        
                        left ++;   // Skip duplicates
                        while(left < right && num[left - 1] == num[left]){
                            left ++;
                        }
                        
                        right --;   // Skip duplicates
                        while(left < right && num[right + 1] == num[right]){
                            right --;
                        }
                    }
                    else if(temp < complement){
                        left ++;
                    }
                    else{
                        right --;
                    }
                }
            }
        }
        return lists;
    }
}