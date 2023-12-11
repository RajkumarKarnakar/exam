class LinkedList {

	static class Node {
		private int data;
		private Node next;

		public Node() {
			data = 0;
			next = null;
		}

		public Node(int value) {
			data = value;
			next = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}

	}

	private Node head;

	public LinkedList() {
		head = null;

	}

	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void display() {
		if (head == null) {
			throw new RuntimeException("EmptyListException");
		} else {

			Node travel = head;
			while (travel != null) {
				System.out.print(travel.data + " ");
				travel = travel.next;
			}

		}
	}

	public int get(int index) {
		if (head == null) {
			throw new RuntimeException("EmptyListException");
		} else {
			Node travel = head;
			int i = 0;
			while (travel != null) {
				if (i == index) {
					return travel.data;
				}
				i++;
			}
			throw new RuntimeException("NoElementFound");
		}
	}

	public int remove(int index) {
		int retVal = -1;
		if (head == null) {
			throw new RuntimeException("EmptyListException");
		}
		if (index == 0) {
			retVal = head.data;
			head = head.next;
			return retVal;
		} else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				if (current.next == null) {
					retVal = current.next.data;
					return retVal;
				}
				current = current.next;
			}
			current.next = current.next.next;
			retVal = current.data;
			return retVal;
		}
	}

	public void remove1(int index) {
		if (head == null) {
			return;
		}
		if (index == 0) {
			head = head.next;
		} else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				if (current.next == null) {
					return;
				}
				current = current.next;
			}
			current.next = current.next.next;
		}
	}

	public int size() {
		int size = 0;
		if (head == null) {
			throw new RuntimeException("EmptyListException");
		} else {
			Node travel = head;
			while (travel != null) {
				size++;
				travel = travel.next;
			}
		}
		return size;
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + "]";
	}

}
