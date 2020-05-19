package Algorithm.com.Others.homework1;

public class GraduateStudent extends Student {

    public String labName = "";
    public int donate = 0;

    GraduateStudent(String name, String department, int studentNumber, int grade, String labName, int donate) {
        super(name, department, studentNumber, grade);
        this.labName = labName;
        this.donate = donate;
    }
    
    public void print(){
        System.out.println("name : " + name);
        System.out.println("department : " + department);
        System.out.println("studentNumber : " + studentNumber);
        System.out.println("labName : " + labName);
        System.out.println("grade : " + grade);
        System.out.println("money : " + donate);
    }
    
}