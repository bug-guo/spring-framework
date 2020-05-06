package com.smart.smile;

/**
 * @Author Zhiguo Chen
 * @Date 2020/3/2 10:30
 */
public class Test {
	class Node {
		int value;
		Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public Node(int value) {
			this.value = value;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Test demo = new Test();
		Node node1 = demo.new Node(1);
		Node node2 = demo.new Node(2);

	}

	public Node calc(Node node1, Node node2) {
		Node root = null, cur = null;
		int sum = 0;
		while (node1 != null && node2 != null) {
			int value1 = node1.value;
			int value2 = node2.value;
			sum += value1 + value2;
			int result = 0;
			if (sum > 10) {
				result = sum % 10;
				sum = sum / 10;
			} else {
				result = sum;
			}
			Node node = new Node(result);
			if (root == null) {
				root = node;
				cur = root;
			} else {
				cur.next = node;
				cur = node;
			}

			node1 = node1.next;
			node2 = node2.next;
		}

		while (node1 != null) {
			sum += node1.value;
			int result = 0;
			if (sum > 10) {
				result = sum % 10;
				sum = sum / 10;
			} else {
				result = sum;
			}
			Node node = new Node(result);
			cur.next = node;
			node1 = node1.next;
		}

		while (node2 != null) {
			sum += node2.value;
			int result = 0;
			if (sum > 10) {
				result = sum % 10;
				sum = sum / 10;
			} else {
				result = sum;
			}
			Node node = new Node(result);
			cur.next = node;
			cur = node;
			node2 = node2.next;
		}

		if (sum > 0) {
			Node node = new Node(sum);
			cur.next = node;
		}

		return root;
	}

	public int calc2(int[] data, int sum) {
		int n = data.length;
		int result = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			result = 0;
			for (int j = i; j < n; j++) {
				result += data[j];
				if (result >= sum) {
					max = Math.max(max, j - i + 1);
				}
			}
		}
		return max;
	}


}
