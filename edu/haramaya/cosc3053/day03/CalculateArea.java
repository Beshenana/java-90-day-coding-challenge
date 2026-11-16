package edu.haramaya.cosc3053.day03;

public class CalculateArea {
    int length;
    int width;

    int calculatearea(int l , int w){
        int area =l*w;
        return area;
     }
public static void main(String[] args) {
        CalculateArea area1=new CalculateArea();
        area1.length=5;
        area1.width=10;

        System.out.println("Area of rectangle is: "+area1.calculatearea(area1.length,area1.width));

    }

}
