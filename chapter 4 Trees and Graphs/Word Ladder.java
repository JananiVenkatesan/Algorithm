/*
	So we quickly realize that this looks like a tree searching 
problem for which breath first guarantees the optimal solution. 
Before starting coding, we can visualize a tree in mind and come 
up with the following solution.

http://blog.csdn.net/zxzxy1988/article/details/8591890
*/

// BFS with a private inner class to record word and distance
public class Solution{
	public int ladderLength(String start, String end, HashSet<String> dict){
		if(start.length() != end.length() ||
    		start == null || end == null ||
    			start.length() == 0 || dict.size() == 0)
    		return 0;

    	if(start.equals(end))
    		return 1;

    	LinkedList<PathNode> queue = new LinkedList<PathNode>();
    	queue.add(new PathNode(start, 1));

    	while(!queue.isEmpty()){
    		PathNode node = queue.poll();
    		String currentWord = node.word;
    		int currentDistance = node.distance;

    		if(currentWord.equals(end)){
    			return currentDistance;
    		}

    		for(int i = 0; i < currentWord.length(); i ++){
    			char[] charArray = currentWord.toCharArray();
    			for(char ch = 'a'; ch <= 'z'; ch ++){
    				if(charArray[i] == ch)
    					continue;
    				charArray[i] = ch;

    				String newWord = new String(charArray);
    				if(dict.contains(newWord)){
    					queue.add(new PathNode(newWord, currentDistance + 1));
    					dict.remove(newWord);
    				}
    			}
    		}
    	}
    	return 0;
    }

   	private class PathNode{
		String word;
		int distance;
		public PathNode(String w, int d){
			word = w;
			distance = d;
		}
	}
}


// BFS with a HashMap "visited" to record visited words in dict
public class Solution{
	public int ladderLength(String start, String end, HashSet<String> dict){
		if(start.length() != end.length() ||
    		start == null || end == null ||
    			start.length() == 0 || dict.size() == 0)
    		return 0;

    	if(start.equals(end))
    		return 1;

		// Maintain a queue for words and path length during BSF 
		LinkedList<PathNode> queue = new LinkedList<PathNode>();
		queue.add(new PathNode(start, 1));

		// Maintain a hashmap for visited words
		Map<String, Boolean> visited = new HashMap<String, Boolean>();

		// BFS
		while(!queue.isEmpty()){
			PathNode node = queue.poll();
			String currentWord = node.word;
			int currentDistance = node.distance;

			// Mark the word as visited
			visited.put(currentWord, true);

			// Find all words that can be transformed from start and store in queue with len+1 
			for(int i = 0; i < currentWord.length(); i ++){
				StringBuilder sb = new StringBuilder(currentWord);
				for(char ch = 'a'; ch <= 'z'; ch ++){
					if(sb.charAt(i) == ch)
						continue;

					sb.setCharAt(i, ch);
					String newWord = sb.toString();

					if(newWord.equals(end))
						return currentDistance + 1;

					if(visited.get(newWord) == null && dict.contains(newWord))
						queue.add(new PathNode(newWord, currentDistance + 1));
				}
			}
		}
		return 0;
	}

	private class PathNode{
		String word;
		int distance;
		public PathNode(String w, int d){
			word = w;
			distance = d;
		}
	}
}


// DFS
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict){
		if(start.length() != end.length() ||
    		start == null || end == null ||
    			start.length() == 0 || dict.size() == 0)
    		return 0;

    	if(start.equals(end))
    		return 1;
    
    	minLength = 0;
    	DFS(start, end, dict, 1, new HashSet<String>());
    	return minLength;
    }
    
    private int minLength = 0;
    
    private void DFS(String s, String e, HashSet<String> dict,
    	int length, HashSet<String> visited){
    	visited.add(s);
    
    	for(int i = 0; i < s.length(); i ++){
    		//StringBuilder sb = new StringBuilder(s);
    		char[] charArray = s.toCharArray();
    		for(char ch = 'a'; ch <= 'z'; ch ++){
    			if(ch == charArray[i])
    				continue;  // Skip itself
    			charArray[i] = ch;
    			//String newWord = sb.toString();
    			String newWord = new String(charArray);
    			// if hits end, return length
    			if(newWord.equals(e)){
    				if(minLength == 0 || length + 1 < minLength)
    					minLength = length + 1;
    			}
    			else if(!visited.contains(newWord) && dict.contains(newWord)){  // Skip invalid
    				DFS(newWord, e, dict, length + 1, visited);
    			}
    		}
    	}
    
    	visited.remove(s);
    }
}



