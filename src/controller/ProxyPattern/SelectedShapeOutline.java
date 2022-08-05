package controller.ProxyPattern;

import controller.NullShape;
import controller.SelectedShapeList;
import controller.DrawnShapeList;
import controller.commands.CreateShapeCommand;
import model.ShapeType;
import model.interfaces.ISelectedShapeOutline;
import view.interfaces.PaintCanvasBase;

public class SelectedShapeOutline implements ISelectedShapeOutline {
    DrawRectangleOutline drawRectangleOutline = new DrawRectangleOutline();
    DrawEllipseOutline drawEllipseOutline = new DrawEllipseOutline();
    DrawTriangleOutline drawTriangleOutline = new DrawTriangleOutline();
    PaintCanvasBase paintCanvas;
    public SelectedShapeOutline(PaintCanvasBase paintCanvas){
        this.paintCanvas = paintCanvas;
    }
    @Override
    public void shapeOutline() {
        System.out.println("DrawnList : "+ DrawnShapeList.getList());
        System.out.println("Selected List : "+SelectedShapeList.selectedShapes);
        for (CreateShapeCommand drawnshape : DrawnShapeList.getList()) {
            for (CreateShapeCommand selectedshape : SelectedShapeList.selectedShapes) {
                if (selectedshape.equals(drawnshape)) {
                    if(selectedshape.shapeConfig.shapeType == ShapeType.RECTANGLE)
                    {
                        drawRectangleOutline.Draw(selectedshape, paintCanvas);
                    }
                    else if (selectedshape.shapeConfig.shapeType == ShapeType.ELLIPSE)
                    {
                        drawEllipseOutline.Draw(selectedshape,paintCanvas);
                    }
                    else if (selectedshape.shapeConfig.shapeType == ShapeType.TRIANGLE)
                    {
                        drawTriangleOutline.Draw(selectedshape,paintCanvas);
                    }
                    else
                    {
                        new NullShape();
                    }
                }
                }
            }
        }
    }