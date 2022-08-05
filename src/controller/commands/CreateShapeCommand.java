package controller.commands;

import java.awt.Point;

import controller.CommandHistory;
import controller.DrawnShapeList;
import model.ShapeConfig;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

public class CreateShapeCommand implements ICommand, IUndoable {

	CreateShapeCommand shape;
	public int x;
	public int y;
	public Point p1;
	public Point p2;
	public int l;
	public int w;
	public ShapeConfig shapeConfig;
	public boolean selected;

	public CreateShapeCommand(int x, int y, Point p1, Point p2, int l, int w, ShapeConfig shapeConfig, boolean selected) {
		this.x = x;
		this.y = y;
		this.p1 = p1;
		this.p2 = p2;
		this.l = l;
		this.w = w;
		this.shapeConfig = shapeConfig;
		this.selected = selected;
	}

	public CreateShapeCommand clone() {
		Point newP1 = new Point(this.p1.x + 50, this.p1.y + 50);
		Point newP2 = new Point(this.p2.x + 50, this.p2.y + 50);
		CreateShapeCommand clonedShape = new CreateShapeCommand(this.x + 50, this.y + 50, newP1, newP2, this.l, this.w,
				this.shapeConfig, false);
		return clonedShape;
	}

	@Override
	public void run() {
		shape = new CreateShapeCommand(x, y, p1, p2, l, w, shapeConfig, selected);
		DrawnShapeList.addShape(shape);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		DrawnShapeList.removeShape(shape);
	}

	@Override
	public void redo() {
		DrawnShapeList.addShape(shape);
	}

}
