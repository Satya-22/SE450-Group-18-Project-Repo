package controller.commands;

import java.awt.Point;
import model.ShapeConfig;
import model.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;

public class StaticFactory {

	public static ICommand drawCommand(int x, int y, Point p1, Point p2, int l, int w, ShapeConfig shapeConfig, boolean selected) {
		return new CreateShapeCommand(x, y, p1, p2, l, w, shapeConfig, selected);
	}

	public static ICommand selectCommand(Point p1, Point p2, PaintCanvasBase paintCanvas) {
		return new SelectShapeCommand(p1, p2,paintCanvas);
	}

	public static ICommand moveCommand(Point p1, Point p2,PaintCanvasBase paintCanvas) {
		return new MoveShapeCommand(p1,p2,paintCanvas);
	}
	
	public static ICommand copyCommand() {
		return new CopyShapeCommand();
	}
	
	public static ICommand pasteCommand() {
		return new PasteShapeCommand();
	}
	
	public static ICommand deleteCommand() {
		return new DeleteShapeCommand();
	}
}