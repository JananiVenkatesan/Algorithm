/*
  
    Recursively println all the file's paths under one certain folder

*/
import java.lang.*;
import java.util.*;
import java.io.*;


class Solution{
    public LinkedList<String> getFilePath(File file){
        LinkedList<String> lists = new LinkedList<String>();
        if(file == null)
            return lists;
        getFilePathHelper(file, lists);
        return lists;
    }

    public void getFilePathHelper(File file, LinkedList<String> lists){
        File[] files = file.listFiles();
        if(files == null)
            return;
        for(File f : files){
            if(f.isDirectory()){
                lists.add(f.getPath());
                getFilePathHelper(f, lists);
            }
            else{
                lists.add(f.getPath());
            }
        }
    }
}

public class RecurseFilePath{
    public static void main(String[] args){
        File file = new File("C:/Users/John/Desktop/GitHub/Algorithm");
        Solution s = new Solution();
        LinkedList<String> l = s.getFilePath(file); 
        for(String str : l){
          System.out.println(str);
        }
    } 
}