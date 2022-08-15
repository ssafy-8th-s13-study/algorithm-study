package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int data;
	Node prev;
	Node next;

	Node(int data) {
		this.data = data;
	}
}

class LinkedList {

	Node head;
	Node tail;
	int size;

	LinkedList(int data) {
		head = new Node(data);
		this.tail = head;
		head.prev = tail;
		tail.next = head;
		size = 1;
	}

	public void add(int data) {

		Node newNode = new Node(data);
		newNode.next = this.head;
		newNode.prev = this.tail;
		this.head.prev = newNode;
		this.tail.next = newNode;
		this.tail = newNode;
		size++;
	}

	public int BN(int i, int j) {
		Node newNode = new Node(j);
		Node cur = head;
		// 고유번호가 i인 역 cur 찾기
		while (cur != null) {
			if (cur.data == i) {
				break;
			}
			if (cur.next == this.head) {
				break;
			}
			cur = cur.next;
		}
		Node nextNode = cur.next;
		cur.next = newNode;
		newNode.next = nextNode;
		nextNode.prev = newNode;
		newNode.prev = cur;
		size++;
		return nextNode.data;
	}

	public int BP(int i, int j) {
		Node newNode = new Node(j);
		Node cur = head;
		// 고유번호가 i인 역 cur 찾기
		while (cur != null) {
			if (cur.data == i) {
				break;
			}
			if (cur.next == this.head) {
				break;
			}
			cur = cur.next;
		}
		Node prevNode = cur.prev;
		cur.prev = newNode;
		newNode.prev = prevNode;
		prevNode.next = newNode;
		newNode.next = cur;
		size++;
		return prevNode.data;
	}

	public int CN(int i) {
		Node cur = this.head;
		// 고유번호가 i인 역 cur 찾기
		while (cur != null) {
			if (cur.data == i) {
				break;
			}
			if (cur.next == this.head) {
				break;
			}
			cur = cur.next;
		}
		int ret = cur.next.data;
		Node deleted = cur.next;
		if (deleted == head) {
			head = deleted.next;
			head.prev = deleted.prev;
			deleted.prev.next = head;
		} else {
			cur.next = deleted.next;
			deleted.next.prev = deleted.prev;
			deleted.prev.next = deleted.next;
		}
		size--;
		return ret;
	}

	public int CP(int i) {
		Node cur = head;
		// 고유번호가 i인 역 cur 찾기
		while (cur != null) {
			if (cur.data == i) {
				break;
			}
			if (cur.next == this.head) {
				break;
			}
			cur = cur.next;
		}
		int ret = cur.prev.data;
		Node deleted = cur.prev;
		if (deleted == head) {
			head = deleted.next;
			head.prev = deleted.prev;
			deleted.prev.next = head;
		} else {
			cur.prev = deleted.prev;
			deleted.prev.next = deleted.next;
			deleted.next.prev = deleted.prev;
		}
		return ret;
	}

	public void print() {
		Node tmp = head;
		if (size >= 2) {
			while (tmp.next != head) {
				System.out.print(tmp.data + " ");
				tmp = tmp.next;
			}
		}
		System.out.println(tmp.data + " ");
	}
}

public class Main_BJ_23309_철도공사 {

	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		LinkedList ll = new LinkedList(Integer.parseInt(st2.nextToken()));
		while (st2.hasMoreTokens()) {
			ll.add(Integer.parseInt(st2.nextToken()));
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			String command = tmp.nextToken();
			int p, q;
			switch (command) {
			case "BN":
				p = Integer.parseInt(tmp.nextToken());
				q = Integer.parseInt(tmp.nextToken());
				sb.append(ll.BN(p, q) + "\n");
				break;
			case "BP":
				p = Integer.parseInt(tmp.nextToken());
				q = Integer.parseInt(tmp.nextToken());
				sb.append(ll.BP(p, q) + "\n");
				break;
			case "CP":
				p = Integer.parseInt(tmp.nextToken());
				sb.append(ll.CP(p) + "\n");
				break;
			case "CN":
				p = Integer.parseInt(tmp.nextToken());
				sb.append(ll.CN(p) + "\n");
				break;
			case "Q":
				ll.print();
			}
		}
		System.out.println(sb);
	}

}
