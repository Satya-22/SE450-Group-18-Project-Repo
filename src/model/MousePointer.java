package model;

import java.awt.*;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;
import controller.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controller.CreateShape;
import model.interfaces.IShapeList;
public class MousePointer extends MouseAdapter {
    private Point startPoint;
    private Point endPoint;
    public  PaintCanvasBase paintCanvas;
    public ApplicationState appstate;

    public IShapeList shapeList;


    public MousePointer(PaintCanvasBase paintCanvas, ApplicationState appstate,IShapeList shapeList){
        this.paintCanvas =  paintCanvas;
        this.appstate = appstate;
        this.shapeList = shapeList;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        startPoint = new Point(e.getX(),e.getY());
        System.out.println("Mouse is Pressed");
        System.out.println("Mouse Started at : " + startPoint.getX() + " , " + startPoint.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        endPoint = new Point(e.getX(),e.getY());
        System.out.println("Mouse is Dragged");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        endPoint = new Point(e.getX(),e.getY());

//        Graphics2D g = paintCanvas.getGraphics2D();

        CreateShape createShape = new CreateShape(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY(),appstate,shapeList);
        createShape.execute();

        System.out.println("Mouse is released");
        System.out.println("Mouse Ended at : " + endPoint.getX() + " , " + endPoint.getY());


    }

}
