import java.util.Stack;

/**
* 自从Homebrew作者被Google搞了一波后，赶紧学个反转二叉树压压惊.
* 反转二叉树，就是左右节点进行交换，可见根节点是不变的。
* 例如：         4
*             /   \
*           2       7
*         /   \   /   \
*        1    3  6     9
*
* 反转为：        4
*             /   \
*           7       2
*         /   \   /   \
*        9    6  3     1
**/
public class ReverseBinaryTree {
	public static void main(String[] args) {
		
	}

	// 递归实现反转二叉树
	public static void reverseTree1(Node root) {
		if (root == null) {
			return;
		}

		reverseTree(root.left);
		reverseTree(root.right);

		Node tmp = root.left;
		root.left = root.right;
		root.right = tmp;
	}

	// 遍历实现二叉树反转
	// 用栈保存当前节点的左右节点，然后pop出来依次反转
	public static void reverseTree2(Node root) {
		Stack<Node> stack = new Stack();

		if (root == null) {
			return;
		}

		stack.push(root);
		Node node = null;
		while (!stack.empty()) {
			root = stack.pop();
			if(root.left != null) {
				stack.push(root.left);
			}
			if(root.right != null) {
				stack.push(root.right);
			}

			tmp = root.left;
			root.left = root.right;
			root.right = tmp;
		}
	}
} 