package com.example.samuraisoarbladerunner;

public class BackgroundImage {
    private int backgroundImageX;
    private int backgroundImageY;
    private final int backgroundImageVelocity;

    public  BackgroundImage(){
        backgroundImageX = 0;
        backgroundImageY = 0;
        backgroundImageVelocity = 3;
    }

    //Getter method for getting the X-coordinates
    public int getX(){
        return backgroundImageX;
    }

    //Getter method for getting the Y-coordinates
    public int getY(){
        return backgroundImageY;
    }

    //Setter method for setting the X-coordinates
    public void setX(int backgroundImageX){
        this.backgroundImageX = backgroundImageX;
    }

    //Setter method for setting the X-coordinates
    public void setY(int backgroundImageY){
        this.backgroundImageY = backgroundImageY;
    }

    //Getter method for getting velocity
    public int getVelocity(){
        return backgroundImageVelocity;
    }

}
