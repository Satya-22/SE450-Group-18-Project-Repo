package view.gui;

import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class PaintCanvas extends PaintCanvasBase {

//   private CreateShape createShape;
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D)g;
    }

//    public PaintCanvas(ShapeList shapeList){
//        this.shapeList = shapeList;
//    }

//    @Override
//    public void update() {
//        repaint();
//    }
//
//    public void paintComponent(Graphics g){
////
//        for (CreateShape shape : shapeList.getList()) {
//            g.setColor(Color.WHITE);
//     		g.fillRect(0, 0, 2560, 1440);
//
//        }
    }

