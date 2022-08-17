package model.SingletonPattern;

import model.ShapeColor;

import java.awt.Color;
import java.util.EnumMap;

public class ColorSingleton {

    private static ColorSingleton singleton_instance = null;
    public static EnumMap<ShapeColor, Color> colorMap;
    public ShapeColor shapeColor;
    public ColorSingleton(ShapeColor shapeColor, EnumMap<ShapeColor, Color> colorMap) {

        this.shapeColor = shapeColor;
        this.colorMap = colorMap;
        this.colorMap.put(ShapeColor.BLACK, Color.BLACK);
        this.colorMap.put(ShapeColor.BLUE, Color.BLUE);
        this.colorMap.put(ShapeColor.CYAN, Color.CYAN);
        this.colorMap.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
        this.colorMap.put(ShapeColor.GRAY, Color.GRAY);
        this.colorMap.put(ShapeColor.GREEN, Color.GREEN);
        this.colorMap.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
        this.colorMap.put(ShapeColor.MAGENTA, Color.MAGENTA);
        this.colorMap.put(ShapeColor.ORANGE, Color.ORANGE);
        this.colorMap.put(ShapeColor.PINK, Color.PINK);
        this.colorMap.put(ShapeColor.RED, Color.RED);
        this.colorMap.put(ShapeColor.WHITE, Color.WHITE);
        this.colorMap.put(ShapeColor.YELLOW, Color.YELLOW);
    }

    public static ColorSingleton getInstance(ShapeColor shapeColor, EnumMap<ShapeColor, Color> colorMap){

        singleton_instance = new ColorSingleton(shapeColor, colorMap);

        return singleton_instance;
    }
}

