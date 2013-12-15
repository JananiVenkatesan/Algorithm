
// Wildcard Matching

public boolean isMatch(String s, String p){
	if(s == null || p == null)
		return false;
	if(p.isEmpty())
		return s.isEmpty();

	// Current is '*'
	if(p.charAt(0) == '*'){
		// Skip '*'
		int notstart = 0;
		while(notstart < p.length() && p.charAt(notstart) == '*'){
			notstart ++;
		}
		int index = 0;
		while(index <= s.length()){
			if(isMatch(s.substring(index), p.substring(notstart)))
				return true;
			index ++;
		}
	}
	else{  // Single char match
		if(!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(?)))
			return isMatch(s.substring(1), p.substring(1));
	}

	// No match
	return false;
}

/*
	DP

	http://n00tc0d3r.blogspot.com/2013/05/wildcard-matching.html	
	
	Suppose we have a m*n table T of boolean values, where m is the 
length of pattern p, n is the length of source s, and T[i][j] == true 
means p[0..i] matches s[0..j]. After fill up the table, T[m-1][n-1] 
will be the result for the problem.
*/

public boolean isMatch(String s, String p){
	if(s == null || p == null)
		return false;

	// Calculate count for non-wildcard char
	int count = 0;
	for(Character c : p.toCharArray()){
		if(c != '*')
			count ++;
	}

	// The count should not be larger than that of s
	if(count > s.length())
		return false;

	boolean[] matches = new boolean[s.length() + 1];
	matches[0] = true;
	int pid = 0, firstMatch = 0;
	while(pid < p.length()){
		// Skip duplicate '*'
		if(pid > 0 && p.charAt(pid) == '*' && p.charAt(pid - 1) == '*'){
			pid ++;
			continue;
		}

		// If '*', fill ip the rest of row
		if(p.charAt(pid) == '*'){
			// Fill up the rest of row with true, up to the first match in previous row
			for(int i = firstMatch + 1; i <= s.length(); i ++){
				matches[i] = true;
			}
		}
		else{
			/* Fill up backwards
				- Set to true if match current, and previous diagonal also match
				- Otherwise, set to false
			*/
			int match = -1;
			for(int i = s.length(); i > firstMatch; i --){
				matches[i] = matches[i - 1] && (p.charAt(pid) == s.charAt(i - 1) || p.charAt(pid) == '?');
				if(matches[i])
					match = i;
			}
			if(match < 0)
				return false;
			firstMatch = match;
		}
		pid ++;
	}
	return matches[s.length()];
}















 