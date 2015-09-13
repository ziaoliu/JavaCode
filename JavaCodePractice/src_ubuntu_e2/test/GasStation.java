package test;

public class GasStation {
	public class Solution {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			if (gas == null || cost == null || gas.length == 0
					|| cost.length == 0 || gas.length != cost.length)
				return -1;
			int total = 0;
			int sum = 0;
			int i = 0;
			int index = 0;
			for (; i < gas.length; i++) {
				int diff = gas[i] - cost[i];
				sum = sum + diff;
				if (sum < 0) {
					sum = 0;
					index = i + 1;
				}
				total = total + diff;
			}
			return total < 0 ? -1 : index;
		}
	}
}
