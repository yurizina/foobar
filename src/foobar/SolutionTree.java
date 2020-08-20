package foobar;

public class SolutionTree {
	
	public static int[] trees(int h, int[] q) {

		class Node {

			public int data;
			public Node left;
			public Node right;
			int a;
			
			public Node(int data) {
				this.data = data;
				this.left = null;
				this.right = null;
			}
			
			public void searchParent(Node node, int input, int parent) {
				//Code based upon
				//https://www.geeksforgeeks.org/find-the-parent-of-a-node-in-the-given-binary-tree/
				if (node == null)
					return;

				if (node.data == input) {
					//Once found, storage as int that will be only temporary until next search

					a = parent;
					
				} else {

					//the current node turns to be the new parent
					searchParent(node.left, input, node.data);
					searchParent(node.right, input, node.data);
				}

			}
		
		}
		
		class BinaryTree {

			public Node root;

			public Node insertion(int[] arr, Node root, int i) {
				//Code based upon: 
				//https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/
				//Adding with recursion
				//If first element, counts as index 0 but Node 1
				if (i == 0) {
					Node temporary = new Node(arr[1]);
					root = temporary;

					// insert first/left child
					root.left = insertion(arr, root.left, 2 * i + 1);

					// insert second/right child
					root.right = insertion(arr, root.right, 2 * i + 2);

				} else if (i < arr.length - 1) {
					//When the method has the first node and the first two children 
					//We will create new nodes, and Node (1) is done already

					Node temporary = new Node(arr[i + 1]);
					root = temporary;

					root.left = insertion(arr, root.left, 2 * i + 1);

					root.right = insertion(arr, root.right, 2 * i + 2);

				}
				return root;
			}

			public int sort[];
			//This array will have elements arrranged as postOrder, it works as a LinkedList
			//Every element has its position in the invert Tree. So, height 2, generated tree
			//     1          but we want        3
			//   2   3                        1     2
			// So we order first to 2 3 1 (first tree) then we say that node 2 will be element 1 
			//from the array
			public void sizeArray(int a) {	
				sort = new int[a];
			}

			int i = 1;

			public void postOrder(Node root) {

				if (root != null) {
					postOrder(root.left);
					postOrder(root.right);
					sort[i] = root.data;
					i++;
				}

			}

		}

		BinaryTree tree = new BinaryTree();

		int height = h;
		//Variable from input in this program that means height
		int elements = 1;
		for (int b = 1; b <= height; b++) {
			elements = 2 * elements;
			//We need the number of elements in the Tree, by equation 1+2^n (n >=1)
		}

		//We need an array of elements to populate the Tree, number of elements based upon 
		//elements calculus above 
		int[] data = new int[elements];
		for (int i = 0; i < data.length - 1; i++) {
			//Our first element is 0 and we do not need!
			data[i + 1] = i + 1;	
		}

		// populate my original tree
		tree.root = tree.insertion(data, tree.root, 0);
		
		//int[] sort = new int[elements];
		
		tree.sizeArray(elements);
		//Check the post Order transversal and populate an "LinkedList" type array
		tree.postOrder(tree.root);
		

		// finding elements and return array 
		int[] solution = new int[q.length];
		
		for (int z = 0; z < q.length; z++) {
			//will find the item based upon the value inserted
			//value inserted is the array Sort from class BinaryTree 
			//Each element from the array inserted q is the value to be checked 
			//return the parent node
			tree.root.searchParent(tree.root, tree.sort[q[z]], -1);
			
			int c;
			for (c = 0; c < data.length; c++) {
						
				if (tree.sort[c] == tree.root.a) {
					//Once found it, populate array solution 
					solution[z] = c;
					
				}
			}
			if (tree.root.a == -1) {
				c = -1;
				solution[z] = c;
			}
		}
		
		// answer for each element
		return solution;
	}
}
