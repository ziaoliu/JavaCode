package test;

import java.util.HashMap;
import java.util.LinkedList;

public class CloneGraph {
	public class Solution {
		public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
			if (node == null)
				return null;
			LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
			queue.add(node);
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
			UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
			map.put(node, clone);
			while (queue.size() > 0) {
				UndirectedGraphNode orig = queue.remove(0);
				for (UndirectedGraphNode tmp : orig.neighbors) {
					if (!map.containsKey(tmp)) {
						// set pairs in map first to reference existing nodes
						map.put(tmp, new UndirectedGraphNode(tmp.label));
						queue.add(tmp);
					}
					map.get(orig).neighbors.add(map.get(tmp));
				}
			}
			return map.get(node);
		}
	}
}
