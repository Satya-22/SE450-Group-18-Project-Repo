package controller.commandPattern;

import controller.CommandHistory;
import controller.DrawStrategy;
import controller.SelectedShapeList;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import java.util.ArrayList;

public class UnGroupCommand implements ICommand, IUndoable {

    private GroupShape groupShape;
    private final ArrayList<CreateShapeCommand> ungroupedList = new ArrayList<>();

    @Override
    public void run() {

        ungroupedList.addAll(SelectedShapeList.selectedShapes);

        CreateShapeCommand endshape = ungroupedList.get(ungroupedList.size() -1);

        groupShape = endshape.getShapeGroup().get(endshape.getShapeGroup().size()-1);

        for(CreateShapeCommand shape : ungroupedList){
            shape.removeGroupShape();
        }
        CommandHistory.add(this);
        DrawStrategy.update();
    }

    @Override
    public void undo() {
        for(CreateShapeCommand shape : ungroupedList){
            shape.addGroupShape(groupShape);
            SelectedShapeList.selectedShapes.add(shape);
        }
        DrawStrategy.update();
    }

    @Override
    public void redo() {

        for(CreateShapeCommand shape : ungroupedList){
            shape.removeGroupShape();
        }
        DrawStrategy.update();
    }
}
