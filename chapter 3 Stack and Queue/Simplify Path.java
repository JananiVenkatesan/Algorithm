/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
	the case where path = "/../"?
		In this case, you should return "/".
	
	Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
		In this case, you should ignore redundant slashes and return "/home/foo".
*/

public String simplifyPath(String path){
	if(path == null || path.charAt(0) != '/')
		return null;

	// Split by "/"
	String[] tokens = path.split("/");

	// Simplify
	Stack<String> stack = new Stack<String>();
	for(String token : tokens){
		if(token.equals("..") && !stack.isEmpty()){
			stack.pop();
		}
		else if(!token.equals(".") && !token.equals("..") && !token.isEmpty()){
			stack.push(token);
		}
	}

	// Print new path
	if(stack.isEmpty())
		return "/";
	StringBuilder sb = new StringBuilder();
	while(!stack.isEmpty()){
		sb.insert(0, "/" + stack.pop());
	}

	return sb.toString();
}