package controller.commands;

import java.util.ArrayList;
import java.util.List;

import controller.CommandHistory;
import controller.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

public class PasteShape implements ICommand, IUndoable {
	
	private List<CreateShape> pastedList = new ArrayList<CreateShape>();
	private List<CreateShape> oldList = new ArrayList<CreateShape>();
	
	public PasteShape() {
	}
	
	@Override
	public void run() {
		
		PasteShape paste = new PasteShape();
		
		for (CreateShape shape : ShapeList.getClipBoard()) {
			CreateShape copiedShape = shape.clone();
			pastedList.add(copiedShape);
			ShapeList.addShape(copiedShape);
		}
		CommandHistory.add(this);
	}
	
	@Override
	public void undo() {
		for (CreateShape shape : pastedList) {
			ShapeList.removeShape(shape);
		}
		
	}

	@Override
	public void redo() {
		for (CreateShape shape : pastedList) {
			ShapeList.addShape(shape);
		}
		
	}

}
