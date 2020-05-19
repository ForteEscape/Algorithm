package Algorithm.com.Others.homework1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        String name = "";
        String department = "";
        String labName = "";
        String clanName = "";
        int studentNumber = 0, grade = 0, donate = 0;

        System.out.print("name : ");
        name = sc.nextLine();
        System.out.print("department : ");
        department = sc.nextLine();
        System.out.print("studentNumber : ");
        studentNumber = sc.nextInt();
        System.out.print("grade : ");
        grade = sc.nextInt();

        if(grade > 4){
            System.out.print("labName : ");
            labName = input.nextLine();
            System.out.print("money : ");
            donate = input.nextInt();

            Student gradStudent = new GraduateStudent(name, department, studentNumber, grade, labName, donate);

            System.out.println("");
            gradStudent.print();
        }
        else{
            System.out.print("clanName : ");
            clanName = input.nextLine();

            UndergraduateStudent underStudent = new UndergraduateStudent(name, department, studentNumber, grade, clanName);

            System.out.println("");
            underStudent.print();
        }

        sc.close();
        input.close();
    }
}