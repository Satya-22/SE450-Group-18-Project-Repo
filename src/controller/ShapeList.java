package controller;

import java.util.List;

import controller.commands.CreateShape;

public class ShapeList {

	private static List<CreateShape> shapeList;
	private static List<CreateShape> copyList;

	public ShapeList(List<CreateShape> shapeList, List<CreateShape> copyList) {
		ShapeList.shapeList = shapeList;
		ShapeList.copyList = copyList;
	}

	public static void addShape(CreateShape shape) {
		shapeList.add(shape);
		DrawStrategy.update();
	}

	public static void removeShape(CreateShape shape) {
		shapeList.remove(shape);
		DrawStrategy.update();
	}
	
	public static void copyShape(CreateShape shape) {
		copyList.add(shape);
	}

	public static List<CreateShape> getList() {
		return shapeList;
	}
	
	public static List<CreateShape> getClipBoard() {
		return copyList;
	}
}
