package controller;

public class Undo implements ICommand{

    @Override
    public void execute() {
        CommandHistory.undo();
        System.out.println("UndoCommand running.");
    }
}