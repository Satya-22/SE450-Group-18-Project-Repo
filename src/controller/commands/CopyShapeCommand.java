package controller.commands;

import controller.DrawnShapeList;
import model.interfaces.ICommand;

public class CopyShapeCommand implements ICommand {

	@Override
	public void run() {
		
		CopyShapeCommand copy = new CopyShapeCommand();

		DrawnShapeList.Counter = 0;
		
		DrawnShapeList.getClipBoard().clear();
		
		for (CreateShapeCommand shape : DrawnShapeList.getList()) {
			if (shape.selected) {
				DrawnShapeList.copyShape(shape);
			}
		}
	}

}
