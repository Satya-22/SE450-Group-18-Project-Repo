package view.interfaces;

import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public interface IDraw {
    void draw(Graphics g);
    int getX();
    int getY();
    int getHeight();
    int getWidth();
    Color getSecondaryColor();
    Color getPrimaryColor();
    ShapeShadingType getShapeShadingType();
    ShapeType getShapeType();
}