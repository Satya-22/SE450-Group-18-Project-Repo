package controller;

import controller.commands.CreateShapeCommand;
import model.interfaces.IDrawShape;
import view.interfaces.PaintCanvasBase;

public class NullShape implements IDrawShape {

    @Override
    public void draw(CreateShapeCommand shape, PaintCanvasBase paintCanvas) {
        System.out.println("Shape not found");
    }
}