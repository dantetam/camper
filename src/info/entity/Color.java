package info.entity;

import data.EntityData;

public class Color {

	public float r, g, b;
	
	public Color(double r, double g, double b)
	{
		this.r = (float)r;
		this.g = (float)g;
		this.b = (float)b;
	}
	
	public Color(int index)
	{
		Color c = EntityData.brickColorMap.get(index);
		r = c.r;
		g = c.g;
		b = c.b;
	}
	
}
