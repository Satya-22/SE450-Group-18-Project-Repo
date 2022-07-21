package model.interfaces;

import java.awt.*;

import model.ShapeColor;
import model.ShapeShadingType;

public interface IShape {
    public void draw();
    public void setPoint1(Point p1);
    public Point getPoint1();
    public void setPoint2(Point p2);
    public Point getPoint2();
    public Graphics getG();
    public void setG(Graphics g);
    public ShapeShadingType getSst();
    public void setSst(ShapeShadingType sst);
    public Color getPrimaryColor();
    public void setPrimaryColor(Color contextColor);
    public Color getSecondaryColor();
    public void setSecondaryColor(Color secondaryColor);
}