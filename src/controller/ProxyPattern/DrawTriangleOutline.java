package controller.ProxyPattern;

import controller.commands.CreateShapeCommand;
import view.interfaces.PaintCanvasBase;
import java.awt.*;

public class DrawTriangleOutline {
    public void Draw(CreateShapeCommand shape, PaintCanvasBase paintCanvas) {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        int[] arrayX = {shape.p1.x - 5, shape.p1.x - 5, shape.p2.x + 10};
        int[] arrayY = {shape.p1.y - 10, shape.p2.y + 5, shape.p2.y + 5};
        graphics2d.drawPolygon(arrayX, arrayY, 3);

    }
}
