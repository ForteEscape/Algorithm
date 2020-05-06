package Algorithm.com.binaryTree;

import java.util.Comparator;
import java.util.Arrays;

public class Person implements Comparable<Person>{
	public String name, company, address, zipCode, phoneNum, email;
	public String all;
	
	public Person(String[] s) {
		String[] sArray = Arrays.copyOf(s, s.length);
		this.name = sArray[0].trim();
		this.company = sArray[1].trim();
		this.address = sArray[2].trim();
		this.zipCode = sArray[3].trim();
		this.phoneNum = sArray[4].trim();
		this.email = sArray[5].trim();
		this.all = s[0]+","+s[1]+","+s[2]+","+s[3]+","+s[4]+","+s[5];
	}
	
	public void print() {
		System.out.println("name : " + this.name);
		System.out.println("company : " + this.company);
		System.out.println("address : " + this.address);
		System.out.println("zipCode : " + this.zipCode);
		System.out.println("phoneNum : " + this.phoneNum);
		System.out.println("email : " + this.email);
		//System.out.println("all : " + this.all);
	}
	
	public static Comparator<Person> nameComparator = new Comparator<Person>() {
		public int compare(Person person1, Person person2) {
			return person1.name.compareTo(person2.name);
		}
	};
	
	public static Comparator<Person> addressComparator = new Comparator<Person>() {
		public int compare(Person person1, Person person2) {
			return person1.address.compareTo(person2.address);
		}
	};
	
	@Override
	public int compareTo(Person o) {
		
		if(this.name.compareTo(o.name) < 0) {
			return -1;
		}
		else if(this.name.compareTo(o.name) == 0) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
