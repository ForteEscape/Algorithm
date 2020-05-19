package Algorithm.com.Others.homework1;

public class UndergraduateStudent extends Student{

    public String clanName = "";
    public String name = "";
    public String department = "";
    public int studentNumber = 0;
    public int grade = 0;

    UndergraduateStudent(String name, String department, int studentNumber, int grade, String clanName) {
        super(name, department, studentNumber, grade);
        this.clanName = clanName;
    }
    
    public void print(){
        System.out.println("name : " + super.name);
        System.out.println("department : " + super.department);
        System.err.println("clanName : " + this.clanName);
        System.out.println("studentNumber : " + super.studentNumber);
        System.out.println("grade : " + super.grade);
    }
}