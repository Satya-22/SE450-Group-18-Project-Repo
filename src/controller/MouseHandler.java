package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.CreateShape;
import model.MouseMode;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseHandler extends MouseAdapter {

	Point p1 = new Point(0, 0);
	Point p2 = new Point(0, 0);
	int l;
	int w;
	PaintCanvasBase paintCanvas;
	ApplicationState appState;
	ShapeList shapeList;

	public MouseHandler(PaintCanvasBase paintCanvas, ApplicationState appState, ShapeList ShapeList) {
		this.paintCanvas = paintCanvas;
		this.appState = appState;
		this.shapeList = ShapeList;
	}

	public void drawShape(PaintCanvasBase paintCanvas) {
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		graphics2d.setStroke(new BasicStroke(5));
		graphics2d.setColor(stringToColor(appState.getActivePrimaryColor().toString()));

		if (appState.getActiveShapeType() == ShapeType.RECTANGLE) {
			l = Math.abs(p1.x - p2.x);
			w = Math.abs(p1.y - p2.y);
			graphics2d.fillRect(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y), l, w);
			CreateShape shape = new CreateShape(p1 ,p2, paintCanvas, appState, shapeList);
			shape.run();
		}
	}

	public static Color stringToColor(final String value) {
		if (value == null) {
			return Color.black;
		}
		try {
			return Color.decode(value);
		} catch (NumberFormatException nfe) {
			try {
				final java.lang.reflect.Field f = Color.class.getField(value);

				return (Color) f.get(null);
			} catch (Exception ce) {
				return Color.black;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		p1 = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		p2 = e.getPoint();
		if (appState.getActiveMouseMode() == MouseMode.DRAW)
			drawShape(paintCanvas);
	}

}