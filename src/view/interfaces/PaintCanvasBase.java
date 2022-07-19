package view.interfaces;

import controller.ShapeList;

import javax.swing.*;
import java.awt.*;

public abstract class PaintCanvasBase extends JComponent {
    public abstract Graphics2D getGraphics2D();

}
