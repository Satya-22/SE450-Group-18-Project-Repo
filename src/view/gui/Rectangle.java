package view.gui;

import controller.IDraw;
import model.CreateShape;
import java.awt.*;

public class Rectangle implements IDraw {
    @Override
    public void draw(CreateShape shape,Graphics2D g) {
        int px = Math.min(shape.p1.x, shape.p2.x);
        int py = Math.min(shape.p1.y, shape.p2.y);
        int pw = Math.abs(shape.p1.x - shape.p2.x);
        int ph = Math.abs(shape.p1.y - shape.p2.y);

        // Color primaryColor = stringToColor(shape.appState.getActivePrimaryColor().toString());
        Color primaryColor = shape.primaryColor;
        Color secondaryColor = shape.secondaryColor;

		// Color secondaryColor = stringToColor(shape.appState.getActiveSecondaryColor().toString());
        if ((shape.sst.name()).equals("FILLED_IN")) {
            g.setColor(primaryColor);
            g.fillRect(px, py, pw, ph);
        } else if ((shape.sst.name()).equals("OUTLINE")) {
            g.setColor(primaryColor);
            g.drawRect(px, py, pw, ph);
        } else {
            g.setColor(primaryColor);
            g.fillRect(px, py, pw, ph);
            g.setColor(secondaryColor);
            g.drawRect(px, py, pw, ph);
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



