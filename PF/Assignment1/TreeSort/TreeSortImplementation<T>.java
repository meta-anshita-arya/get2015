//class to perform binary search tree operations
public class TreeSortImplementation<T> {
	int index = 0;

	// Function to insert elements in a BST
	public Node<T> insertTree(Node<T> node, int element) {
		if (node == null) {
			node = new Node<T>(element);
		}

		else {
			if (node.data > element) {
				node.left = insertTree(node.left, element);
			} else {
				node.right = insertTree(node.right, element);
			}
		}
		return node;
	}

	// To perform in order traversal and store sorted elements in an array
	public int[] inorder(Node<T> node, int result[]) {
		if (node != null) {
			result = inorder(node.left, result);
			result[index] = node.data;
			index++;
			result = inorder(node.right, result);
		}
		return result;
	}
}
