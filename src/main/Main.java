package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseHandler;
import controller.ShapeList;
import model.CreateShape;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){


        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);

        List<CreateShape> shapeList = new ArrayList<CreateShape>();
        final ShapeList ShapeList = new ShapeList(shapeList);
        
        MouseHandler handler = new MouseHandler(paintCanvas,appState, ShapeList);
        paintCanvas.addMouseListener(handler);
        
        controller.setup();
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
