package controller.commandPattern;

import model.ShapeConfig;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class StaticFactory {

	public static ICommand drawCommand(int x, int y, Point p1, Point p2, int l, int w, ShapeConfig shapeConfig, boolean selected,boolean grouped) {
		return new CreateShapeCommand(x, y, p1, p2, l, w, shapeConfig, selected,grouped);
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
	
	public static ICommand pasteCommand(PaintCanvasBase paintCanvas) {
		return new PasteShapeCommand(paintCanvas);
	}
	
	public static ICommand deleteCommand() {
		return new DeleteShapeCommand();
	}

	public static ICommand groupCommand(PaintCanvasBase paintCanvas, IApplicationState appState) {
		return new GroupShape(paintCanvas);}

	public static ICommand ungroupCommand(){return  new UnGroupCommand();}
}