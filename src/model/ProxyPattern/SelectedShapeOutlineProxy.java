package model.ProxyPattern;

import controller.commandPattern.CreateShapeCommand;
import controller.commandPattern.MoveShapeCommand;
import controller.commandPattern.SelectShapeCommand;
import model.ProxyPattern.SelectedShapeOutline;
import model.interfaces.ISelectedShapeOutline;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class SelectedShapeOutlineProxy implements ISelectedShapeOutline {

    private SelectedShapeOutline selectedShapeOutline;

    private PaintCanvasBase paintCanvas;

    private CreateShapeCommand Shape;
    Point p1;
    Point p2;

    private SelectShapeCommand selectShapeCommand = null;
    private MoveShapeCommand moveShapeCommand = null;

    public SelectedShapeOutlineProxy(Point p1, Point p2, PaintCanvasBase paintCanvas) {
        this.p1 = p1;
        this.p2 = p2;
        this.paintCanvas = paintCanvas;
        selectedShapeOutline = new SelectedShapeOutline(paintCanvas);
    }

    @Override
    public void shapeOutline() {
        selectedShapeOutline.shapeOutline();
    }
}
