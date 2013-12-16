public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if(num == null || num.length == 0)
            return new ArrayList<ArrayList<Integer>>();
        HashMap<ArrayList<Integer>, Boolean> hm = new HashMap<ArrayList<Integer>, Boolean>();
        return subsets(num, 0, hm);
    }
    
    private ArrayList<ArrayList<Integer>> subsets(int[] num, int index, HashMap<ArrayList<Integer>, Boolean> hm){
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        if(index == num.length){
            allSubsets.add(new ArrayList<Integer>());
            hm.put(new ArrayList<Integer>(), true);
        }
        else{
            allSubsets = subsets(num, index + 1, hm);
            int i = num[index];
            ArrayList<ArrayList<Integer>> more = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset : allSubsets){
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(i);
                Collections.sort(newSubset);
                if(hm.containsKey(newSubset)){
                    continue;
                }
                else{
                    hm.put(newSubset, true);
                    more.add(newSubset);
                }
            }
            allSubsets.addAll(more);
        }
        return allSubsets;
    }
}


// Combinatorics
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return allSubsets;
        HashMap<ArrayList<Integer>, Boolean> hm = new HashMap<ArrayList<Integer>, Boolean>();
        int max = 1 << num.length;
        for(int i = 0; i < max; i ++){
            ArrayList<Integer> subset = convertToSubset(num, i);
            if(hm.containsKey(subset)){
                continue;
            }
            else{
                hm.put(subset, true);
                allSubsets.add(subset);
            }
        }
        return allSubsets;
    }
    
    private ArrayList<Integer> convertToSubset(int[] num, int x){
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for(int i = x; i > 0; i >>= 1){
            if( (i & 1) == 1){
                subset.add(num[index]);
            }
            index ++;
        }
        Collections.sort(subset);
        return subset;
    }
}