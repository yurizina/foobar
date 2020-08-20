package foobar;

public class HelperTree {

	public static void trees() {
		// Create a binary tree, and elements automatically
	  class Node {

			private int data;//?? 
			private Node left;
			private Node right;

			//constructor for each Node from TREE
			public Node(int data) {
				this.data = data;
				left = right = null;
			}
			public Node insertion(int[] arr, Node root, int i) {
				if (i < arr.length) {
					Node temp = new Node(arr[i]);
					root = temp;
					root.left = insertion(arr, root.left, 2 * i +1);
					root.right = insertion(arr, root.right, 2 * i + 2);
				}
				return root;
			}

			public int getData() {
				return data;
			}

			public void setData(int data) {
				this.data = data;
			}

			public Node getLeft() {
				return left;
			}

			public void setLeft(Node left) {
				this.left = left;
			}

			public Node getRight() {
				return right;
			}

			public void setRight(Node right) {
				this.right = right;
			}
	
		}
      //Create the binary TREE 
	  class BinaryTree {
		  private Node root;
		  private int size;
		  
		  //default constructor 
		  public BinaryTree(){
			 this.root = null;
			 this.size = 0; 
		  }
		  //constructor to create the TREE
		  public BinaryTree(Node root) {
			  this.root = root;
			  this.size = 1; 
		  }
		  //Adding elements to each NODE
		  public void addNote(Node newNode, Node parent, String side) {
			  
			  if (side.equals("left")) {
				  newNode.setLeft(parent.getLeft());
				  parent.setLeft(newNode);
			  } else if(side.equals("right")) {
				  newNode.setRight(parent.getRight());
				  parent.setRight(newNode);
			  }
			  size++;
		  }
		  //Transversal Post-Order
		  public void postOrder(Node node) {
			  if(node == null) {
					return;
				}
				
				postOrder(node.getLeft());
				postOrder(node.getRight());
				System.out.println(node.data);

		  }
		  
		  public void postOrderprinter() {
			  postOrder(root);
		  }
	   }
	  
	  //Instantiate the TREE 
	  
	  BinaryTree tree = new BinaryTree();
	  int height = 5;
		int elements = 1;
		for (int b = 1; b <= height; b++) {
			elements = 2 * elements;
			System.out.println(elements);
		}
		
		int[] data = new int[elements];
		for (int i = 1; i < data.length; i++) {
			//data[i] = i;
			System.out.println(data[i]);
		}
		
	  tree.root.insertion(data, tree.root, 0);
	  tree.postOrderprinter();
	  	  
		/*
		 * tree.root = new Node (elements); tree.root.left = new Node(elements+1);
		 * tree.root.right = new Node(elements+2); tree.root.left.left = new
		 * Node(elements+3); tree.root.left.right = new Node(elements+4);
		 * tree.root.right.left = new Node (elements+5); tree.root.right.right = new
		 * Node (elements+6);
		 */
		
	 
	
	}

////////////////////////////
public static void trees2() {
	// Create a binary tree, and elements automatically
	class Node {

		private int data;// ??
		private Node left;
		private Node right;

		// constructor for each Node from TREE
		public Node(int data) {
			this.data = data;
			left = right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}
	// Create the binary TREE
	class BinaryTree {
		private Node root;
		private int size;

		// default constructor
		public BinaryTree() {
			this.root = null;
			this.size = 0;
		}

		// constructor to create the TREE
		public BinaryTree(Node root) {
			this.root = root;
			this.size = 1;
		}

		// Adding elements to each NODE
		public void addNode(Node newNode, Node parent, String side) {

			if (side.equals("left")) {
				newNode.setLeft(parent.getLeft());
				parent.setLeft(newNode);
			} else if (side.equals("right")) {
				newNode.setRight(parent.getRight());
				parent.setRight(newNode);
			}
			size++;
		}

		// Transversal Post-Order
		public void postOrder(Node node) {
			if (node == null) {
				return;
			}

			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.println(node.data);

		}

		public void postOrderprinter() {
			postOrder(root);
		}
	}

	// Instantiate the TREE
	
	int height = 5;
	int elements = 1;
	for (int b = 1; b <= height; b++) {
		elements = 2 * elements;
		System.out.println(elements);
	}

	Node n1 = new Node(elements);
	BinaryTree tree = new BinaryTree(n1);
	
	for (int i = elements; elements < 0; i--) {
		
	}
	

	tree.root = new Node(elements);
	tree.root.left = new Node(elements - 1);
	tree.root.right = new Node(elements - 2);
	tree.root.left.left = new Node(elements - 3);
	tree.root.left.right = new Node(elements - 4);
	tree.root.right.left = new Node(elements - 5);
	tree.root.right.right = new Node(elements - 6);

	tree.postOrderprinter();

}

///////////////////////
public static void trees3() {
	// Create a binary tree, and elements automatically
  class Node {

		private int data;//?? 
		private Node left;
		private Node right;

		//constructor for each Node from TREE
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
		

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}
  //Create the binary TREE 
  class BinaryTree {
	  private Node root;
	  private int size;
	  
	  public Node insertion(int[] arr, Node root, int i) {
			if (i < arr.length) {
				Node temp = new Node(arr[i]);
				root = temp;
				root.left = insertion(arr, root.left, (2 * i) + 1);
				root.right = insertion(arr, root.right, (2 * i) + 2);
			}
			return root;
		}
	  //default constructor 
	  public BinaryTree(){
		 this.root = null;
		 this.size = 0; 
	  }
	  //constructor to create the TREE
	  public BinaryTree(Node root) {
		  this.root = root;
		  this.size = 1; 
	  }
	  //Adding elements to each NODE
	  public void addNote(Node newNode, Node parent, String side) {
		  
		  if (side.equals("left")) {
			  newNode.setLeft(parent.getLeft());
			  parent.setLeft(newNode);
		  } else if(side.equals("right")) {
			  newNode.setRight(parent.getRight());
			  parent.setRight(newNode);
		  }
		  size++;
	  }
	  //Transversal Post-Order
	  public void postOrder(Node node) {
		  if(node == null) {
				return;
			}
			
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.data);

	  }
	  
	  public void postOrderprinter() {
		  postOrder(root);
	  }
   }
  
  //Instantiate the TREE 
  
  BinaryTree tree = new BinaryTree();
  //I can include the height from program here 
  int height = 5;
	int elements = 1;
	for (int b = 1; b <= height; b++) {
		elements = 2 * elements;
		System.out.println(elements);
	}
	
	int[] data = new int[elements];
	for (int i = 1; i < data.length; i++) {
		data[i] = i;
		System.out.println(data[i]);
	}
	
  tree.insertion(data, tree.root, 0);
  
  tree.postOrder(tree.root);
  	  
	/*
	 * tree.root = new Node (elements); tree.root.left = new Node(elements+1);
	 * tree.root.right = new Node(elements+2); tree.root.left.left = new
	 * Node(elements+3); tree.root.left.right = new Node(elements+4);
	 * tree.root.right.left = new Node (elements+5); tree.root.right.right = new
	 * Node (elements+6);
	 */

}

////////////////////////
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
		
