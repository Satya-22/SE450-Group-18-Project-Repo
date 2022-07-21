package model;

import controller.CreateShapeCommand;
import model.interfaces.IDraw;
import controller.ShapeList;
import view.gui.DrawEllipse;
import view.gui.DrawRectangle;
import view.gui.PaintCanvas;
import view.gui.DrawTriangle;
import view.interfaces.PaintCanvasBase;
import java.awt.*;

public class DrawShape implements IDraw {
    Graphics2D graphics2d;
    ShapeList shapeList;
    public DrawShape(PaintCanvasBase canvas, ShapeList shapeList){
         graphics2d = canvas.getGraphics2D();
         this.shapeList = shapeList;
    }
    @Override
    public void draw(CreateShapeCommand shape, Graphics2D graphics2D) {
        PaintCanvas canvas;
        DrawShape drawShape;
        IDraw shapeStrategy = switch (shape.shapeType) {
            case ELLIPSE -> new DrawEllipse();
            case RECTANGLE -> new DrawRectangle();
            case TRIANGLE -> new DrawTriangle();
            default -> throw new IllegalArgumentException("Invalid shape type");
        };
        shapeStrategy.draw(shape,graphics2d);
        }
        public void update() {
            graphics2d.setColor(Color.WHITE);
            graphics2d.fillRect(0,0,1200,800);

            for (CreateShapeCommand shape : shapeList.getList()) {
                draw(shape, graphics2d);
            }
        }
    }

