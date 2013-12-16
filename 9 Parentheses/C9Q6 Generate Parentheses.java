/*
Problem:
	Implement an algorithm to print all valid (i.e., properly 
opened and closed) combinations of n-pairs of parentheses.

Solution:
	page 326
*/


public ArrayList<String> generate(int n){
	ArrayList<String> list = new ArrayList<String>();
	if(n <= 0)
		return list;
	char[] s = new char[n * 2];
	generate(list, n, n, s, 0);
	return list;
}

private void generate(ArrayList<String> list, int left, int right, char[] s, int index){
	if(left < 0 || right < left)  // Invalid
		return;
	if(left == 0 && right == 0){  // No more parens left 
		list.add(String.copyValueOf(s));
	}
	else{
		if(left > 0){  // Add left parenthese, if there are any left parens remaining.
			s[index] = '(';
			generate(list, left - 1, right, s, index + 1);
		}
		if(right > left){  // Add right parenthese, if there are any left parens remaining.
			s[index] = ')';
			generate(list, left, right - 1, s, index + 1);
		}
	}
}




