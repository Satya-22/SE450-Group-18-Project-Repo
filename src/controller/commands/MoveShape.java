package controller.commands;

import controller.*;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveShape implements ICommand, IUndoable {

	private int xDelta;
	private int yDelta;
	private final Point startPoint;
	private final Point endPoint;
	private List<CreateShape> selectedList = new ArrayList<CreateShape>();
	private List<CreateShape> movedList = new ArrayList<CreateShape>();
	private List<CreateShape> oldList = new ArrayList<CreateShape>();
	private CreateShape movedShape;

	public MoveShape(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	@Override
	public void run() {

		MoveShape move = new MoveShape(startPoint, endPoint);

		xDelta = endPoint.x - startPoint.x;
		yDelta = endPoint.y - startPoint.y;

		for (CreateShape shape : ShapeList.getList()) {
			if (shape.selected) {
				selectedList.add(shape);
				oldList.add(shape);
			}
		}

		for (CreateShape selectedShape : selectedList) {
			
			ShapeList.removeShape(selectedShape);
			
			int newX = selectedShape.x + xDelta;
			int newY = selectedShape.y + yDelta;
			Point newP1 = new Point(selectedShape.p1.x + xDelta, selectedShape.p1.y + yDelta);
			Point newP2 = new Point(selectedShape.p2.x + xDelta, selectedShape.p2.y + yDelta);

			movedShape = new CreateShape(newX, newY, newP1, newP2, selectedShape.l, selectedShape.w,
					selectedShape.shapeConfig, true);

			ShapeList.addShape(movedShape);
			movedList.add(movedShape);
		}

		CommandHistory.add(this);
		selectedList.clear();

	}

	@Override
	public void undo() {

		for (CreateShape shape : movedList) {
			ShapeList.removeShape(shape);
		}

		for (CreateShape shape : oldList) {
			ShapeList.addShape(shape);
		}

	}

	@Override
	public void redo() {

		for (CreateShape shape : movedList) {
			ShapeList.addShape(shape);
		}
		for (CreateShape shape : oldList) {
			ShapeList.removeShape(shape);
		}
	}
}