package model.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import controller.commands.CreateShape;
import model.interfaces.IDrawShape;

public class DrawRectangle implements IDrawShape {

	@Override
	public void draw(CreateShape shape, Graphics2D graphics2d) {

		switch (shape.shapeConfig.shadingType) {

		case OUTLINE:
			graphics2d.setColor(Color.WHITE);
			//graphics2d.fillRect(shape.x, shape.y, shape.w, shape.l);
			//graphics2d.fillRect(Math.min(shape.p1.x,shape.p2.x),Math.min(shape.p1.y,shape.p2.y),Math.abs(shape.p1.x-shape.p2.x),Math.abs(shape.p1.x-shape.p2.x));
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.shapeConfig.secondaryColor);
			graphics2d.drawRect(Math.min(shape.p1.x,shape.p2.x),Math.min(shape.p1.y,shape.p2.y),Math.abs(shape.p1.x-shape.p2.x),Math.abs(shape.p1.x-shape.p2.x));
			//graphics2d.drawRect(shape.x, shape.y, shape.w, shape.l);
			break;

		case FILLED_IN:
			graphics2d.setColor(shape.shapeConfig.primaryColor);
			//graphics2d.fillRect(shape.x, shape.y, shape.w, shape.l);
			graphics2d.fillRect(Math.min(shape.p1.x,shape.p2.x),Math.min(shape.p1.y,shape.p2.y),Math.abs(shape.p1.x-shape.p2.x),Math.abs(shape.p1.x-shape.p2.x));

			System.out.println("Draw Rectangle Coordinates : "+shape.x+","+ shape.y+","+ shape.w+","+ shape.l);
			System.out.println("Shape Coordinates :"+ Math.min(shape.p1.x,shape.p2.x)+","+ Math.min(shape.p1.y,shape.p2.y)+","+ Math.abs(shape.p1.x-shape.p2.x)+","+ Math.abs(shape.p1.y-shape.p2.y));

			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.shapeConfig.primaryColor);
			//graphics2d.drawRect(Math.min(shape.p1.x,shape.p2.x),Math.min(shape.p1.y,shape.p2.y),Math.abs(shape.p1.x-shape.p2.x),Math.abs(shape.p1.x-shape.p2.x));
			//graphics2d.drawRect(shape.x, shape.y, shape.w, shape.l);
			break;

		case OUTLINE_AND_FILLED_IN:
			graphics2d.setColor(shape.shapeConfig.primaryColor);
			//graphics2d.fillRect(shape.x, shape.y, shape.w, shape.l);
			graphics2d.fillRect(Math.min(shape.p1.x,shape.p2.x),Math.min(shape.p1.y,shape.p2.y),Math.abs(shape.p1.x-shape.p2.x),Math.abs(shape.p1.x-shape.p2.x));
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.shapeConfig.secondaryColor);
			//graphics2d.drawRect(shape.x, shape.y, shape.w, shape.l);
			graphics2d.drawRect(Math.min(shape.p1.x,shape.p2.x),Math.min(shape.p1.y,shape.p2.y),Math.abs(shape.p1.x-shape.p2.x),Math.abs(shape.p1.x-shape.p2.x));
			break;

		default:
			break;

		}

	}
}
