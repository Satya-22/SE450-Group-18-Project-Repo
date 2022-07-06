package model.interfaces;

import view.interfaces.IDraw;

import java.util.ArrayList;

public interface IShapeList {

    public void addShape(IDraw shape);

    public void removeShape(IDraw shape);

    ArrayList<IDraw> getShapeList();

    void register(IUpdateShapeList paintCanvas);

    void unsubscribe(IUpdateShapeList paintCanvas);

    void updateList();

}
