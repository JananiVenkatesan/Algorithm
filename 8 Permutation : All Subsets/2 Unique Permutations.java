public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if(num == null || num.length == 0)
            return new ArrayList<ArrayList<Integer>>();
        HashMap<ArrayList<Integer>, Boolean> hm = new HashMap<ArrayList<Integer>, Boolean>();
        return permuteUnique(num, 0, hm);
    }
    
    private ArrayList<ArrayList<Integer>> permuteUnique(int[] num, int index, HashMap<ArrayList<Integer>, Boolean> hm){
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
        if(index == num.length){
            permutations.add(new ArrayList<Integer>());
        }
        else{
            ArrayList<ArrayList<Integer>> perms = permuteUnique(num, index + 1, hm);
            int n = num[index];
            for(ArrayList<Integer> perm : perms){
                for(int i = 0; i <= perm.size(); i ++){
                    ArrayList<Integer> p = new ArrayList<Integer>();
                    p.addAll(perm);
                    p.add(i, n);
                    if(hm.containsKey(p)){
                        continue;
                    }
                    else{
                        hm.put(p, true);
                        permutations.add(p);
                    }
                }
            }
        }
        return permutations;
    }
}