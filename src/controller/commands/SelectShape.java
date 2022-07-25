package controller.commands;

import model.interfaces.ICommand;
import controller.DrawStrategy;
import controller.ShapeList;

import java.awt.*;

public class SelectShape implements ICommand {
	private final Point startPoint;
	private final Point endPoint;
	private Point minimum;
	private int width;
	private int height;
	private ShapeList shapeList;

	public SelectShape(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	@Override
	public void run() {

		minimum = new Point(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y));

		width = Math.abs(startPoint.x - endPoint.x);

		height = Math.abs(startPoint.y - endPoint.y);

		for (CreateShape shape : ShapeList.getList()) {

			shape.selected = false;
			DrawStrategy.update();

			if (shape.p1.x < minimum.x + width && shape.p1.x + (Math.abs(shape.p1.x - shape.p2.x)) > minimum.x
					&& shape.p1.y < minimum.y + height
					&& shape.p1.y + (Math.abs(shape.p1.y - shape.p2.y)) > minimum.y) {
				shape.selected = true;
				DrawStrategy.update();
			}
		}

	}
}
