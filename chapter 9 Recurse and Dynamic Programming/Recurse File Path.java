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

/*

String[]    list()
    Returns an array of strings naming the files and directories 
in the directory denoted by this abstract pathname.


String[]    list(FilenameFilter filter)
    Returns an array of strings naming the files and directories 
in the directory denoted by this abstract pathname that satisfy the specified filter.


File[]      listFiles()
    Returns an array of abstract pathnames denoting the files in 
the directory denoted by this abstract pathname.


File[]      listFiles(FileFilter filter)
    Returns an array of abstract pathnames denoting the files and 
directories in the directory denoted by this abstract pathname that satisfy the specified filter.


File[]      listFiles(FilenameFilter filter)
    Returns an array of abstract pathnames denoting the files and 
directories in the directory denoted by this abstract pathname that satisfy the specified filter.

*/

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

// --------------------------

import java.io.*;
import java.util.*;

public class DirFilter implements FilenameFilter {
    String afn;
    
    DirFilter(String afn) { 
        this.afn = afn; 
    }
    public boolean accept(File dir, String name) {
           String f = new File(name).getName();
           return f.endsWith(afn);
    }
}

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        System.out.println(path.getAbsolutePath());
        if(args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i]);
    }
}


