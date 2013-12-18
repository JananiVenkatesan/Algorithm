/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
*/
// DP with Stack
// http://fisherlei.blogspot.com/2012/12/leetcode-largest-rectangle-in-histogram.html
public int largestRectangleArea(int[] height){
	Stack<Integer> h = new Stack<Integer>();
	Stack<Integer> index = new Stack<Integer>();

	int largestSize = 0;
	for(int i = 0; i < height.length; i ++){
		if(h.isEmpty() || height[i] > h.peek()){
			h.push(height[i]);
			index.push(i);
		}
		else if(height[i] < h.peek()){
			int lastIndex = 0;
			while(!h.isEmpty() && height[i] < h.peek()){
				lastIndex = index.pop();
				int tempAreaSize = h.pop() * (i - lastIndex);
				largestSize = Math.max(largestSize, tempAreaSize);
			}

			h.push(height[i]);
			index.push(lastIndex);
		}
	}
	while(!h.isEmpty()){
		int tempAreaSize = h.pop() * (height.length - index.pop());
		largestSize = Math.max(largestSize, tempAreaSize);
	}

	return largestSize;
}


// Recursive
public class Solution {
    public int largestRectangleArea(int[] h) {
        if(h == null || h.length == 0)
            return 0;
        int max = 0;
        HashMap<Integer, ArrayList<Integer>> visited = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < h.length; i ++){
            int len = findAdj(i, h, visited);
            max = Math.max(i, len);
        }
        return max;
    }
    private int findAdj(int index, int[] h, HashMap<Integer, ArrayList<Integer>> visited){
        for(Integer i : visited.keySet()){
            if(i <= index){
                ArrayList<Integer> list = visited.get(i);
                if(index <= list.get(0) && h[index] == list.get(1))
                    return list.get(2);
            }
        }
        
        int left = index - 1;
        while(left >= 0 && h[left] >= h[index]){
            left --;
        }
        int right = index + 1;
        while(right < h.length && h[right] >= h[index]){
            right ++;
        }
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(right);
        l.add(h[index]);
        int area = h[index] * (right - left - 1);
        l.add(area);
        visited.put(left, l);
        return area;
    }
}