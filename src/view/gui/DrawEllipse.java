package view.gui;

import model.interfaces.IDraw;
import controller.CreateShapeCommand;
import java.awt.*;

public class DrawEllipse implements IDraw {
    @Override
    public void draw(CreateShapeCommand shape, Graphics2D g) {
        int px = Math.min(shape.p1.x, shape.p2.x);
        int py = Math.min(shape.p1.y, shape.p2.y);
        int pw = Math.abs(shape.p1.x - shape.p2.x);
        int ph = Math.abs(shape.p1.y - shape.p2.y);
        Color primaryColor = shape.primaryColor;
        Color  secondaryColor = shape.secondaryColor;
        if(shape.sst.name().equals("FILLED_IN")){
            g.setColor(primaryColor);
            g.fillOval(px, py, pw, ph);
        }
        else if(shape.sst.name().equals("OUTLINE")){
            g.setColor(primaryColor);
            g.drawOval(px, py, pw, ph);
        }
        else{
            g.setColor(primaryColor);
            g.fillOval(px,py,pw,ph);
            g.setColor(secondaryColor);
            g.drawOval(px, py, pw, ph);
        }

    }
}