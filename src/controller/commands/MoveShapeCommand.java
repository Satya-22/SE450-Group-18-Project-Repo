package controller.commands;

import controller.*;
import controller.DrawShape;
import model.interfaces.ICommand;
import model.interfaces.ISelectedShapesList;
import model.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.LinkedList;

public class MoveShapeCommand implements ICommand, IUndoable, ISelectedShapesList {

    private final PaintCanvasBase paintCanvas;
    private int xDelta;
    private int yDelta;
    private final Point startPoint;
    private final Point endPoint;
    private static boolean undoSelected = false;
    private static boolean redoSelected = false;
    private final LinkedList<CreateShape> tempMoveList;
    private final LinkedList<CreateShape> tempRemoveList;
    private final ShapeList shapeList;

    public MoveShapeCommand(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, ShapeList shapeList) {
        this.paintCanvas = paintCanvas;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        tempMoveList = new LinkedList<>();
        tempRemoveList = new LinkedList<>();
    }
    @Override
    public void run() {
        undoSelected = false;
        redoSelected = false;

        xDelta = endPoint.x - startPoint.x;
        yDelta = endPoint.y - startPoint.y;

        for (CreateShape selectedShape : selectedShapes) {
            for (CreateShape drawnShape : ShapeList.getList()) {
                if (selectedShape.equals(drawnShape)) {
                    tempRemoveList.add(drawnShape);
                    selectedShape.p1 = new Point(selectedShape.p1.x+xDelta, selectedShape.p1.y+yDelta);
                    selectedShape.p2 = new Point(selectedShape.p2.x+xDelta, selectedShape.p2.y+yDelta);
                    tempMoveList.add(selectedShape);
                }
            }
        }

        for (CreateShape temp1 : tempRemoveList) {
            selectedShapes.remove(temp1);
            shapeList.removeShape(temp1);
        }
        for (CreateShape temp1 : tempMoveList) {
            selectedShapes.add(temp1);
            shapeList.addShape(temp1);
        }
        //DrawShape drawShape = new DrawShape(shapeList,paintCanvas);
        DrawShape.update();
        boolean moveSelected = selectedShapes.size() > 0;
        System.out.println(selectedShapes);
        System.out.println(selectedShapes.size());
        CommandHistory.add(this);
    }


    @Override
    public void undo() {
        redoSelected = false;
        undoSelected = tempMoveList.size() > 0;
        for (CreateShape temp1 : tempMoveList) {
            selectedShapes.remove(temp1);
            shapeList.removeShape(temp1);
        }
        for (CreateShape temp1 : tempRemoveList) {
            temp1.p1 = new Point(temp1.p1.x-xDelta, temp1.p1.y-yDelta);
            temp1.p2 = new Point(temp1.p2.x-xDelta, temp1.p2.y-yDelta);
            selectedShapes.add(temp1);
            shapeList.addShape(temp1);
        }

        if (paintCanvas != null) {
           // DrawShape drawShape = new DrawShape(shapeList,paintCanvas);
            DrawShape.update();
        }
    }

    @Override
    public void redo() {
        undoSelected = false;
        redoSelected = tempMoveList.size() > 0;

        for (CreateShape temp1 : tempRemoveList) {
            selectedShapes.remove(temp1);
            shapeList.removeShape(temp1);
        }
        for (CreateShape temp1 : tempMoveList) {
            temp1.p1 = new Point(temp1.p1.x+xDelta, temp1.p1.y+yDelta);
            temp1.p2 = new Point(temp1.p2.x+xDelta, temp1.p2.y+yDelta);
            selectedShapes.add(temp1);
            shapeList.addShape(temp1);
        }
        if (paintCanvas != null) {
            //DrawShape drawShape = new DrawShape(shapeList,paintCanvas);
            DrawShape.update();
        }
    }
}