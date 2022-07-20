package controller.commands;

import java.awt.Point;

import controller.ICommand;
import model.ShapeConfig;

public class CommandFactory {

	public static ICommand drawCommand(int x, int y, Point p1, Point p2, int l, int w, ShapeConfig shapeConfig) {
		return new CreateShape(x, y, p1, p2, l, w, shapeConfig);
	}

	public static ICommand selectCommand(Point p1, Point p2) {
		return new SelectShape(p1, p2);
	}

	public static ICommand moveCommand(Point p1) {
		return new MoveShape(p1);
	}
}
