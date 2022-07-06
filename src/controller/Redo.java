package controller;

public class Redo implements ICommand{

    @Override
    public void execute() {
        CommandHistory.redo();
    }
}