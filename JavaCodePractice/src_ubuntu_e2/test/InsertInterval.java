package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
	public class Solution {
		public List<Interval> insert(List<Interval> intervals,
				Interval newInterval) {
			List<Interval> result = new ArrayList<Interval>();
			intervals.add(newInterval);
			Comparator<Interval> c = new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) {
					if (o1.start == o2.start) {
						if (o1.end == o2.end)
							return 0;
						else
							return o1.end < o2.end ? -1 : 1;
					}
					return o1.start < o2.start ? -1 : 1;
				}
			};
			Collections.sort(intervals, c);

			Interval pre = intervals.get(0);
			for (int i = 1; i < intervals.size(); i++) {
				Interval curr = intervals.get(i);
				if (pre.start <= curr.start && curr.start <= pre.end)
					pre.end = Math.max(pre.end, curr.end);
				else {
					result.add(pre);
					pre = curr;
				}
			}
			result.add(pre);
			return result;
		}
	}
}
