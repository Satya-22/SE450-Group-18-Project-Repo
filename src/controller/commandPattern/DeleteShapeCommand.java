package controller.commandPattern;

import controller.CommandHistory;
import controller.DrawnShapeList;
import controller.SelectedShapeList;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.util.ArrayList;
import java.util.List;

public class DeleteShapeCommand implements ICommand, IUndoable {
	
	private List<CreateShapeCommand> deletedList = new ArrayList<CreateShapeCommand>();
	
	public DeleteShapeCommand() {
		
	}
	
	@Override
	public void run() {

		DeleteShapeCommand delete = new DeleteShapeCommand();

		for (CreateShapeCommand shape : SelectedShapeList.selectedShapes) {

			DrawnShapeList.removeShape(shape);
		}

		if(!SelectedShapeList.selectedShapes.isEmpty()) CommandHistory.add(this);
		
	}
	
	@Override
	public void undo() {
		for (CreateShapeCommand shape : SelectedShapeList.selectedShapes) {
			DrawnShapeList.addShape(shape);
	}
		
	}

	@Override
	public void redo() {
		for (CreateShapeCommand shape : SelectedShapeList.selectedShapes) {
			DrawnShapeList.removeShape(shape);
		}
		
	}



}
