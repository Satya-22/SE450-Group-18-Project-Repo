package controller.commands;

import controller.commands.CreateShape;
import controller.DrawShape;
import controller.DrawShape;
import model.ShapeType;
import model.interfaces.ICommand;
import controller.SelectedShapeList;
import controller.ShapeList;
import model.interfaces.ISelectedShapesList;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
public class SelectShape implements ICommand, ISelectedShapesList {
	private PaintCanvasBase paintCanvas;
	private final Point startPoint;
	private final Point endPoint;
	private Point minimum;
	private int width;
	private int height;
	private ShapeList shapeList;

	private SelectedShapeList selectedShapeList;

	static Graphics2D graphics2d;

	public SelectShape(Point startPoint, Point endPoint,PaintCanvasBase paintCanvas) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.paintCanvas = paintCanvas;
		//this.shapeList = shapeList;
		graphics2d = paintCanvas.getGraphics2D();
	}
	@Override
	public void run() {

		minimum = new Point(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y));

		width = Math.abs(startPoint.x - endPoint.x);

		height = Math.abs(startPoint.y - endPoint.y);

		selectedShapes.clear();

		for (CreateShape shape : shapeList.getList()) {

			if (shape.p1.x < minimum.x + width &&
					shape.p1.x + (Math.abs(shape.p1.x - shape.p2.x)) > minimum.x &&
					shape.p1.y < minimum.y + height &&
					shape.p1.y + (Math.abs(shape.p1.y - shape.p2.y)) > minimum.y) {
				selectedShapes.add(shape);
			}
		}
		System.out.println("Selected ShapeList : " + selectedShapes);

		DrawShape drawShape1 = new DrawShape(shapeList,paintCanvas);
		drawShape1.update();

		for (CreateShape drawShape : shapeList.getList()) {
			for (CreateShape selectShape : selectedShapes) {
				if (selectShape.equals(drawShape)) {
					if (selectShape.shapeConfig.shapeType == ShapeType.RECTANGLE) {
						//Graphics2D graphics2d = paintCanvas.getGraphics2D();
						Stroke stroke = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
						graphics2d.setStroke(stroke);
						graphics2d.setColor(Color.BLACK);
						graphics2d.drawRect(Math.min(selectShape.p1.x, selectShape.p2.x),Math.min(selectShape.p1.y,selectShape.p2.y),Math.abs(selectShape.p1.x-selectShape.p2.x),Math.abs(selectShape.p1.y-selectShape.p2.y));
					}
					else if (selectShape.shapeConfig.shapeType == ShapeType.ELLIPSE) {
						//Graphics2D graphics2d = paintCanvas.getGraphics2D();
						Stroke stroke = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
						graphics2d.setStroke(stroke);
						graphics2d.setColor(Color.BLACK);
						graphics2d.drawOval(Math.min(selectShape.p1.x, selectShape.p2.x),Math.min(selectShape.p1.y,selectShape.p2.y),Math.abs(selectShape.p1.x-selectShape.p2.x),Math.abs(selectShape.p1.y-selectShape.p2.y));
					}
					else if (selectShape.shapeConfig.shapeType == ShapeType.TRIANGLE){
						//Graphics2D graphics2d = paintCanvas.getGraphics2D();
						Stroke stroke = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
						graphics2d.setStroke(stroke);
						graphics2d.setColor(Color.BLACK);
						int[] arrayX = {selectShape.p1.x, selectShape.p1.x, selectShape.p2.x};
						int[] arrayY = {selectShape.p1.y, selectShape.p2.y, selectShape.p2.y};
						graphics2d.drawPolygon(arrayX,arrayY,3);

					}

				}
			}
		}

	}
}
