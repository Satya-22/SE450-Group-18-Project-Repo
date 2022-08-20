package controller;

import model.ShapeConfig;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

	Point p1 = new Point(0, 0);
	Point p2 = new Point(0, 0);
	int x;
	int y;
	int l;
	int w;
	boolean selected;
	boolean grouped;
	PaintCanvasBase paintCanvas;

	private static ApplicationState appState;

	public MouseHandler(PaintCanvasBase paintCanvas){
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		p1 = e.getPoint();
		DrawStrategy.update();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		p2 = e.getPoint();

		x = Math.min(p1.x, p2.x);
		y = Math.min(p1.y, p2.y);
		w = Math.abs(p1.x - p2.x);
		l = Math.abs(p1.y - p2.y);

		ShapeConfig shapeConfig = new ShapeConfig(appState.getActivePrimaryColor(), appState.getActiveSecondaryColor(),
				appState.getActiveShapeType(), appState.getActiveShapeShadingType());
		
		selected = false;
		grouped = false;
		DrawStrategy.update();
		ShapeMode.run(x, y, p1, p2, l, w, shapeConfig, selected,grouped,paintCanvas);
	}

	public static void getAppState(ApplicationState AppState) {
		appState = AppState;
	}

}