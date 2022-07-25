package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import controller.commands.CreateShape;
import model.interfaces.IDrawShape;
import model.shape.DrawEllipse;
import model.shape.DrawRectangle;
import model.shape.DrawTriangle;
import view.interfaces.PaintCanvasBase;

public class DrawStrategy {
	static Graphics2D graphics2d;
	private static ShapeList shapeList;

	public DrawStrategy(ShapeList shapeList, PaintCanvasBase paintCanvas)
	{
		this.shapeList = shapeList;
		graphics2d = paintCanvas.getGraphics2D();
	}

	public static void drawShape(CreateShape shape) {

		IDrawShape shapeStrategy = switch (shape.shapeConfig.shapeType) {
			case ELLIPSE -> new DrawEllipse();
			case TRIANGLE -> new DrawTriangle();
			case RECTANGLE -> new DrawRectangle();
			default -> new DrawRectangle();
		};
		shapeStrategy.draw(shape, graphics2d);
	}

	public static void update() {
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, 2560, 1440);
		for (CreateShape shape1 : ShapeList.getList()) {
			System.out.println(shape1.shapeConfig.shapeType);
			drawShape(shape1);
		}
	}
}