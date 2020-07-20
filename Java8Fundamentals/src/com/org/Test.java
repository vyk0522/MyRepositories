package com.org;

public class Test {
    public static void main(String[] args) {
        Rectable rectable = new Rectable();
        rectable.setHeight(10);
        rectable.setWidth(20);
        System.out.println(rectable.calculateArea());

        Rectable square = new Square();
        square.setHeight(10);
        square.setWidth(20);
        System.out.println(square.calculateArea());

    }
}

class Rectable{
    protected int height;
    protected int width;

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int calculateArea(){
      return width * height;
    }
}

class Square extends Rectable{

    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }

    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

}
