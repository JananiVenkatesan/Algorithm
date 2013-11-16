/*
Question 1 / 2 (Jumble Sort)

    You are to write a program that takes a list of strings 
containing integers and words and returns a sorted version
of the list.

    The goal is to sort this list in such a way that all 
words are in alphabetical order and all integers are in
numerical order. Furthermore, if the nth element in the 
list is an integer it must remain an integer, and if it is 
a word it must remain a word.


Input:
    The input will contain a single, possibly empty, line 
containing a space-separated list of strings to be sorted. 
Words will not contain spaces, will contain only the lower-case 
letters a-z. Integers will be in the range -999999 to 999999, 
inclusive. The line will be at most 1000 characters long.

Output:
    The program must output the list of strings, sorted per
the requirements above. Strings must be separated by a single 
space, with no leading space at the beginning of the line or 
trailing space at the end of the line.

 
Constraints:
    The code you submit must take input from stdin and produce 
output to stdout as specified above. No other output is permitted. 
You can assume the input will be valid. Feel free to use standard 
libraries to assist in sorting.

    In the examples below, the text "Input:" and "Output:" are not 
part of the output, and neither are any blank lines.

Example 1:
Input:  1
Output: 1

Example 2:
Input:  car truck bus
Output: bus car truck

Example 3:
Input:8 4 6 1 -2 9 5
Output: -2 1 4 5 6 8 9

Example 4:
Input:  car truck 8 4 bus 6 1
Output: bus car 1 4 truck 6 8


*/


import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line == null)
            System.out.println(null);
        String[] tokens = line.split(" ");
        boolean[] isInt = new boolean[tokens.length];
        LinkedList<Integer> int_list = new LinkedList<Integer>();
        LinkedList<String> string_list = new LinkedList<String>();
        int i = 0;
        for (String token: tokens){
            try{
                int num = Integer.parseInt(token);
                int_list.add(num);
                isInt[i] = true;
            }catch (NumberFormatException e) {
                string_list.add(token);
                isInt[i] = false;
            }finally{
                i++;
            }
        }
        Collections.sort(int_list);
        Collections.sort(string_list);
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < isInt.length; i++){
            if (isInt[i]){
                sb.append(int_list.poll()+" ");
            }else{
                sb.append(string_list.poll()+" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}