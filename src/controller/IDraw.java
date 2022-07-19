package controller;

import model.CreateShape;

import java.awt.*;

public interface IDraw {

    public void draw(CreateShape shape,Graphics2D graphics2D);
}