package view.gui;

import controller.IDraw;
import model.CreateShape;
import java.awt.*;

public class Triangle implements IDraw {

    @Override
    public void draw(CreateShape shape, Graphics2D g) {
       Color primaryColor = stringToColor(shape.appState.getActivePrimaryColor().toString());
       Color secondaryColor = stringToColor(shape.appState.getActiveSecondaryColor().toString());
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

    public static Color stringToColor(final String value) {
        if (value == null) {
            return Color.black;
        }
        try {
            return Color.decode(value);
        } catch (NumberFormatException nfe) {
            try {
                final java.lang.reflect.Field f = Color.class.getField(value);

                return (Color) f.get(null);
            } catch (Exception ce) {
                return Color.black;
            }
        }
    }
}