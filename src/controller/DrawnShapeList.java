package controller;

import controller.commandPattern.CreateShapeCommand;

import java.util.ArrayList;
import java.util.List;

public class DrawnShapeList {
	private static List<CreateShapeCommand> shapeList;
	private static List<CreateShapeCommand> copyList;
	public static List<CreateShapeCommand> groupList;

	public static List<List<CreateShapeCommand>> groupedShapes = new ArrayList<>();
	public static int Counter;

	public static int x;

	public static int y;
	public static int l;
	public static int w;

	public DrawnShapeList(List<CreateShapeCommand> shapeList, List<CreateShapeCommand> copyList,List<CreateShapeCommand> groupList,List<List<CreateShapeCommand>> groupedShapes) {
		DrawnShapeList.shapeList = shapeList;
		DrawnShapeList.copyList = copyList;
		DrawnShapeList.groupList = groupList;
		DrawnShapeList.groupedShapes = groupedShapes;
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

	//public static void groupShape(CreateShapeCommand shape){groupList.add(0,);}

	public static List<CreateShapeCommand> getList() {
		return shapeList;
	}
	
	public static List<CreateShapeCommand> getClipBoard() {
		return copyList;
	}

	public static int pasteCounter(){
		Counter++;
		return Counter;
	}
}
