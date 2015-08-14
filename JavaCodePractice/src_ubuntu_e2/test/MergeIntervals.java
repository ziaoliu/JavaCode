package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public class Solution {
		public List<Interval> merge(List<Interval> intervals) {
			List<Interval> result = new ArrayList<Interval>();
			if (intervals == null || intervals.size() == 0)
				return result;

			Comparator<Interval> comparator = new Comparator<Interval>() {
				@Override
				public int compare(Interval o1, Interval o2) {
					if (o1.start == o2.start) {
						if (o1.end == o2.end)
							return 0;
						else
							return o1.end < o2.end ? -1 : 1;
					} else
						return o1.start < o2.start ? -1 : 1;
				}
			};

			Collections.sort(intervals, comparator);

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
			result.add(pre); // <======= don't forget to add the last range (or
								// the only range)
			return result;
		}
	}
}
