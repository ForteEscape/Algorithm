package Algorithm.com.Others.homework3;

public class Circle extends Shape{
    int current_posX, current_posY;
    double radius;

    final double PI = 3.14;

    Circle(int current_posX, int current_posY, double radius){
        this.current_posX = current_posX;
        this.current_posY = current_posY;
        this.radius = radius;
    }

    public double calcArea(){
        double area = 0;
        area = radius * radius * PI; // calcuation of Circle area
        return area;
    }
}