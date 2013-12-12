/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[8,10],[2,6],[15,18],
return [1,6],[8,10],[15,18].

 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> lists = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0)
            return lists;
    
        Comparator<Interval> comp = new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        };
        Collections.sort(intervals, comp);
        
        Interval in = intervals.get(0);
        int index = 1;
        while(index < intervals.size()){
            if(in.end >= intervals.get(index).start){
                in.start = Math.min(in.start, intervals.get(index).start);
                in.end = Math.max(in.end, intervals.get(index).end);
                index ++;
            }
            else{
                lists.add(in);
                in = intervals.get(index);
                index ++;
            }
        }
        lists.add(in);
        return lists;
    }
}