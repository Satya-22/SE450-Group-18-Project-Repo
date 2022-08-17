package controller.commandPattern;

import controller.CommandHistory;
import controller.DrawStrategy;
import controller.DrawnShapeList;
import controller.SelectedShapeList;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

public class GroupShape implements ICommand, IUndoable {

    private final ArrayList<CreateShapeCommand> groupedList = new ArrayList<>();

    private DrawnShapeList shapeList;
    private PaintCanvasBase paintCanvas;

    public GroupShape(PaintCanvasBase paintCanvas){
        this.paintCanvas = paintCanvas;
    }
    @Override
    public void run() {
        ArrayList<CreateShapeCommand> group = new ArrayList<>();
        groupedList.clear();
        groupedList.addAll(SelectedShapeList.selectedShapes);
        System.out.println("Selected Shapes in Group Shapes : "+ SelectedShapeList.selectedShapes);

        for(CreateShapeCommand Shape : groupedList){
            ArrayList<Integer> x = new ArrayList<>();
            ArrayList<Integer> y = new ArrayList<>();

                Shape.grouped = true;
                Shape.addGroupShape(this);
        }
        CommandHistory.add(this);
        DrawStrategy.update();

    }

    @Override
    public void undo() {

        for(CreateShapeCommand shape : groupedList){
            shape.removeGroupShape();
        }
        DrawStrategy.update();
    }

    @Override
    public void redo() {

        for(CreateShapeCommand shape : groupedList){
            SelectedShapeList.selectedShapes.add(shape);
            shape.addGroupShape(this);
        }
        DrawStrategy.update();
    }
}
