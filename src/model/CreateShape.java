package model;


import java.awt.Color;
import java.awt.Point;
import controller.*;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class CreateShape implements ICommand, IUndoable {

	CreateShape shape;
	public Point p1;
	public Point p2;
	public ShapeType shapeType;
	public Color primaryColor;
	public Color secondaryColor;
	public ApplicationState appState;
	public ShapeList shapeList;
	public PaintCanvasBase paintCanvas;

	public ShapeShadingType sst;

	public DrawShape drawShape;

	public CreateShape(Point p1, Point p2, PaintCanvasBase paintCanvas, Color primaryColor, Color secondaryColor, ShapeShadingType sst, ApplicationState appState, ShapeList shapeList) {
		this.p1 = p1;
		this.p2 = p2;
		this.appState = appState;
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList;
		this.sst = appState.getActiveShapeShadingType();
		this.shapeType = appState.getActiveShapeType();
		this.sst = sst;
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
	}

		@Override
		public void run () {
			shape = new CreateShape(p1, p2, paintCanvas, primaryColor, secondaryColor, sst, appState, shapeList);
			shapeList.addShape(shape);
			CommandHistory.add(this);
			drawShape = new DrawShape(paintCanvas, shapeList);
			drawShape.update();
			System.out.println(shapeList.getList());
		}

		@Override
		public void undo () {
			System.out.println(shapeList.getList());
			shapeList.removeShape(shape);
			System.out.println(shapeList.getList());
			drawShape = new DrawShape(paintCanvas, shapeList);
			drawShape.update();
		}

		@Override
		public void redo () {
			System.out.println(shapeList.getList());
			shapeList.addShape(shape);
			System.out.println(shapeList.getList());
			drawShape = new DrawShape(paintCanvas, shapeList);
			drawShape.update();

			}

	}

