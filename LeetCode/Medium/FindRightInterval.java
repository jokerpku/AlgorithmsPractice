package Medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Jokeria on 2016/11/22.
 */
public class FindRightInterval {


    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[]{-1};
        }

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }

        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            if (entry != null) {
                res[i] = entry.getValue();
            } else {
                res[i] = -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(1,4);
        intervals[1] = new Interval(2,3);
        intervals[2] = new Interval(3,4);

        FindRightInterval instance = new FindRightInterval();
        instance.findRightInterval(intervals);
    }
}

/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
