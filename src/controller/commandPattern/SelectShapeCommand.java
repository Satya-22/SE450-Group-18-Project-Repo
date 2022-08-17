package controller.commandPattern;

import controller.DrawStrategy;
import controller.DrawnShapeList;
import controller.SelectedShapeList;
import model.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class SelectShapeCommand implements ICommand {
	private final Point startPoint;
	private final Point endPoint;
	public Point minimum;
	public int width;
	public int height;
	private final PaintCanvasBase paintCanvas;

	public SelectShapeCommand(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas) {
		this.paintCanvas = paintCanvas;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	@Override
	public void run() {

		minimum = new Point(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y));

		width = Math.abs(startPoint.x - endPoint.x);

		height = Math.abs(startPoint.y - endPoint.y);

		SelectedShapeList.selectedShapes.clear();

		for (CreateShapeCommand shape : DrawnShapeList.getList()) {
			shape.selected = false;
			DrawStrategy.update();
			if ((shape.p1.x < minimum.x + width && shape.p1.x + (Math.abs(shape.p1.x - shape.p2.x)) > minimum.x
					&& shape.p1.y < minimum.y + height
					&& shape.p1.y + (Math.abs(shape.p1.y - shape.p2.y)) > minimum.y)) {
				if (!shape.getShapeGroup().isEmpty()) {
					GroupShape group = shape.getShapeGroup().get(shape.getShapeGroup().size() - 1);
					for (CreateShapeCommand shape1 : DrawnShapeList.getList()) {
						if (!shape1.getShapeGroup().isEmpty()) {
							GroupShape group1 = shape1.getShapeGroup().get(shape1.getShapeGroup().size() - 1);

							if (group1.equals(group)) {
								if (!SelectedShapeList.selectedShapes.contains(shape1)){
									SelectedShapeList.selectedShapes.add(shape1);
									shape1.selected = true;
							}
							}
						}
					}

				}
				else if(!SelectedShapeList.selectedShapes.contains(shape)) {
					SelectedShapeList.selectedShapes.add(shape);
					shape.selected = true;
				}
				DrawStrategy.update();
			}
		}
		System.out.println("Selected Shapes in Select Shapes Class : "+SelectedShapeList.selectedShapes);
	}
}
