package Algorithm.com.Others.homework3;

public class Homework {
    public static void main(String[] main){
        Shape[] shapes = new Shape[3];

        shapes[0] = new Rectangle(2, 2, 2, 4);
        shapes[1] = new Triangle(5, 5, 3, 4);
        shapes[2] = new Circle(2, 2, 5);

        for(int i = 0; i<3; i++){
            System.out.println("Area of Shape"+i+" : "+shapes[i].calcArea());
        }
    }
}