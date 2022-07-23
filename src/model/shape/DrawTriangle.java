package model.shape;

import java.awt.*;

import controller.commands.CreateShape;
import model.interfaces.IDrawShape;

public class DrawTriangle implements IDrawShape {
	@Override
	public void draw(CreateShape shape, Graphics2D graphics2d) {

		int[] X = { shape.p1.x, shape.p1.x, shape.p2.x };
		int[] Y = { shape.p1.y, shape.p2.y, shape.p2.y };

		switch (shape.shapeConfig.shadingType) {

		case OUTLINE:
			graphics2d.setColor(Color.WHITE);
			graphics2d.fillPolygon(X, Y, 3);
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.shapeConfig.primaryColor);
			graphics2d.drawPolygon(X, Y, 3);
			break;

		case FILLED_IN:
			graphics2d.setColor(shape.shapeConfig.primaryColor);
			graphics2d.fillPolygon(X, Y, 3);
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.shapeConfig.primaryColor);
			graphics2d.fillPolygon(X, Y, 3);
			break;

		case OUTLINE_AND_FILLED_IN:
			graphics2d.setColor(shape.shapeConfig.primaryColor);
			graphics2d.fillPolygon(X, Y, 3);
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.shapeConfig.secondaryColor);
			graphics2d.drawPolygon(X, Y, 3);
			break;

		default:
			break;

		}
		if (shape.selected) {
			Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
			graphics2d.setStroke(stroke);
			graphics2d.setColor(Color.BLACK);
			int[] arrayX = {shape.p1.x-5, shape.p1.x-5, shape.p2.x+10};
			int[] arrayY = {shape.p1.y-10, shape.p2.y+5, shape.p2.y+5};
			graphics2d.drawPolygon(arrayX,arrayY,3);
		}


	}
}
