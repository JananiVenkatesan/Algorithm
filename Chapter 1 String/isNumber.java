/*
 * Returns true if the input string is a number and false otherwise
 */
// test cases: null, "", -234.12&091@#, -.3, 00000000,  0.323
public boolean isNumber(String toTest){
    // implementation here
    if(toTest == null || toTest.length() == 0)
        return false;    
    // Remove sign
    if(toTest.charAt(0) == '+' || toTest.charAt(0) == '-')
        toTest = toTest.substring(1);
    if(toTest.charAt(0) == '0' && toTest.charAt(1) != '.')
        return false;
        
    int countDot = 0;
    for(int i = 0; i < s.length(); i ++){
        char ch = s.charAt(i);
        if(!isCharNumber(ch) || ch != '.')
            return false;
        if(ch == '.'){
            count ++;
            if(count > 1 || i == s.length() - 1 || i == 0)
                return false;
        }
    }
    return true;
}

private boolean isCharNumber(char ch){
    if(ch >= '0' && ch <= '9')
        return true;
    else
        return false;
}