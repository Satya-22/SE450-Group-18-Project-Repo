package controller.commandPattern;

import controller.CommandHistory;
import controller.DrawnShapeList;
import model.ShapeConfig;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.awt.*;
import java.util.ArrayList;

public class CreateShapeCommand implements ICommand, IUndoable{

	CreateShapeCommand shape;
	public int x;
	public int y;
	public Point p1;
	public Point p2;
	public int l;
	public int w;
	public ShapeConfig shapeConfig;
	public boolean selected;

	public boolean grouped;
	private int pasteCount;

	private final ArrayList<GroupShape> groupShapeArrayList = new ArrayList<>();

	public CreateShapeCommand(int x, int y, Point p1, Point p2, int l, int w, ShapeConfig shapeConfig, boolean selected,boolean grouped) {
		this.x = x;
		this.y = y;
		this.p1 = p1;
		this.p2 = p2;
		this.l = l;
		this.w = w;
		this.shapeConfig = shapeConfig;
		this.selected = selected;
		this.grouped = grouped;
	}

	public CreateShapeCommand clone() {
        pasteCount = DrawnShapeList.pasteCounter();
		Point newP1 = new Point(this.p1.x + 50 * pasteCount, this.p1.y  + 50 * pasteCount);
		Point newP2 = new Point(this.p2.x + 50 * pasteCount, this.p2.y + 50 * pasteCount);
		CreateShapeCommand clonedShape = new CreateShapeCommand(this.x + 50 * pasteCount, this.y + 50 * pasteCount, newP1, newP2, this.l, this.w,
				this.shapeConfig, false,false);
		return clonedShape;
	}

	@Override
	public void run() {
		shape = new CreateShapeCommand(x, y, p1, p2, l, w, shapeConfig, selected,grouped);
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



	public void MoveShape(CreateShapeCommand shape,int delx, int dely) {
		x = shape.x + delx;
		y = shape.y + dely;
		shape.p1.x = shape.p1.x + delx;
		shape.p1.y = shape.p1.y + dely;
		shape.p2.x = shape.p2.x + delx;
		shape.p2.y = shape.p2.y + dely;
	}
	public void addGroupShape(GroupShape groupShape) {
		groupShapeArrayList.add(groupShape);
		System.out.println("Group list for create shape:: "+ groupShapeArrayList);
	}

	public ArrayList<GroupShape> getShapeGroup() {
		return groupShapeArrayList;
	}
	public void removeGroupShape() {
       groupShapeArrayList.remove(groupShapeArrayList.size() -1 );
	}

	public Point getP1(){ return p1;}

	public Point getP2(){return p2;}

	public int getX(){return p1.x;}

	public int getY(){return p1.y;}


}
