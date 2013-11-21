/*
	
	check if string is palindrome

*/

public boolean isPalindrome(String s){
	if(s == null)
		return true;
	return checkPalindrom(s, 0);
}

public boolean checkPalindrome(String s, int i){
	if(s.charAt(i) == s.charAt(s.length() - 1 - i)){
		if(s.length() - 1 -2 * i <= 1)
			return true;
		return checkPalindrome(s, i + 1);
	}
	else{
		return false;
	}
}