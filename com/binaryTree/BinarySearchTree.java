package Algorithm.com.binaryTree;

public class BinarySearchTree<E extends Comparable<E>> {
	
	// node
	protected static class Node<E>{
		protected E data;
		
		public Node<E> getLeft(){
			return left;
		}
		
		public void setLeft(Node<E> left) {
			this.left = left;
		}
		
		protected Node<E> left;
		
		public Node<E> getRight(){
			return right;
		}
		
		public void setRight(Node<E> right) {
			this.right = right;
		}
		
		protected Node<E> right;
		protected Node<E> parent;
		
		public Node(E data) {
			this.data = data;
			parent = null;
			left = null;
			right = null;
		}
		
		public String toString() {
			return data.toString();
		}
	}
	
	protected Node<E> root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	protected BinarySearchTree(Node<E> root) {
		this.root = root;
	}
	
	// tree
	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		root = new Node<E>(data); // root node 만들기
		if(leftTree != null) {
			root.left = leftTree.root;
		}
		else {
			root.left = null;
		}
		
		if(rightTree != null) {
			root.right = rightTree.root;
		}
		else {
			root.right = null;
		}
	}
	
	public BinarySearchTree<E> getLeftSubTree(){
		if(root != null && root.left != null) {
			return new BinarySearchTree<E>(root.left);
		}
		else {
			return null;
		}
	}
	
	public BinarySearchTree<E> getRightSubTree(){
		if(root != null && root.right != null) {
			return new BinarySearchTree<E>(root.right);
		}
		else {
			return null;
		}
	}
	
	public BinarySearchTree<E> treeSearch(BinarySearchTree<E> x, E k){
		if(x == null || k.equals(x.root.data)) {
			return x;
		}
		if(k.compareTo(x.root.data) < 0) {
			return treeSearch(x.getLeftSubTree(), k);
		}
		else {
			return treeSearch(x.getRightSubTree(), k);
		}
	}
	
	public BinarySearchTree<Person> treeNameSearch(BinarySearchTree<Person> x, String name, boolean flag){
		if(x == null || name.equals(x.root.data.name)) {
			return x;
		}
		if(name.compareTo(x.root.data.name) < 0) {
			if(flag && x.getLeftSubTree() != null) {
				System.out.println(x.getLeftSubTree().root.data.name);
			}
			return treeNameSearch(x.getLeftSubTree(), name, flag);
		}
		else {
			if(flag && x.getRightSubTree() != null) {
				System.out.println(x.getRightSubTree().root.data.name);
			}
			return treeNameSearch(x.getRightSubTree(), name, flag);
		}
	}
	
	//del
	public boolean delete(E id) {
		Node<E> parent = root;
		Node<E> current = root;
		
		boolean isLeftChild = false;
		
		while(current.data != id) {
			parent = current;
			if(current.data.compareTo(id) > 0) {
				isLeftChild = true;
				current = current.getLeft();
			}
			else {
				isLeftChild = false;
				current = current.getRight();
			}
			if(current == null) {
				return false;
			}
		}
		
		if(current.getLeft() == null && current.getRight() == null) { // 노드의 자식 노드가 없는 경우
			if(current == root) { // 그 노드가 root 일때
				root = null;
			}
			if(isLeftChild == true) {
				parent.setLeft(null);
			}
			else {
				parent.setRight(null);
			}
		}
		else if(current.getRight() == null) { // 노드의 자식 노드가 하나일 때(왼쪽)
			if(current == root) {
				root = current.getLeft();
			}
			else if(isLeftChild) {
				parent.setLeft(current.getLeft());
			}
			else {
				parent.setRight(current.getRight());
			}
		}
		else if(current.getLeft() == null) { // 노드의 자식 노드가 하나일 때(오른쪽)
			if(current == root) {
				root = current.getRight();
			}
			else if(isLeftChild) {
				parent.setLeft(current.getRight());
			}
			else {
				parent.setRight(current.getRight());
			}
		}
		else if(current.getLeft() != null && current.getRight() != null) { // 자식 노드가 둘일때
			Node successor = getSuccessor(current);
			if(current == root) {
				root = successor;
			}
			else if(isLeftChild) {
				parent.setLeft(successor);
			}
			else {
				parent.setRight(successor);
			}
			
			successor.setLeft(current.getLeft());
		}
		
		return true;	
	}
	
	public Node<E> getSuccessor(Node<E> deleteNode){
		Node<E> successor = null;
		Node<E> successorParent = null;
		Node<E> current = deleteNode.getRight();
		
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}
		if(successor != deleteNode.getRight()) {
			successorParent.setLeft(successor.getRight());
			successor.setRight(deleteNode.getRight());
		}
		return successor;
	}
	
	public BinarySearchTree<E> treeInsert(BinarySearchTree<E> T, Node<E> z){
		BinarySearchTree<E> y = null;
		BinarySearchTree<E> x = T;
		
		if(x.root == null) {
			x.root = z;
			return T;
		}
		
		while(x != null) {
			y = x;
			if(z.data.compareTo(x.root.data) < 0) {
				x = x.getLeftSubTree();
			}
			else {
				x = x.getRightSubTree();
			}
		}
		
		if(y == null) {
			T.root = z;
		}
		else {
			if(z.data.compareTo(y.root.data) > 0) {
				y.root.right = z;
			}
			else {
				y.root.left = z;
			}
		}
		
		return T;
	}
}
