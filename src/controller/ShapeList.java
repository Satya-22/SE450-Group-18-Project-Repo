package controller;

import java.util.List;

import model.CreateShape;

public class ShapeList {
	
	private final List<CreateShape> shapeList;
	
	public ShapeList(List<CreateShape> shapeList) {
		this.shapeList = shapeList; 
	}
	
	public void addShape(CreateShape shape) {
		shapeList.add(shape); 		
	}
	
	public void removeShape(CreateShape shape) {
		shapeList.remove(shape);
	}
	
	public List<CreateShape> getList() {
		return shapeList;
	}
}
