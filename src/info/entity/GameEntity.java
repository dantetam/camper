package info.entity;

import java.util.ArrayList;

public class GameEntity {

	public Model model;
	
	public int health;
	
	public GameEntity(Model model)
	{
		this.model = model;
		health = 100;
	}
	
	public ArrayList<Part>[] tween(Model frame0, Model frame1)
	{
		return null;
	}
	
}
