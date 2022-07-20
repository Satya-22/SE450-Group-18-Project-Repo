package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.*;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseHandler extends MouseAdapter {

	Point p1 = new Point(0, 0);
	Point p2 = new Point(0, 0);
	PaintCanvasBase paintCanvas;
	ApplicationState appState;
	ShapeList shapeList;

	Color primaryColor;

	Color secondaryColor;

	ShapeShadingType sst;

	public MouseHandler(PaintCanvasBase paintCanvas, ApplicationState appState, ShapeList ShapeList) {
		this.paintCanvas = paintCanvas;
		this.appState = appState;
		this.shapeList = ShapeList;
	}

	public void drawShape(PaintCanvasBase paintCanvas) {
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		graphics2d.setStroke(new BasicStroke(5));
		graphics2d.setColor(stringToColor(appState.getActivePrimaryColor().toString()));

		primaryColor = stringToColor(appState.getActivePrimaryColor().toString());

		secondaryColor = stringToColor(appState.getActiveSecondaryColor().toString());

		sst = appState.getActiveShapeShadingType();

		CreateShape shape = new CreateShape(p1 ,p2, paintCanvas,primaryColor,secondaryColor,sst,appState, shapeList);
		shape.run();

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
		else if (appState.getActiveMouseMode() == MouseMode.SELECT) {
			SelectShape command = new SelectShape(p1, p2, paintCanvas,shapeList);
				command.run();
			}
		else if (appState.getActiveMouseMode() == MouseMode.MOVE) {
			MoveShape command = new MoveShape(p1, p2, paintCanvas,shapeList);
			command.run();
		}

		}

	}