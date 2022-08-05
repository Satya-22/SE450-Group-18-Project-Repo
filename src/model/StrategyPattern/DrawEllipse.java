package model.StrategyPattern;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import controller.ProxyPattern.SelectedShapeOutlineProxy;
import controller.commands.CreateShapeCommand;
import model.interfaces.IDrawShape;
import view.interfaces.PaintCanvasBase;

public class DrawEllipse implements IDrawShape {
	@Override
	public void draw(CreateShapeCommand shape, PaintCanvasBase paintCanvas) {

		Graphics2D graphics2d = paintCanvas.getGraphics2D();

		switch (shape.shapeConfig.shadingType) {
			case OUTLINE -> {
				graphics2d.setColor(Color.WHITE);
				graphics2d.fillOval(shape.x, shape.y, shape.w, shape.l);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(shape.shapeConfig.secondaryColor);
				graphics2d.drawOval(shape.x, shape.y, shape.w, shape.l);
			}
			case FILLED_IN -> {
				graphics2d.setColor(shape.shapeConfig.primaryColor);
				graphics2d.fillOval(shape.x, shape.y, shape.w, shape.l);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(shape.shapeConfig.primaryColor);
				graphics2d.drawOval(shape.x, shape.y, shape.w, shape.l);
			}
			case OUTLINE_AND_FILLED_IN -> {
				graphics2d.setColor(shape.shapeConfig.primaryColor);
				graphics2d.fillOval(shape.x, shape.y, shape.w, shape.l);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(shape.shapeConfig.secondaryColor);
				graphics2d.drawOval(shape.x, shape.y, shape.w, shape.l);
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
