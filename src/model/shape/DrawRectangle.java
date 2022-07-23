package model.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import controller.commands.CreateShape;
import model.interfaces.IDrawShape;

public class DrawRectangle implements IDrawShape {

	@Override
	public void draw(CreateShape shape, Graphics2D graphics2d) {

		switch (shape.shapeConfig.shadingType) {

		case OUTLINE:
			graphics2d.setColor(Color.WHITE);
			graphics2d.fillRect(shape.x, shape.y, shape.w, shape.l);
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.shapeConfig.secondaryColor);
			graphics2d.drawRect(shape.x, shape.y, shape.w, shape.l);
			break;

		case FILLED_IN:
			graphics2d.setColor(shape.shapeConfig.primaryColor);
			graphics2d.fillRect(shape.x, shape.y, shape.w, shape.l);
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.shapeConfig.primaryColor);
			graphics2d.drawRect(shape.x, shape.y, shape.w, shape.l);
			break;

		case OUTLINE_AND_FILLED_IN:
			graphics2d.setColor(shape.shapeConfig.primaryColor);
			graphics2d.fillRect(shape.x, shape.y, shape.w, shape.l);
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.shapeConfig.secondaryColor);
			graphics2d.drawRect(shape.x, shape.y, shape.w, shape.l);
			break;

		default:
			break;

		}
		
		if (shape.selected) {
			Stroke stroke = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
			graphics2d.setStroke(stroke);
			graphics2d.setColor(Color.BLACK);
			graphics2d.drawRect(shape.x, shape.y,shape.w, shape.l);
		}

	}
}
