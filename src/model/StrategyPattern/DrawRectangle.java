package model.StrategyPattern;

import model.ProxyPattern.SelectedShapeOutlineProxy;
import controller.commandPattern.CreateShapeCommand;
import controller.commandPattern.GroupShape;
import model.interfaces.IDrawShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class DrawRectangle implements IDrawShape {

	private final ArrayList<GroupShape> groupShapeArrayList = new ArrayList<>();
	@Override
	public void draw(CreateShapeCommand shape, PaintCanvasBase paintCanvas) {

		Graphics2D graphics2d = paintCanvas.getGraphics2D();

		switch (shape.shapeConfig.shadingType) {
			case OUTLINE -> {
				graphics2d.setColor(Color.WHITE);
				graphics2d.fillRect(shape.x, shape.y, shape.w, shape.l);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(shape.shapeConfig.secondaryColor);
				graphics2d.drawRect(shape.x, shape.y, shape.w, shape.l);
			}
			case FILLED_IN -> {
				graphics2d.setColor(shape.shapeConfig.primaryColor);
				graphics2d.fillRect(shape.x, shape.y, shape.w, shape.l);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(shape.shapeConfig.primaryColor);
				graphics2d.drawRect(shape.x, shape.y, shape.w, shape.l);
			}
			case OUTLINE_AND_FILLED_IN -> {
				graphics2d.setColor(shape.shapeConfig.primaryColor);
				graphics2d.fillRect(shape.x, shape.y, shape.w, shape.l);
				graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(shape.shapeConfig.secondaryColor);
				graphics2d.drawRect(shape.x, shape.y, shape.w, shape.l);
			}
			default -> {
			}
		}

		if(shape.selected) {
			SelectedShapeOutlineProxy selectedShapeOutlineProxy = new SelectedShapeOutlineProxy(shape.p1, shape.p2, paintCanvas);
			selectedShapeOutlineProxy.shapeOutline();
		}

	}


	public void MoveShape(CreateShapeCommand shape,int delx,int dely) {
		shape.x = shape.x + delx;
		shape.y = shape.y + dely;
		shape.p1.x = shape.p1.x +delx;
		shape.p2.x = shape.p2.x + delx;
		shape.p1.y = shape.p1.y+dely;
		shape.p2.y = shape.p2.y + dely;
	}

}
