/*
1. Please write a method to normalize a string which represents a file path. 
For the purposes of this question, normalizing means:

• all single dot components of the path must be removed. 
	For example, "foo/./bar" should be normalized to "foo/bar".

• all double dots components of the path must be removed, along with their 
  parent directory. 
	For example, "foo/bar/../baz" should be normalized to "foo/baz".

That's it. Normally, a path normalization algorithm would do a lot of other 
stuff, but for this question, don't try any other kind of normalization or 
transformation of the path. As an example, "foo//bar" should be normalized 
to "foo//bar" (i.e. a no-op).



java String methods that may be useful

matches(String regex)
replace(char new, char old)
replaceAll(String regex, String replacement)
charAt()
concat()
contains()
endsWith()   startsWith()
indexOf(String str)   indexOf(String str, int fromIndex)
substring(int beginIndex)  substring(int beginIndex, int endIndex)
*/