package controller;

import model.ShapeColor;
import model.interfaces.IShapeList;
import view.gui.Rectangle;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import view.interfaces.IDraw;

public class CreateShape implements ICommand, IUndoable {

    private  final ApplicationState appState;
    public IShapeList shapeList;
    private IDraw shape;

    private final int x;
    private final int y;
    private final int x2;
    private final int y2;

    private ShapeColor primaryColor;

    private ShapeColor secondaryColor;

    public CreateShape(int x,int y,int x2,int y2,ApplicationState appState, IShapeList shapeList){
        this.shapeList = shapeList;
//        this.g = g;
        this.x =x;
        this.y = y;
        this.x2 =x2;
        this.y2 = y2;
        this.appState = appState;
    }

    @Override
    public void execute() {
        primaryColor = appState.getActivePrimaryColor();
        secondaryColor = appState.getActiveSecondaryColor();
        System.out.println("ShapeCreateCommand running... ");
        shape = new Rectangle(x,y,x2,y2,primaryColor,secondaryColor,appState);
        System.out.println(shapeList.getShapeList());
        shapeList.addShape(shape);
        System.out.println("Shape Added");
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.removeShape(shape);
    }

    @Override
    public void redo() {
        shapeList.addShape(shape);
    }
}