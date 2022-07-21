package view.gui;

import model.interfaces.IDraw;
import controller.CreateShapeCommand;
import java.awt.*;

public class DrawTriangle implements IDraw {
    @Override
    public void draw(CreateShapeCommand shape, Graphics2D g) {
       Color primaryColor = shape.primaryColor;
       Color secondaryColor = shape.secondaryColor;
        int[] arrayX = {shape.p1.x, shape.p1.x, shape.p2.x};
        int[] arrayY = {shape.p1.y, shape.p2.y, shape.p2.y};
        if (shape.sst.name().equals("FILLED_IN")) {
            g.setColor(primaryColor);
            g.fillPolygon(arrayX, arrayY, 3);
        } else if (shape.sst.name().equals("OUTLINE")) {
            g.setColor(primaryColor);
            g.drawPolygon(arrayX, arrayY, 3);
        } else {
            g.setColor(primaryColor);
            g.fillPolygon(arrayX, arrayY, 3);
            g.setColor(secondaryColor);
            g.drawPolygon(arrayX, arrayY, 3);
        }
    }
}