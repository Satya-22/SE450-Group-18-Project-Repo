package model;

import model.SingletonPattern.ColorSingleton;

import java.awt.Color;
import java.util.EnumMap;

public class ShapeConfig {
	public Color primaryColor;
	public Color secondaryColor;
	public ShapeType shapeType;
	public ShapeShadingType shadingType;
	public Color primaryColorMapped;
	public Color secColorMapped;

	public ShapeConfig(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeType shapeType,
			ShapeShadingType shadingType) {

		primaryColorMapped = EnumColorMap(primaryColor);
		secColorMapped = EnumColorMap(secondaryColor);
		this.primaryColor = primaryColorMapped;
		this.secondaryColor = secColorMapped;
		this.shapeType = shapeType;
		this.shadingType = shadingType;
	}
	public Color EnumColorMap(ShapeColor shapeColor) {
		EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
		ColorSingleton colorSingleton = ColorSingleton.getInstance(shapeColor,colorMap);
		Color colorMapped = colorMap.get(shapeColor);
		return colorMapped;
	}

}