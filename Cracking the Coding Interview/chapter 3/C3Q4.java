/*
Problem:
    In the classic problem of the Towers of Hanoi, you have 3 towers 
and N disks of different sizes which can slide onto any tower. The puzzle 
starts with disks sorted in ascending order of size from top to bottom 
(i.e., each disk sits on top of an even larger one). 

    You have the following constraints:
	(1) Only one disk can be moved at a time.
	(2) A disk is slid off the top of one tower onto the next rod.
	(3) A disk can only be placed on top of a larger disk.

    Write a program to move the disks from the first tower to the last 
using Stacks.

Solution:
    page 220

moveDisks(int n, Tower origin. Tower destination, Tower buffer) {
   // Base case 
   if (n <=0) return;

   // move top n - 1 disks from origin to buffer, using destination as a buffer.
   moveDisks(n - 1, origin, buffer, destination);
    
   // move top from origin to destination
   moveTop(origin, destination);

   // move top n - 1 disks from buffer to destination, using origin as a buffer.
   moveDisks(n - 1, buffer, destination, origin);
}

*/
// funtion code
moveDisks(int n, Tower origin, Tower destination, Tower buffer){
  // Base case
  if(n <= 0)
    return;

  // move top n - 1 disks from origin to buffer, using destination as a buffer.
  moveDisks(n-1, origin, buffer, destination);

  // move top from origin to destination
  moveTop(origin, destination);

  //  move top n - 1 disks from buffer to destination, using origin as a buffe
  moveDisks(n-1, buffer, destination, origin);
} 

// ! --------
// complete code
public class C3Q4{
  public static void main(String[] args){
    int n = 3;
    Tower[] towers = new Tower[n];
    for(int i = 0; i < 3; i++){
      towers[i] = new Tower(i);
    }

    for(int i = n - 1; i >= 0; i--){
      towers[0].add(i);
    }   
    towers[0].moveDisks(n, towers[2], towers[1]);
  }
}

class Tower{
  private Stack<Integer> disks;
  private int index;  // index of tower number
  public Tower(int i){
    disks = new Stack<Integer>();
    index = i;
  }

  public int getIndex(){
    return index;
  }

  public void add(int d){
    // you cannot put a larger disk above a smaller disk
    if(!disks.isEmpty() && disks.peek() <= d){
      System.out.println("Error in placing disk" + d);
    }else{
      disks.push(d);
    }
  }

  public void moveTopTo(Tower t){
    int top = disks.pop();
    t.add(top);
    System.out.println("Move disk " + top + " from " + getIndex() + " to " + t.getIndex());
  }

  public void moveDisks(int n, Tower destination, Tower buffer){
    if(n > 0){
      moveDisks(n-1, buffer, destination);
      moveTopTo(destination);
      buffer.moveDisks(n-1, destination, this);
    }
  }
}










