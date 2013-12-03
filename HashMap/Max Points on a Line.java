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
        if(points == null)
            return -1;
        if(points.length == 0)
            return 0;
            
        int lineMax = 0;
        for(int i = 0; i < points.length; i ++){
            int max = 0;
            int vertical = 0;  // IMPORTANT! Record points on the same vertical line
            int same = 0;      // IMPORTANT! Record same points
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            for(int j = 0; j < points.length; j ++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    same ++;   // If every point is unique, same = 1 
                }
                else if(points[i].x == points[j].x){   // Points in a vertical line
                    vertical ++;
                    if(vertical > max)
                        max = vertical;
                }
                else{
                    double slope = ((double)(points[i].y - points[j].y)) / (points[i].x - points[j].x);
                    if(hm.containsKey(slope)){
                        int n = hm.get(slope);
                        n ++;
                        hm.put(slope, n);
                    }
                    else{
                        hm.put(slope, 1);
                    }
                    if(hm.get(slope) > max)
                        max = hm.get(slope);
                }
            }
            if(max + same > lineMax){  // max + SAME !!
                lineMax = max + same;
            }
        }
        return lineMax;
    }
}