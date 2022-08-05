package controller.commands;

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
	private final List<CreateShapeCommand> movedList = new ArrayList<CreateShapeCommand>();
	private final List<CreateShapeCommand> oldList = new ArrayList<CreateShapeCommand>();
	private CreateShapeCommand movedShape;
	private final PaintCanvasBase paintCanvas;

	Point newP1;

	Point newP2;

	public MoveShapeCommand(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void run() {

		MoveShapeCommand move = new MoveShapeCommand(startPoint, endPoint,paintCanvas);

		xDelta = endPoint.x - startPoint.x;
		yDelta = endPoint.y - startPoint.y;

		for (CreateShapeCommand shape : DrawnShapeList.getList()) {
			if (shape.selected) {
				selectedList.add(shape);
				oldList.add(shape);
			}
		}

		SelectedShapeList.selectedShapes.clear();

		for (CreateShapeCommand selectedShape : selectedList) {
			
			DrawnShapeList.removeShape(selectedShape);
			
			int newX = selectedShape.x + xDelta;
			int newY = selectedShape.y + yDelta;
			 newP1 = new Point(selectedShape.p1.x + xDelta, selectedShape.p1.y + yDelta);
			 newP2 = new Point(selectedShape.p2.x + xDelta, selectedShape.p2.y + yDelta);

			movedShape = new CreateShapeCommand(newX, newY, newP1, newP2, selectedShape.l, selectedShape.w,
					selectedShape.shapeConfig, true);
			SelectedShapeList.selectedShapes.add(movedShape);

			DrawnShapeList.addShape(movedShape);
			movedList.add(movedShape);
		}

		CommandHistory.add(this);
		selectedList.clear();
	}

	@Override
	public void undo() {

		for (CreateShapeCommand shape : movedList) {
			SelectedShapeList.selectedShapes.remove(shape);
			DrawnShapeList.removeShape(shape);

		}

		for (CreateShapeCommand shape : oldList) {
			SelectedShapeList.selectedShapes.add(shape);
			DrawnShapeList.addShape(shape);

		}

	}

	@Override
	public void redo() {

		for (CreateShapeCommand shape : movedList) {
			DrawnShapeList.addShape(shape);
			SelectedShapeList.selectedShapes.add(shape);
		}
		for (CreateShapeCommand shape : oldList) {
			DrawnShapeList.removeShape(shape);
			SelectedShapeList.selectedShapes.remove(shape);
		}
	}
}