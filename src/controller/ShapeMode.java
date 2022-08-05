package controller;

import java.awt.Point;
import controller.commands.StaticFactory;
import model.ShapeConfig;
import model.interfaces.ICommand;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class ShapeMode {
	private static ApplicationState appState;
	private static ICommand shapeCommand;
	public static void run(int x, int y, Point p1, Point p2, int l, int w, ShapeConfig shapeConfig, boolean selected, PaintCanvasBase paintCanvas) {
		switch (appState.getActiveMouseMode()) {
			case DRAW -> shapeCommand = StaticFactory.drawCommand(x, y, p1, p2, l, w, shapeConfig, selected);
			case SELECT -> shapeCommand = StaticFactory.selectCommand(p1, p2,paintCanvas);
			case MOVE -> shapeCommand = StaticFactory.moveCommand(p1, p2,paintCanvas);
		}
		shapeCommand.run();
	}

	public static void getAppState(ApplicationState AppState) {
		appState = AppState;
	}
}
