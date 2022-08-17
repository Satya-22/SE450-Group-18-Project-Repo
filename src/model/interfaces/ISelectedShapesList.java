package model.interfaces;


import controller.commandPattern.CreateShapeCommand;

import java.util.LinkedList;

public interface ISelectedShapesList {
        LinkedList<CreateShapeCommand> selectedShapes = new LinkedList<>();
    }

