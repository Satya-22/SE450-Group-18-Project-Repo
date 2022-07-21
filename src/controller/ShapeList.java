package controller;

import java.util.List;

public class ShapeList {
	
	private final List<CreateShapeCommand> shapeList;
	
	public ShapeList(List<CreateShapeCommand> shapeList) {
		this.shapeList = shapeList; 
	}
	
	public void addShape(CreateShapeCommand shape) {
		shapeList.add(shape); 		
	}
	
	public void removeShape(CreateShapeCommand shape) {
		shapeList.remove(shape);
	}
	
	public List<CreateShapeCommand> getList() {
		return shapeList;
	}
}
