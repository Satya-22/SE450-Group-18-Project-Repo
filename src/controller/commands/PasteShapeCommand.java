package controller.commands;

import java.util.ArrayList;
import java.util.List;
import controller.CommandHistory;
import controller.DrawnShapeList;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

public class PasteShapeCommand implements ICommand, IUndoable {
	private final List<CreateShapeCommand> pastedList = new ArrayList<CreateShapeCommand>();
	public PasteShapeCommand() {
	}
	@Override
	public void run() {
		
		PasteShapeCommand paste = new PasteShapeCommand();
		
		for (CreateShapeCommand shape : DrawnShapeList.getClipBoard()) {
			CreateShapeCommand copiedShape = shape.clone();
			pastedList.add(copiedShape);
			DrawnShapeList.addShape(copiedShape);
		}
		CommandHistory.add(this);
	}
	
	@Override
	public void undo() {
		for (CreateShapeCommand shape : pastedList) {
			DrawnShapeList.removeShape(shape);
		}
	}

	@Override
	public void redo() {
		for (CreateShapeCommand shape : pastedList) {
			DrawnShapeList.addShape(shape);
		}
		
	}

}
