/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

// Regular Expression Matching
public class Solution {
    public boolean isMatch(String s, String p){
    	if(s == null || p == null)
            return false;
    	if(p.isEmpty())
    	    return s.isEmpty();
    	   
    	// Next is not '*': do current chars match?
    	if(p.length() == 1 || p.charAt(1) != '*'){
    	    if(s.isEmpty())
    	        return false;
    	    if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
    	        return isMatch(s.substring(1), p.substring(1));
    	    else
    	        return false;
    	}
    	
    	// Next is '*': current chars match, zero or more repeats
    	int i = 0;
    	while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
    	    if(isMatch(s.substring(i), p.substring(2))){
    	        return true;
    	    }
    	    i ++;
    	}
    	// Zero
    	return isMatch(s.substring(i), p.substring(2));
    }
}


public class Solution {
    public boolean isMatch(String s, String p) {  
        return isMatchHelper(s, 0, p, 0);  
    }  
       
    private boolean isMatchHelper(String s, int i, String p, int j) {  
        if (p.length() == j) 
       		return (s.length() == i);  
       
        // next char is not '*': do current char match?  
        if (j == p.length() - 1 || p.charAt(j+1) != '*') {  
            if (s.length() == i) 
            	return false;  
            
            if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))  
                return isMatchHelper(s, i+1, p, j+1); 
            else 
            	return false; 
        }  
       
        // next char is '*'  
        // one or more  
        while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {  
            if (isMatchHelper(s, i, p, j+2)) 
            	return true;  
            i++;  
        }  
       
        // zero  
        return isMatchHelper(s, i, p, j+2);  
    }  
}



/*
That said, in the cases p has '(something)*',
If s is empty or current char do not match, skip the '(something)*' part of p and continue to compare the rest of strings;
If current char match, we need to consider three subcases
zero instance of (something) in p
only one instance of (something) in p
multiple instances of (something) in p
*/
public boolean isMatch(String s, String p){
	if(s.isEmpty() && 
		(p.isEmpty() || p.length() == 2 && p.charAt(1) == '*'))
		return true;
	if((s.isEmpty() && !p.isEmpty()) || (p.isEmpty() && !s.isEmpty()))	
		return false;

	if(p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)){
		if(p.length() >= 2 && p.charAt(1) == '*'){
			return isMatch(s.substring(1), p)   // more
				|| isMatch(s.substring(1), p.substring(2))   // once
				|| isMatch(s, p.substring(2));  // zero
		}
		return isMatch(s.substring(1), p.substring(1));
	}
	else if(p.length() >= 2 && p.charAt(1) == '*'){
		return isMatch(s, p.substring(2));
	}

	return false;
}