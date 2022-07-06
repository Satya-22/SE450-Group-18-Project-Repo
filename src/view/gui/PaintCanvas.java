package view.gui;

import model.interfaces.IUpdateShapeList;
import view.interfaces.PaintCanvasBase;
import java.awt.*;
import view.interfaces.IDraw;
import model.interfaces.IShapeList;
import java.awt.Graphics2D;

public class PaintCanvas extends PaintCanvasBase implements IUpdateShapeList {

    public final IShapeList shapeList;

    public PaintCanvas(IShapeList shapeList) {
        this.shapeList = shapeList;
        shapeList.register(this);
    }

    @Override
    public void update() {
        repaint();
    }
    @Override
    public void paintComponent(Graphics g){
        for (IDraw shape : shapeList.getShapeList()) {
            shape.draw(g);
        }
    }
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

}
