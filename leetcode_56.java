/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.size() <= 1) {
      return intervals;
    }
    intervals.sort(new Comparator<Interval>(){
            public int compare (Interval i1, Interval i2){
                return i1.start - i2.start;
            }
          });
    List<Interval> result = new ArrayList<Interval>();
    int start = intervals.get(0).start, end = intervals.get(0).end;
    for (Interval interval: intervals) {
      if (end >= interval.start) {
        end = Math.max(end, interval.end);
      }
      else {
        result.add(new Interval(start, end));
        start = interval.start;
        end = interval.end;
      }
    }
    result.add(new Interval(start, end));
    return result;
  }
}