		public void findParent(Node node, int val, int parent) {
			
			if (node == null)
				return;

			// If current node is the required node
			if (node.data == val) {

				// Print its parent
				//System.out.println(parent);
				a = parent;
				
			} else {

				// Recursive calls for the children
				// of the current node
				// Current node is now the new parent
				findParent(node.left, val, node.data);
				findParent(node.right, val, node.data);
			}

		}
	
	}
	
	class BinaryTree {

		public Node root;

		public Node insertLevelOrder(int[] arr, Node root, int i) {
			// Base case for recursion
			if (i == 0) {
				Node temp = new Node(arr[1]);
				root = temp;

				// insert left child
				root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

				// insert right child
				root.right = insertLevelOrder(arr, root.right, 2 * i + 2);

			} else if (i < arr.length - 1) {

				Node temp = new Node(arr[i + 1]);
				root = temp;

				// insert left child
				root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

				// insert right child
				root.right = insertLevelOrder(arr, root.right, 2 * i + 2);

			}
			return root;
		}

		public int sort[];
		
		public void sizeArray(int a) {	
			sort = new int[a];
		}

		int i = 1;

		public void postOrder(Node root) {

			if (root != null) {
				postOrder(root.left);
				postOrder(root.right);
				//System.out.print(root.data);
				//System.out.print(i);
				sort[i] = root.data;
				//System.out.print(sort[i]);
				//System.out.print(" ");
				i++;
			}

		}

	}

	BinaryTree tree = new BinaryTree();

	int height = h;
	int elements = 1;
	for (int b = 1; b <= height; b++) {
		elements = 2 * elements;
		//System.out.println(elements);
	}

	int[] data = new int[elements];
	for (int i = 0; i < data.length - 1; i++) {
		data[i + 1] = i + 1;
		//System.out.println(data[i]);
	}

	// populate my tree
	tree.root = tree.insertLevelOrder(data, tree.root, 0);
	int[] sort = new int[elements];
	// transversal order of the tree
	tree.sizeArray(elements);
	tree.postOrder(tree.root);
	//System.out.println(" ");

	// finding element tree
	int[] solution = new int[q.length];
	
	for (int z = 0; z < q.length; z++) {
		
		tree.root.findParent(tree.root, tree.sort[q[z]], -1);
		
		
		int c;
		for (c = 0; c < sort.length; c++) {
					
			if (tree.sort[c] == tree.root.a) {
				
				//System.out.print(c + "\n");
				solution[z] = c;
				//System.out.println(solution[z]);
			}
		}
		if (tree.root.a == -1) {
			c = -1;
			//System.out.println(-1);
			solution[z] = c;
		}
	}
	
	// answer for each element
	return solution;
}
}
