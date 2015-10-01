/**
* 反转单链表
* 
*/
public class ReverseSingleList {

	public static void main(String[] args) {
		Node head = buildList(10);
		printList(head);
		head = traversingReverse(head);
		printList(head);
	}

	// 遍历方式反转链表
	public static Node traversingReverse(Node head) {
		Node result = null;
		Node temp = null;

		// 头反转法：把当前节点拿过来作为已经翻转结果的表头
		while (head != null) {
			temp = head.next; // 保存下一个节点
			head.next = result; // 当前节点放在结果的开头
			result = head; // 当前节点的头
			head = temp; // head指向下一个节点
		}

		return result;
	}

	// 建立链表
	private static Node buildList(int size) {
		Node head = null;
		Node now = null;

		// 头插入法
		for (int i = 0; i < size; i++) {
			now = new Node(i);
			now.next = head;
			head = now;
		}

        return head;
	}

	// 打印链表
	private static void printList(Node head) {
		Node h = head;   

        while (h != null) {   
            System.out.print(h.value + " ");   
            h = h.next;   
        }   
        System.out.println();
	}

}

class Node {
	public int value; // 为了操作方便，这里就直接用public修饰符而不用private
	public Node next;

	public Node(int value) {
		this.value = value;
	} 
}