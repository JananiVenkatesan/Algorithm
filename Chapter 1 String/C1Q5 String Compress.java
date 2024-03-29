/*
Problem:
    Implement a method to perform basic string compression using the counts 
of repeated characters. For example, the string a a b c c c c c a a a would 
become a2b1c5a3. If the "compressed" string would not become smaller than
the original string, your method should return the original string.

Solution: 
	Time Efficiency -> O(N)
*/

	public static String compressString(String str){
		if(str == null)  // Otherwise, compiler will report a NullPointerException
			return null;
		if(str == "")    // Otherwise, method will return "1"
			return "";
			
		StringBuilder sb = new StringBuilder();
		// record number of the same char
		int count = 1;
		// record current char
		char temp = str.charAt(0);
		for(int i = 1; i < str.length(); i++){
			if(temp==str.charAt(i))
				count++;
			else{
				sb.append(temp);
				sb.append(count);
				temp = str.charAt(i);
				count = 1;
			}
		}
		// append the last element
		sb.append(temp);
		sb.append(count);
		/*
		   If the "compressed" string would not become smaller than the original string, 
		your method should return the original string.
		*/
		return sb.toString().length() < str.length() ? sb.toString() : str;
	}




