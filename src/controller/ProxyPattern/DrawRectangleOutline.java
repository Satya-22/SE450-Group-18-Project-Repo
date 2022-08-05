package controller.ProxyPattern;

import controller.commands.CreateShapeCommand;
import view.interfaces.PaintCanvasBase;
import java.awt.*;

public class DrawRectangleOutline {
    public void Draw(CreateShapeCommand shape, PaintCanvasBase paintCanvas){
            Graphics2D graphics2d = paintCanvas.getGraphics2D();
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2d.setStroke(stroke);
            graphics2d.setColor(Color.BLACK);
            graphics2d.drawRect(shape.x-5, shape.y-5,shape.w+10, shape.l+10);

    }
}
