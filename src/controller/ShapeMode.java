package controller;

import java.awt.Point;

import controller.commands.CommandFactory;
import model.ShapeConfig;
import model.persistence.ApplicationState;

public class ShapeMode {

	private static ApplicationState appState;
	private static ICommand shapeCommand;

	public static void run(int x, int y, Point p1, Point p2, int l, int w, ShapeConfig shapeConfig) {

		switch (appState.getActiveMouseMode()) {

		case DRAW:
			shapeCommand = CommandFactory.drawCommand(x, y, p1, p2, l, w, shapeConfig);
			break;
		case SELECT:
			shapeCommand = CommandFactory.selectCommand(p1, p2);
			break;
		case MOVE:
			shapeCommand = CommandFactory.moveCommand(p1);
			break;

		default:
			shapeCommand = CommandFactory.selectCommand(p1, p2);
		}
		
		shapeCommand.run();
	}

	public static void getAppState(ApplicationState AppState) {
		appState = AppState;
	}
}
