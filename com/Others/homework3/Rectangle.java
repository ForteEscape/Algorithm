package Algorithm.com.Others.homework3;

public class Rectangle extends Shape {
    int current_posX, current_posY;
    int width, height;

    Rectangle(int current_posX, int current_posY, int width, int height){
        this.current_posX = current_posX;
        this.current_posY = current_posY;
        this.width = width;
        this.height = height;
    }

    public double calcArea(){
        int area = 0;
        area = width * height; // Rectangle's area calcualtion
        return area;
    }
}