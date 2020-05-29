package Algorithm.com.Others.homework3;

public class Triangle extends Shape {
    int current_posX, current_posY;
    double width, height;

    Triangle(int current_posX, int current_posY, double width, double height){
        this.current_posX = current_posX;
        this.current_posY = current_posY;
        this.width = width;
        this.height = height;
    }


    public double calcArea(){
        double area = 0;
        area = width * height * 0.5; // calcuation of Triangle area
        return area;
    }
}