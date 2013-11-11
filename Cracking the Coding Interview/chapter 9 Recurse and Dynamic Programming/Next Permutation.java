/*

Problem:
  Implement next permutation, which rearranges numbers into the 
lexicographically next greater permutation of numbers.
  If such arrangement is not possible, it must rearrange it as the 
lowest possible order (ie, sorted in ascending order).

  The replacement must be in-place, do not allocate extra memory.

  Here are some examples. Inputs are in the left-hand column and its 
corresponding outputs are in the right-hand column.
  
  1,2,3 → 1,3,2 → 2,1,3 → 2,3,1 → 3,1,2 → 3,2,1 → 1,2,3
  1,1,5 → 1,5,1 → 5,1,1 → 1,1,5
  2,2,7,5,4,3,2,2,1 → 2,3,1,2,2,2,4,5,7



Solution:

  First thing first, we need to know WHAT is supposed to be the "next" 
permutation.

  Let's take a closer look at the examples.

  2,2,     7,5,4,3,2,2,1
    |   This part was in descending order and got rearranged to ascending order.
    |
   Why 3? 3 is the next greater number than 2 from the rest of the array.

  
  So, given an array of numbers, to find the next lexicographical 
permutation, find the longest descending tail of the array and reverse 
them into ascending order.
  
  If there is any number ahead of the descending tail, it should be replace 
with the first greater number in the tail. The algorithm below runs in time 
O(n) and takes O(1) space. We reverse the tail rather than sort them, since 
we already know they are in descending order. Some sorting algorithms may 
take O(nlogn) or O(n^2) time to sort a reverse ordered array rather than 
O(n). 


*/



public class Solution {
  public void nextPermutation(int[] num) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    int cur = num.length - 1;
    while(cur > 0 && num[cur - 1] >= num[cur]){  // Caution!  >= 
      cur --;
    }
    reverse(num, cur, num.length - 1);
    if(cur > 0){
      int next = cur;
      cur -= 1;
      while(next < num.length && num[next] <= num[cur]){
        next ++;
      }
      swap(num, cur, next);
    }
  }
    
  public void reverse(int[] num, int start, int end){
    while(start < end){
      swap(num, start, end);
        start ++;
        end --;
      }
  }
  public void swap(int[] num, int x, int y){
    int temp = num[x];
      num[x] = num[y];
      num[y] = temp;
  }
}