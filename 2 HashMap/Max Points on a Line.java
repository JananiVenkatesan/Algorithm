/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
            return 0;
        
        int maxLine = 0;
        for(int i = 0; i < points.length; i ++){
            int vertical = 0;  // IMPORTANT! Record points on the same vertical line
            int same = 0;      // IMPORTANT! Record same points
            int max = 0;
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();  // IMPORTANT! Clear the hashmap everytime
            for(int j = 0; j < points.length; j ++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    same ++;   // If every point is unique, same = 1 
                }
                else if(points[i].x == points[j].x){  // Points in a vertical line
                    vertical ++;
                    max = Math.max(max, vertical);
                }
                else{
                    double slope = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
                    if(hm.containsKey(slope)){
                        hm.put(slope, hm.get(slope) + 1);
                    }
                    else{
                        hm.put(slope, 1);
                    }
                    max = Math.max(max, hm.get(slope));
                }
            }
            maxLine = Math.max(maxLine, max + same);
        }
        return maxLine;
    }
}