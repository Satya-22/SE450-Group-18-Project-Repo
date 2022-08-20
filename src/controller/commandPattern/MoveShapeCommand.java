package controller.commandPattern;

import controller.*;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveShapeCommand implements ICommand, IUndoable {

	private int xDelta;
	private int yDelta;
	private final Point startPoint;
	private final Point endPoint;
	private final List<CreateShapeCommand> selectedList = new ArrayList<CreateShapeCommand>();
	private static final List<CreateShapeCommand> movedList = new ArrayList<CreateShapeCommand>();
	private final List<CreateShapeCommand> oldList = new ArrayList<CreateShapeCommand>();
	private final PaintCanvasBase paintCanvas;
	public MoveShapeCommand(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void run() {

		MoveShapeCommand move = new MoveShapeCommand(startPoint, endPoint,paintCanvas);

		DrawnShapeList.Counter = 0;

		xDelta = endPoint.x - startPoint.x;
		yDelta = endPoint.y - startPoint.y;

		for (CreateShapeCommand shape : DrawnShapeList.getList()) {
			System.out.println("@@@@@@@@@@@@@@@@ Shape : "+ shape+" Selected Status : "+shape.selected);
			if (shape.selected) {
				selectedList.add(shape);
				oldList.add(shape);
			}
		}

		System.out.println("!!!!!!!!!!!!!!!!!! Selected List: "+selectedList);

		for (CreateShapeCommand selectedShape : SelectedShapeList.selectedShapes) {
			
			DrawnShapeList.removeShape(selectedShape);
			selectedShape.MoveShape(selectedShape,xDelta,yDelta);
			DrawnShapeList.addShape(selectedShape);

			if(!movedList.contains(selectedShape)) {
				movedList.add(selectedShape);
			}
		}

		CommandHistory.add(this);
		selectedList.clear();

	}


	@Override
	public void undo() {
		System.out.println("############# MovedList in Undo MoveShape : "+ movedList);
		System.out.println("############# OldList in Undo MoveShape : "+ oldList);
		for (CreateShapeCommand shape : movedList) {
			SelectedShapeList.selectedShapes.remove(shape);
			DrawnShapeList.removeShape(shape);

		}

		for (CreateShapeCommand shape : oldList) {
			shape.MoveShape(shape,xDelta*(-1),yDelta*(-1));
			SelectedShapeList.selectedShapes.add(shape);
			DrawnShapeList.addShape(shape);

		}


	}

	@Override
	public void redo() {
		System.out.println("************** MovedList in Redo MoveShape : "+ movedList);
		System.out.println("************** OldList in Redo MoveShape : "+ oldList);
		for (CreateShapeCommand shape : movedList) {
			DrawnShapeList.addShape(shape);
			SelectedShapeList.selectedShapes.add(shape);
		}
		for (CreateShapeCommand shape : oldList) {
			shape.MoveShape(shape,xDelta,yDelta);
			DrawnShapeList.removeShape(shape);
			SelectedShapeList.selectedShapes.remove(shape);
		}
	}
}