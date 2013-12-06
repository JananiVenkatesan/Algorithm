/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:
    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


Solution:
To insert the new interval, there are several cases:
    - No more intervals: append it as the last one in the result
        e.g. [[1,3]],  [5, 7] -> [[1,3], [5,7]]  or  [[]],  [5,7] -> [[5,7]]
    
    - Next interval are far away, i.e. starts after new one's end: append the new one to the result and copy over the rest of intervals (no merge involved)
        e.g. [[1,2], [6,8]],  [4,5] -> [[1,2], [4,5], [6,8]]
    
    - Merge is needed: merge and extend the new interval as needed, append it to the result, and copy over the rest
        e.g. [[1,2], [4,6], [8,10]],  [2,5] -> [[1,6], [8,10]]


 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> lists = new ArrayList<Interval>();
        
        int index = 0;
        while(index < intervals.size() && intervals.get(index).end < newInterval.start){
            lists.add(intervals.get(index));
            index ++;
        }
        
        while(index < intervals.size() && intervals.get(index).start <= newInterval.end){
            newInterval.start = Math.min(intervals.get(index).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(index).end, newInterval.end);
            index ++;
        }
        lists.add(newInterval);
        
        while(index < intervals.size()){
            lists.add(intervals.get(index));
            index ++;
        }
        return lists;
    }
}