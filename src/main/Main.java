package main;

import controller.DrawStrategy;
import controller.JPaintController;
import controller.MouseHandler;
import controller.DrawnShapeList;
import controller.ShapeMode;
import controller.commandPattern.CreateShapeCommand;
import model.interfaces.IJPaintController;
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
        IJPaintController controller = new JPaintController(uiModule, appState,paintCanvas);
        
        List<CreateShapeCommand> shapeList = new ArrayList<CreateShapeCommand>();
        List<CreateShapeCommand> copyList = new ArrayList<CreateShapeCommand>();
        List<CreateShapeCommand> groupList = new ArrayList<>();
        List<List<CreateShapeCommand>> groupedShapes = new ArrayList<>();
        DrawnShapeList DrawnShapeList = new DrawnShapeList(shapeList, copyList,groupList,groupedShapes);
        DrawStrategy DrawShape = new DrawStrategy(paintCanvas);
        
        int pasteCounter = 0;
        
        MouseHandler handler = new MouseHandler(paintCanvas);
        paintCanvas.addMouseListener(handler);
        MouseHandler.getAppState(appState);
        ShapeMode.getAppState(appState);
        
        controller.setup();
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
