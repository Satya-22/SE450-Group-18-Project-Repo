package controller.commands;


import controller.DrawShape;
import model.interfaces.ICommand;
import controller.ShapeList;
import model.interfaces.ISelectedShapesList;
import view.interfaces.PaintCanvasBase;
import java.awt.*;

public class SelectShape implements ICommand, ISelectedShapesList {
	private final Point startPoint;
	private final Point endPoint;
	private Point minimum;
	private int width;
	private int height;
	private final PaintCanvasBase paintCanvas;
	public SelectShape(Point startPoint, Point endPoint,PaintCanvasBase paintCanvas) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.paintCanvas = paintCanvas;
	}
	@Override
	public void run() {

		minimum = new Point(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y));

		width = Math.abs(startPoint.x - endPoint.x);

		height = Math.abs(startPoint.y - endPoint.y);

		selectedShapes.clear();

		for (CreateShape shape : ShapeList.getList()) {
			shape.selected = false;
			DrawShape.update();
			if (shape.p1.x < minimum.x + width &&
					shape.p1.x + (Math.abs(shape.p1.x - shape.p2.x)) > minimum.x &&
					shape.p1.y < minimum.y + height &&
					shape.p1.y + (Math.abs(shape.p1.y - shape.p2.y)) > minimum.y) {
				shape.selected = true;
				selectedShapes.add(shape);
			}
		}
		System.out.println("Selected ShapeList : " + selectedShapes);
		DrawShape.update();
	}
}