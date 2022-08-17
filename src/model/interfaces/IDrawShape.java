package model.interfaces;

import controller.commandPattern.CreateShapeCommand;
import view.interfaces.PaintCanvasBase;

public interface IDrawShape {

	void draw(CreateShapeCommand shape, PaintCanvasBase paintCanvas);

}
