package controller;

import java.awt.Color;
import java.awt.Graphics2D;

import controller.commands.CreateShapeCommand;
import model.interfaces.IDrawShape;
import model.StrategyPattern.DrawEllipse;
import model.StrategyPattern.DrawRectangle;
import model.StrategyPattern.DrawTriangle;
import view.interfaces.PaintCanvasBase;

public class DrawStrategy {
	static PaintCanvasBase paintCanvas;
	public DrawStrategy(PaintCanvasBase paintCanvas) {
		this.paintCanvas = paintCanvas;
	}
	public static void drawShape(CreateShapeCommand shape) {

		IDrawShape shapeStrategy = switch (shape.shapeConfig.shapeType) {
			case ELLIPSE -> new DrawEllipse();
			case TRIANGLE -> new DrawTriangle();
			case RECTANGLE -> new DrawRectangle();
			case default -> new NullShape();
		};
		shapeStrategy.draw(shape,paintCanvas);
	}

	public static void update() {
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, 2560, 1440);

		for (CreateShapeCommand shape : DrawnShapeList.getList()) {
			drawShape(shape);
		}
	}
}
