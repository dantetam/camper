package info.render;

import java.util.ArrayList;

import data.EntityData;
import info.entity.Color;
import info.entity.GameEntity;
import info.entity.Player;
import info.level.Level;
import info.system.*;
import processing.core.PApplet;

public class Main extends PApplet {

	public ArrayList<BaseSystem> systems;
	public RenderSystem renderSystem;
	
	public Level level;
	public Player player;
	public EntityData data;
	
	public void setup()
	{
		size(1500,900,P3D);
		data = new EntityData();
		data.initi();
		
		level = new Level();
		player = new Player();
		
		systems = new ArrayList<BaseSystem>();
		renderSystem = new RenderSystem(this);
		systems.add(renderSystem);
		
		newGameEntity();
	}
	
	public void draw()
	{
		for (int i = 0; i < systems.size(); i++)
		{
			systems.get(i).tick();
		}
	}
	
	public void fill(Color c)
	{
		fill(c.r*255, c.g*255, c.b*255);
	}
	
	public void newGameEntity()
	{
		GameEntity grunt0 = new GameEntity(data.getModel("Grunt"));
		level.occupants.add(grunt0);
	}
	
}
