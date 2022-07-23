package controller.commands;

import model.interfaces.ICommand;
import controller.DrawShape;
import controller.SelectedShapeList;
import controller.ShapeList;
import model.interfaces.ISelectedShapesList;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
public class SelectShape implements ICommand, ISelectedShapesList {
	private PaintCanvasBase paintCanvas;
	private final Point startPoint;
	private final Point endPoint;
	private Point minimum;
	private int width;
	private int height;
	private ShapeList shapeList;

	private SelectedShapeList selectedShapeList;

	static Graphics2D graphics2d;

	public SelectShape(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
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
				selectedShapes.add(shape);
				shape.selected = true;
				DrawShape.update();
			}
		}

	}
}
