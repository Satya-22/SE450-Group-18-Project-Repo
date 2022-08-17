package model.NullPattern;

import controller.commandPattern.CreateShapeCommand;
import controller.commandPattern.GroupShape;
import model.interfaces.IDrawShape;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

public class NullShape implements IDrawShape {

    @Override
    public void draw(CreateShapeCommand shape, PaintCanvasBase paintCanvas) {
        System.out.println("Shape not found");
    }


    public void MoveShape(int delx, int dely) {
        return;
    }


    public void addGroupShape(GroupShape groupShape) {
      return;
    }


    public ArrayList<GroupShape> getShapeGroup() {
        return null;
    }


    public void removeGroupShape() {
        return;
    }
}