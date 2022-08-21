package controller;

import controller.commandPattern.CreateShapeCommand;
import controller.commandPattern.GroupShape;
import model.StrategyPattern.DrawEllipse;
import model.StrategyPattern.DrawRectangle;
import model.StrategyPattern.DrawTriangle;
import model.NullPattern.NullShape;
import model.interfaces.IDrawShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawStrategy {
	static PaintCanvasBase paintCanvas;
	public DrawStrategy(PaintCanvasBase paintCanvas) {
		this.paintCanvas = paintCanvas;
	}
	public static void drawShape(CreateShapeCommand shape) {

		IDrawShape shapeStrategy;
		switch (shape.shapeConfig.shapeType) {
		case ELLIPSE:
			shapeStrategy = new DrawEllipse();
			break;
		case TRIANGLE:
			shapeStrategy = new DrawTriangle();
			break;
		case RECTANGLE:
			shapeStrategy = new DrawRectangle();
			break;
		default:
			shapeStrategy = new DrawRectangle();
		}
		shapeStrategy.draw(shape,paintCanvas);
	}

	public static void groupBoundingBox(List<CreateShapeCommand> groupList){

		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();

		int x_min =0;
		int x_max = 0;
		int y_min =0;
		int y_max =0;

		for(CreateShapeCommand shapes1 : groupList){

			x.add(shapes1.getP1().x);
			x.add(shapes1.getP2().x);
			y.add(shapes1.getP1().y);
			y.add(shapes1.getP2().y);

			x_min = Collections.min(x);
			x_max = Collections.max(x);
			y_min = Collections.min(y);
			y_max = Collections.max(y);

		}
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		graphics2d.setStroke(stroke);
		graphics2d.setColor(Color.BLACK);
		graphics2d.drawRect(x_min-20,y_min-20,x_max - x_min +30,y_max - y_min +30);
	}

	public static void update() {
		List<GroupShape> groupShape = new ArrayList<>();
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, 2560, 1440);

		for (CreateShapeCommand shape : DrawnShapeList.getList()) {
			drawShape(shape);

			if(SelectedShapeList.selectedShapes.contains(shape) && shape.getShapeGroup().isEmpty()){

			}
			else if(SelectedShapeList.selectedShapes.contains(shape) && !shape.getShapeGroup().isEmpty()) {

				GroupShape groupShape1 = shape.getShapeGroup().get(shape.getShapeGroup().size() -1);
				groupShape.add(groupShape1);
			}
		}

		for(GroupShape group1 : groupShape){
			//same group -- shape list5
			List<CreateShapeCommand> groupedshapeList = new ArrayList<>();
			for(CreateShapeCommand shape2 : DrawnShapeList.getList()){
				if(!shape2.getShapeGroup().isEmpty()){
					GroupShape group2 = shape2.getShapeGroup().get(shape2.getShapeGroup().size() -1);
					if(group1.equals(group2)){
						groupedshapeList.add(shape2);
					}
				}
			}
			groupBoundingBox(groupedshapeList);

		}

	}
}
