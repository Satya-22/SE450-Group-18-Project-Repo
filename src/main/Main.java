package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.MousePointer;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;
import model.ShapeList;

public class Main {
    public static void main(String[] args){

        ShapeList shapelist = new ShapeList();
        PaintCanvas paintCanvas = new PaintCanvas(shapelist);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        MousePointer mousePointer = new MousePointer(paintCanvas,appState,shapelist);
        paintCanvas.addMouseListener(mousePointer);
        controller.setup();
    }
}
