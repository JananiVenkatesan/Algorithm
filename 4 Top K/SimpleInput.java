/*
 *  Author: Bowen Li	
 *  
 *  Description: Modified nextLine() and nextToken() methods from the PPT
 * 
 * */
import java.io.*;
import java.util.StringTokenizer;

public class SimpleInput {
	// Variable Elements
    private static final BufferedReader stdinReader = new BufferedReader(new InputStreamReader(System.in));
    private BufferedReader reader = stdinReader;
    private String delimiters = " ";
    private StringTokenizer tokenizer = new StringTokenizer("");
    
    // Getter and setter
    private BufferedReader getReader() { return reader; }
    private void setReader(BufferedReader r) { reader = r; }
    
    private StringTokenizer getTokenizer() { return tokenizer; }
    private void setTokenizer(StringTokenizer t) { tokenizer = t; }
    
    public String getDelimiters() { return delimiters; }
    public void setDelimiters(String d) {
        if ((d != null) && (d.length() > 0))
            delimiters = d;
    }
    
    // Constructor
    public SimpleInput(){ }
    public SimpleInput(String filename) throws RuntimeException {
        File details = new File(filename);
        if (!details.exists())
            throw new RuntimeException(filename + " does not exist.");
        else if (!details.canRead())
            throw new RuntimeException(filename + " exists but is unreadable.");
        else if (!details.isFile())
            throw new RuntimeException(filename + " is not a regular file.");
        else {
            try {
               setReader(new BufferedReader(new FileReader(details)));
            }
            catch (FileNotFoundException e) {
               throw new RuntimeException("Failed to open " + filename + " for unknown reason.");
            }
        }
    }
    
    public String nextLine(){
        try {
            BufferedReader reader = getReader();
            String line = reader.readLine();
            //if (line == null)
            //    throw new RuntimeException("End of input.");
            return line;
        }
        catch (IOException e) {
            // pass it on as an unchecked exception
            // throw new RuntimeException(e.getMessage());
        	
        	// Return null if it reaches the end of the file
        	return null;
        }
    }
    private String nextToken() throws RuntimeException {
        StringTokenizer t = getTokenizer();
        final String delimiters = getDelimiters();
        if (!t.hasMoreTokens()) {
            do {
                String line = nextLine();  //could throw exception
                // If it is the end of file, return null
                if(line == null)
                	return null;
                t = new StringTokenizer(line, delimiters);
                setTokenizer(t);
            } while (!t.hasMoreTokens());
        }
        return t.nextToken(delimiters);  // could throw exception
    }
    public String nextWord() throws RuntimeException {
        return nextToken();
    }
    public boolean nextBoolean() throws RuntimeException {
        for ( ; ; ) {
            String s = nextWord();
            if (s.equalsIgnoreCase("t") || s.equalsIgnoreCase("true"))
                return true;
            else if (s.equalsIgnoreCase("f") || s.equalsIgnoreCase("false"))
                return false;
        }
    }
    private double nextNumber() throws RuntimeException {
        Double number = null;  // note this is Double, not double!
        do {
            String numString = null;
            try {
                numString = nextToken();
                number = new Double(numString);
            }
            catch (NumberFormatException e) {
                numString = numString.toLowerCase();
                numString = numString.replace('d', 'e');
                try {
                    number = new Double(numString);
                }
                catch (NumberFormatException ex) {
                    // failed again
                }
            }
        } while (number == null);
        return number.doubleValue();
    }
    public float nextFloat() throws RuntimeException {
        return (float)nextNumber();
    }

    public double nextDouble() throws RuntimeException {
        return (double)nextNumber();
    }
    public short nextShort() throws RuntimeException {
        return (short)nextNumber();
    }

    public int nextInt() throws RuntimeException {
        return (int)nextNumber();
    }

    public long nextLong() throws RuntimeException {
        return (long)nextNumber();
    }



}
