package view.gui;

import java.awt.*;
import controller.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.IDraw;

public class Rectangle implements IDraw {

    public Graphics g;
    private int x;
    private int y;
    private int x2;
    private int y2;
    private ShapeShadingType sst;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;

    private Point point;

    ApplicationState appstate;

    public Rectangle(int x, int y, int x2, int y2, ShapeColor primaryColor,ShapeColor secondaryColor,ApplicationState appstate){
        this.x =x;
        this.y = y;
        this.x2 =x2;
        this.y2 = y2;
        this.appstate = appstate;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    public void draw(Graphics g) {

        System.out.println("Draw Rectangle");


        int px = Math.min(x, x2);
        int py = Math.min(y, y2);
        int pw = Math.abs(x - x2);
        int ph = Math.abs(y - y2);

        g.setColor(primaryColor.getAwtColor());
        System.out.println("Primary Color : "+ primaryColor.getAwtColor());
        g.fillRect(px,py,pw,ph);
        System.out.println("Rectangle Parameters: "+ px+" "+py+" "+pw+" "+ph);
        g.setColor(secondaryColor.getAwtColor());
        System.out.println("SecondaryColor : " +secondaryColor.getAwtColor());
        g.drawRect(px, py, pw, ph);
    }




    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public Color getSecondaryColor() {
        return null;
    }

    @Override
    public Color getPrimaryColor() {
        return null;
    }

    @Override
    public ShapeShadingType getShapeShadingType() {
        return null;
    }

    @Override
    public ShapeType getShapeType() {
        return null;
    }
//
//    @Override
//    public Graphics getG() {
//        return g;
//    }
//    @Override
//    public int getX() {
//        return x;
//    }
//    @Override
//    public int getY() {
//        return y;
//
//    }
//    @Override
//    public int getX2() {
//        return x2;
//    }
//    @Override
//    public int getY2() {
//        return y2;
//    }
//    @Override
//    public void setG(Graphics g) {
//        this.g = g;
//    }
//    @Override
//    public ShapeShadingType getSst() {
//        return sst;
//    }
//    @Override
//    public void setSst(ShapeShadingType sst) {
//        this.sst = sst;
//    }
//    @Override
//    public Color getContextColor() {
//        return null;
//    }
//    @Override
//    public void setContextColor(Color contextColor) {
//
//    }
//    @Override
//    public Color getSecColor() {
//        return null;
//    }
//    @Override
//    public void setSecColor(Color secColor) {
//
//    }
//
//    @Override
//    public void setAppstate(ApplicationState appstate) {
//        this.appstate = appstate;
//    }
//
//    @Override
//    public ApplicationState getAppstate(ApplicationState appstate) {
//         return appstate;
//    }
//
//    @Override
//    public void setX(int x) {
//        this.x = x;
//    }
//    @Override
//    public void setY(int y) {
//        this.y = y;
//    }
//    @Override
//    public void setX2(int x2) {
//        this.x2 = x2;
//    }
//    @Override
//    public void setY2(int y2) {
//        this.y2 = y2;
//    }
//    @Override
//    public Point getPoint(){
//
//        return point;
//    }
}