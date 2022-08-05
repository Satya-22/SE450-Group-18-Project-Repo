package model.interfaces;


import controller.commands.CreateShapeCommand;

import java.util.LinkedList;

public interface ISelectedShapesList {
        LinkedList<CreateShapeCommand> selectedShapes = new LinkedList<>();
    }

