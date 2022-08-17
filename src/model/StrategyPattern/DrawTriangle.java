package model.StrategyPattern;

import controller.commandPattern.CreateShapeCommand;
import model.ProxyPattern.SelectedShapeOutlineProxy;
import model.interfaces.IDrawShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawTriangle implements IDrawShape {
	@Override
	public void draw(CreateShapeCommand shape, PaintCanvasBase paintCanvas) {

		int[] X = { shape.p1.x, shape.p1.x, shape.p2.x };
		int[] Y = { shape.p1.y, shape.p2.y, shape.p2.y };

		Graphics2D graphics2d = paintCanvas.getGraphics2D();

		switch (shape.shapeConfig.shadingType) {
			case OUTLINE -> {
				graphics2d.setColor(Color.WHITE);
				graphics2d.fillPolygon(X, Y, 3);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(shape.shapeConfig.primaryColor);
				graphics2d.drawPolygon(X, Y, 3);
			}
			case FILLED_IN -> {
				graphics2d.setColor(shape.shapeConfig.primaryColor);
				graphics2d.fillPolygon(X, Y, 3);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(shape.shapeConfig.primaryColor);
				graphics2d.fillPolygon(X, Y, 3);
			}
			case OUTLINE_AND_FILLED_IN -> {
				graphics2d.setColor(shape.shapeConfig.primaryColor);
				graphics2d.fillPolygon(X, Y, 3);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(shape.shapeConfig.secondaryColor);
				graphics2d.drawPolygon(X, Y, 3);
			}
			default -> {
			}
		}
		if(shape.selected) {
			SelectedShapeOutlineProxy selectedShapeOutlineProxy = new SelectedShapeOutlineProxy(shape.p1, shape.p2, paintCanvas);
			selectedShapeOutlineProxy.shapeOutline();
	}
	}
}
