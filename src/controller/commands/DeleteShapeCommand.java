package controller.commands;

import java.util.ArrayList;
import java.util.List;

import controller.CommandHistory;
import controller.DrawnShapeList;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

public class DeleteShapeCommand implements ICommand, IUndoable {
	
	private List<CreateShapeCommand> deletedList = new ArrayList<CreateShapeCommand>();
	
	public DeleteShapeCommand() {
		
	}
	
	@Override
	public void run() {

		DeleteShapeCommand delete = new DeleteShapeCommand();
		
		
		for (CreateShapeCommand shape : DrawnShapeList.getList()) {
			
			if (shape.selected) {
				deletedList.add(shape);
			}
		}
		
		for (CreateShapeCommand shape : deletedList) {
			DrawnShapeList.removeShape(shape);
		}
		
		if(!deletedList.isEmpty()) CommandHistory.add(this);
		
	}
	
	@Override
	public void undo() {
		for (CreateShapeCommand shape : deletedList) {
			DrawnShapeList.addShape(shape);
		}
		
	}

	@Override
	public void redo() {
		for (CreateShapeCommand shape : deletedList) {
			DrawnShapeList.removeShape(shape);
		}
		
	}



}
