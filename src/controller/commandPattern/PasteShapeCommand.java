package controller.commandPattern;

import controller.CommandHistory;
import controller.DrawnShapeList;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PasteShapeCommand implements ICommand, IUndoable {
	private final List<CreateShapeCommand> pastedList = new ArrayList<CreateShapeCommand>();

	private final PaintCanvasBase paintCanvas;
	
	public PasteShapeCommand(PaintCanvasBase paintCanvas) {
		this.paintCanvas = paintCanvas;
	}
	@Override
	public void run() {

		HashMap<GroupShape,GroupShape> GroupMap = new HashMap<GroupShape, GroupShape>();

		for(CreateShapeCommand createshape: DrawnShapeList.getClipBoard()){
			if(!createshape.getShapeGroup().isEmpty()){
				GroupMap.put(createshape.getShapeGroup().get(createshape.getShapeGroup().size() - 1), null);
			}
		}
		
		PasteShapeCommand paste = new PasteShapeCommand(paintCanvas);
		
		for (CreateShapeCommand shape : DrawnShapeList.getClipBoard()) {

			CreateShapeCommand copiedShape = shape.clone();

			if(!shape.getShapeGroup().isEmpty()) {
				if (GroupMap.get(shape.getShapeGroup().get(shape.getShapeGroup().size() - 1)) != null) {
                   copiedShape.addGroupShape(GroupMap.get(shape.getShapeGroup().get(shape.getShapeGroup().size() - 1)));
				}
				else{
					GroupShape group = new GroupShape(paintCanvas);
					GroupMap.put(shape.getShapeGroup().get(shape.getShapeGroup().size() - 1),group);
					copiedShape.addGroupShape(group);
				}
			}
			pastedList.add(copiedShape);
		}
		
		for(CreateShapeCommand shape : pastedList){
			DrawnShapeList.addShape(shape);
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
