package controller.commands;

import java.awt.Point;

import controller.CommandHistory;
import controller.ShapeList;
import model.ShapeConfig;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

public class CreateShape implements ICommand, IUndoable {

	CreateShape shape;
	public int x;
	public int y;
	public Point p1;
	public Point p2;
	public int l;
	public int w;
	public ShapeConfig shapeConfig;
	public boolean selected;
	ShapeList shapeList;

	public CreateShape(int x, int y, Point p1, Point p2, int l, int w, ShapeConfig shapeConfig, boolean selected) {
		this.x = x;
		this.y = y;
		this.p1 = p1;
		this.p2 = p2;
		this.l = l;
		this.w = w;
		this.shapeConfig = shapeConfig;
		this.selected = selected;
	}

	public CreateShape clone() {
		Point newP1 = new Point(this.p1.x + 50, this.p1.y + 50);
		Point newP2 = new Point(this.p2.x + 50, this.p2.y + 50);
		CreateShape clonedShape = new CreateShape(this.x + 50, this.y + 50, newP1, newP2, this.l, this.w,
				this.shapeConfig, false);
		return clonedShape;
	}

	@Override
	public void run() {
		shape = new CreateShape(x, y, p1, p2, l, w, shapeConfig, selected);
		ShapeList.addShape(shape);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		ShapeList.removeShape(shape);
	}

	@Override
	public void redo() {
		ShapeList.addShape(shape);
	}

}
