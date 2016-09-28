package test;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnaLine {
	public class Solution {
		public int maxPoints(Point[] points) {
			int max = 0;

			if (points == null)
				return max;

			for (int i = 0; i < points.length; i++) {
				int localMax = 1;
				int samePoint = 0;
				Map<Double, Integer> map = new HashMap<>();
				Point p1 = points[i];
				for (int j = i + 1; j < points.length; j++) {
					Point p2 = points[j];
					if (p1.x == p2.x && p1.y == p2.y) {
						samePoint++;
						continue;
					}

					double k = 0.0;
					if (p1.x == p2.x)
						k = (int) Integer.MAX_VALUE;
					else if (p1.y == p2.y)
						k = 0.0;
					else
						k = (double) (p1.y - p2.y) / (double) (p1.x - p2.x);

					if (map.containsKey(k))
						map.put(k, map.get(k) + 1);
					else
						map.put(k, 2);
				}

				for (Integer local : map.values())
					localMax = Math.max(localMax, local);

				max = Math.max(localMax + samePoint, max);
			}

			return max;
		}
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}