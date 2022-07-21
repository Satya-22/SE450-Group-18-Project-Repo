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
	ShapeList shapeList;

	public CreateShape(int x, int y, Point p1, Point p2, int l, int w, ShapeConfig shapeConfig) {
		this.x = x;
		this.y = y;
		this.p1 = p1;
		this.p2 = p2;
		this.l = l;
		this.w = w;
		this.shapeConfig = shapeConfig;
	}

	@Override
	public void run() {
		shape = new CreateShape(x, y, p1, p2, l, w, shapeConfig);
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
