package controller.commands;

import java.util.ArrayList;
import java.util.List;

import controller.CommandHistory;
import controller.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

public class DeleteShape implements ICommand, IUndoable {
	
	private List<CreateShape> deletedList = new ArrayList<CreateShape>();
	
	public DeleteShape() {
		
	}
	
	@Override
	public void run() {

		DeleteShape delete = new DeleteShape();
		
		
		for (CreateShape shape : ShapeList.getList()) {
			
			if (shape.selected) {
				deletedList.add(shape);
			}
		}
		
		for (CreateShape shape : deletedList) {
			ShapeList.removeShape(shape);
		}
		
		if(!deletedList.isEmpty()) CommandHistory.add(this);
		
	}
	
	@Override
	public void undo() {
		for (CreateShape shape : deletedList) {
			ShapeList.addShape(shape);
		}
		
	}

	@Override
	public void redo() {
		for (CreateShape shape : deletedList) {
			ShapeList.removeShape(shape);
		}
		
	}



}
