package model.interfaces;

import controller.CreateShapeCommand;

import java.awt.*;

public interface IDraw {

    public void draw(CreateShapeCommand shape, Graphics2D graphics2D);
}