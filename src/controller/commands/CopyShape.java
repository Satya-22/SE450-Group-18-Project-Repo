package controller.commands;



import controller.ShapeList;
import model.interfaces.ICommand;

public class CopyShape implements ICommand {


	@Override
	public void run() {
		
		CopyShape copy = new CopyShape();
		
		ShapeList.getClipBoard().clear();
		
		for (CreateShape shape : ShapeList.getList()) {
			if (shape.selected) {
				ShapeList.copyShape(shape);
			}
		}
	}

}
