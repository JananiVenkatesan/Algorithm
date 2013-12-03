// Leetcode   find Anagrams

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> l = new ArrayList<String>();
        if(strs == null || strs.length == 0)
            return l;
        HashMap<String, LinkedList<String>> hm = new HashMap<String, LinkedList<String>>();
        for(String str : strs){
            String s = sortChars(str);
            if(!hm.containsKey(s)){
                hm.put(s, new LinkedList<String>());
            }
            hm.get(s).add(str);
        }
        
        
        for(String key : hm.keySet()){
            LinkedList<String> list = hm.get(key);
            if(list.size() > 1){
                for(String str : list){
                    l.add(str);
                }
            }
        }
        return l;
    }
    
    public String sortChars(String str){
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}


// Solution 1: sort

Arrays.sort(array, new AnagramComparator());

public class AnagramComparator implements Comparator<String>{
	public String sortChars(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	public int compare(String s1, String s2){
		return sortChars(s1).compareTo(sortChars(s2));
	}
}


// Solution 2: HashMap

public void sort(String[] array){
	HashMap<String, LinkedList<String>> hm = new HashMap<String, LinkedList<String>>();
	for(String s : array){
		String key = sortChars(s);
		if(!hm.containsKey(key)){
			hm.put(key, new LinkedList<String>());
		}
		hm.get(key).add(s);
	}

	int i = 0;
	for(String key : hm.keySet()){
        LinkedList<String> list = hm.get(key);
        for(String str : list){
            array[i] = str;
        }
    }
}

public String sortChars(String s){
	char[] content = s.toCharArray();
	Arrays.sort(content);
	return new String(content);
}
