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
	public InputSystem inputSystem;
	
	public Level level;
	public Player player;
	public EntityData data;
	
	public float width = 1500, height = 900;
	public float centerX = width/2;
	public float centerY = height/2;
	
	public void setup()
	{
		size(1500,900,P3D);
		data = new EntityData();
		data.initi();
		
		level = new Level();
		player = new Player();
		
		systems = new ArrayList<BaseSystem>();
		renderSystem = new RenderSystem(this);
		inputSystem = new InputSystem(this);
		
		systems.add(inputSystem);
		systems.add(renderSystem);
		
		newGameEntity();
	}
	
	public void draw()
	{
		inputSystem.passMouse(mouseX, mouseY);
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
	
	public void mousePressed()
	{
		if (mouseButton == LEFT)
		{
			inputSystem.queueLeftClick(mouseX, mouseY);
		}
		else if (mouseButton == RIGHT)
		{
			inputSystem.queueRightClick(mouseX, mouseY);
		}
	}

	public void keyPressed()
	{
		inputSystem.queueKey(key);
		//inputSystem.test();
	}

	public void keyReleased()
	{
		inputSystem.keyReleased(key);
	}
	
}
