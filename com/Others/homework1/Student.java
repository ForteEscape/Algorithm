package Algorithm.com.Others.homework1;

public class Student {
    public String name = "";
    public String department = "";
    public int studentNumber = 0;
    public int grade = 0;

    Student(String name, String department, int studentNumber, int grade){
        this.name = name;
        this.department = department;
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    public void print(){
        System.out.println("name : " + name);
        System.out.println("department : " + department);
        System.out.println("studentNumber : " + studentNumber);
        System.out.println("grade : " + grade);
    }
}