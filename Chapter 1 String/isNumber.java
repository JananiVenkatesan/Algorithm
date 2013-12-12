public boolean isNumber(String s){
	if(s == null || s.length = 0)
		return false;

	if(s.charAt(0) == '-' || s.charAt(0) == '+')
		s = s.substring(1);

	int countDot = 0;
	for(int i = 0; i < s.length(); i ++){
		char ch = s.charAt(i);
		if(!isCharNumber(ch)|| ch != '.')
			return false
		if(ch == '.'){
			count ++;
			if(count > 1 || i == s.length() - 1 || i == 0)
				return false;
		}
	}
	return true;
}

public boolean isCharNumber(char ch){
	if(ch >= '0' && ch <= '9')
		return true;
	else
		return false;
}