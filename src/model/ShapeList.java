package model;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IShapeList;
import model.interfaces.IUpdateShapeList;
import view.interfaces.IDraw;

public class ShapeList implements IShapeList {

    private final ArrayList<IDraw> ShapesList = new ArrayList<IDraw>();
    private final ArrayList<IUpdateShapeList> updateShapeLists = new ArrayList<IUpdateShapeList>();
    private List<IDraw> shapes;

    @Override
    public void addShape(IDraw shapes) {
        ShapesList.add(shapes);
        updateList();
    }

    @Override
    public void removeShape(IDraw shapes) {
        ShapesList.remove(shapes);
        updateList();
    }
    @Override
    public void register(IUpdateShapeList updateShapeList) {
        updateShapeLists.add(updateShapeList);
    }

    @Override
    public void unsubscribe(IUpdateShapeList observer) {
        updateShapeLists.remove(observer);
    }

    @Override
    public ArrayList<IDraw> getShapeList() {
        return ShapesList;
    }

    @Override
    public void updateList() {

        for(IUpdateShapeList newUpdateShapeList : updateShapeLists ){
            newUpdateShapeList.update();
        }

    }

}
