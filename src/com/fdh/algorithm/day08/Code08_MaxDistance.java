package com.fdh.algorithm.day08;

import com.fdh.algorithm.day07.BTNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Code08_MaxDistance {



	public static int maxDistance1(BTNode head) {
		if (head == null) {
			return 0;
		}
		ArrayList<BTNode> arr = getPrelist(head);
		HashMap<BTNode, BTNode> parentMap = getParentMap(head);
		int max = 0;
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i; j < arr.size(); j++) {
				max = Math.max(max, distance(parentMap, arr.get(i), arr.get(j)));
			}
		}
		return max;
	}

	public static ArrayList<BTNode> getPrelist(BTNode head) {
		ArrayList<BTNode> arr = new ArrayList<>();
		fillPrelist(head, arr);
		return arr;
	}

	public static void fillPrelist(BTNode head, ArrayList<BTNode> arr) {
		if (head == null) {
			return;
		}
		arr.add(head);
		fillPrelist(head.left, arr);
		fillPrelist(head.right, arr);
	}

	public static HashMap<BTNode, BTNode> getParentMap(BTNode head) {
		HashMap<BTNode, BTNode> map = new HashMap<>();
		map.put(head, null);
		fillParentMap(head, map);
		return map;
	}

	public static void fillParentMap(BTNode head, HashMap<BTNode, BTNode> parentMap) {
		if (head.left != null) {
			parentMap.put(head.left, head);
			fillParentMap(head.left, parentMap);
		}
		if (head.right != null) {
			parentMap.put(head.right, head);
			fillParentMap(head.right, parentMap);
		}
	}

	public static int distance(HashMap<BTNode, BTNode> parentMap, BTNode o1, BTNode o2) {
		HashSet<BTNode> o1Set = new HashSet<>();
		BTNode cur = o1;
		o1Set.add(cur);
		while (parentMap.get(cur) != null) {
			cur = parentMap.get(cur);
			o1Set.add(cur);
		}
		cur = o2;
		while (!o1Set.contains(cur)) {
			cur = parentMap.get(cur);
		}
		BTNode lowestAncestor = cur;
		cur = o1;
		int distance1 = 1;
		while (cur != lowestAncestor) {
			cur = parentMap.get(cur);
			distance1++;
		}
		cur = o2;
		int distance2 = 1;
		while (cur != lowestAncestor) {
			cur = parentMap.get(cur);
			distance2++;
		}
		return distance1 + distance2 - 1;
	}

	public static int maxDistance2(BTNode head) {
		return process(head).maxDistance;
	}

	public static class Info {
		public int maxDistance;
		public int height;

		public Info(int dis, int h) {
			maxDistance = dis;
			height = h;
		}
	}

	public static Info process(BTNode head) {
		if (head == null) {
			return new Info(0, 0);
		}
		Info leftInfo = process(head.left);
		Info rightInfo = process(head.right);
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance),
				leftInfo.height + rightInfo.height + 1);
		return new Info(maxDistance, height);
	}

	// for test
	public static BTNode generateRandomBST(int maxLevel, int maxValue) {
		return generate(1, maxLevel, maxValue);
	}

	// for test
	public static BTNode generate(int level, int maxLevel, int maxValue) {
		if (level > maxLevel || Math.random() < 0.5) {
			return null;
		}
		BTNode head = new BTNode((int) (Math.random() * maxValue));
		head.left = generate(level + 1, maxLevel, maxValue);
		head.right = generate(level + 1, maxLevel, maxValue);
		return head;
	}

	public static void main(String[] args) {
		int maxLevel = 4;
		int maxValue = 100;
		int testTimes = 1000000;
		for (int i = 0; i < testTimes; i++) {
			BTNode head = generateRandomBST(maxLevel, maxValue);
			if (Code02_MaxDistanceBT.computerBTMaxDistance(head) != maxDistance2(head)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}

}
