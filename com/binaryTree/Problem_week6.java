package Algorithm.com.binaryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;

public class Problem_week6 {
	BufferedReader br = null;
	
	public static void main(String[] args) {
		Problem_week6 problem = new Problem_week6();
		
		problem.run();
	}
	
	public BinarySearchTree<Person> bst; // binarytree
	
	public void csvFileRead() {
		try {
			br = Files.newBufferedReader(Paths.get("C:\\Users\\sehunkim\\Desktop\\WorkSpace\\Java_algorithm\\Algorithm_week6\\address_book2020.csv"));
			String line = "";
			
			bst = new BinarySearchTree<>();
			
			while((line = br.readLine()) != null) {
				String array[] = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				Person person = new Person(array);
				
				BinarySearchTree.Node<Person> personNode = new BinarySearchTree.Node<Person>(person);
				bst.treeInsert(bst, personNode);
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void find(BinarySearchTree<Person> tree, String name, boolean flag) {
		BinarySearchTree<Person> person = tree.treeNameSearch(tree, name, flag);
		if(person == null) {
			System.out.println("this name is not exsist");
		}
		else {
			person.root.data.print();
		}
	}
	
	public void delete(BinarySearchTree<Person> tree, String name) {
		BinarySearchTree<Person> person = tree.treeNameSearch(tree, name, false);
		if(person == null) {
			System.out.println("this name is not exsist");
		}
		else {
			tree.delete(person.root.data);
		}
	}
	
	public void inorder(BinarySearchTree<Person> tree) {
		if(tree != null) {
			inorder(tree.getLeftSubTree());
			tree.root.data.print();
			inorder(tree.getRightSubTree());
		}
	}
	
	public void fileSave(BinarySearchTree<Person> tree, FileWriter filewriter) {
		if(tree != null) {
			try {
				filewriter.write(tree.root.data.all);
				filewriter.write("\n");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			fileSave(tree.getLeftSubTree(), filewriter);
			fileSave(tree.getRightSubTree(), filewriter);
		}
	}
	
	public void run() {
		label:
		while(true) {
			System.out.println("$ ");
			Scanner kb = new Scanner(System.in);
			String cmd = kb.next();
			
			//System.out.println(cmd);
			
			switch(cmd) {
			case "read":
				csvFileRead();
				break;
				
			case "list":
				inorder(bst);
				break;
				
			case "find":
				String name = kb.next();
				find(bst, name, false);
				break;
				
			case "trace":
				name = kb.next();
				find(bst, name, true);
				break;
				
			case "delete":
				name = kb.next();
				delete(bst, name);
				break;
				
			case "save":
				name = kb.next();
				try {
					FileWriter fileWriter = new FileWriter(name);
					fileSave(bst, fileWriter);
					fileWriter.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				
				break;
			
			case "exit":
				break label;
			}
		}
	}
}