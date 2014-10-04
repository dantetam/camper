package info.entity;

import java.util.ArrayList;

public class GameEntity {

	public Model model;
	
	//public int health;
	
	public GameEntity(Model model)
	{
		this.model = model;
		//health = 100;
	}
	
	public ArrayList<Part>[] tween(Model frame0, Model frame1)
	{
		return null;
	}
	
	public float dist(float x1, float y1, float x2, float y2)
	{
		return (float)Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
	}
	
}
