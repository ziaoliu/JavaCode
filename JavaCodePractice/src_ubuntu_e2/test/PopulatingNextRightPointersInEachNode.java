package test;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode {
	public class Solution {
		public void connect(TreeLinkNode root) {
			if (root == null)
				return;
			List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
			list.add(root);
			int preCount = 1;
			int curCount = 0;
			while (list.size() > 0) {
				TreeLinkNode node = list.remove(0);
				preCount--;
				if (node.left != null) {
					list.add(node.left);
					curCount++;
				}
				if (node.right != null) {
					list.add(node.right);
					curCount++;
				}
				if (preCount > 0)
					node.next = list.get(0);
				if (preCount == 0) {
					preCount = curCount;
					curCount = 0;
					// node.next = null;
				}
			}
		} // end of method
	}
}
