package controller;

import java.util.List;

import controller.commands.CreateShapeCommand;

public class DrawnShapeList {
	private static List<CreateShapeCommand> shapeList;
	private static List<CreateShapeCommand> copyList;

	public DrawnShapeList(List<CreateShapeCommand> shapeList, List<CreateShapeCommand> copyList) {
		DrawnShapeList.shapeList = shapeList;
		DrawnShapeList.copyList = copyList;
	}

	public static void addShape(CreateShapeCommand shape) {
		shapeList.add(shape);
		DrawStrategy.update();
	}

	public static void removeShape(CreateShapeCommand shape) {
		shapeList.remove(shape);
		DrawStrategy.update();
	}
	
	public static void copyShape(CreateShapeCommand shape) {
		copyList.add(shape);
	}

	public static List<CreateShapeCommand> getList() {
		return shapeList;
	}
	
	public static List<CreateShapeCommand> getClipBoard() {
		return copyList;
	}
}
