package info.render;

import java.util.ArrayList;

import data.EntityData;
import info.entity.Color;
import info.entity.Enemy;
import info.entity.GameEntity;
import info.entity.Player;
import info.level.Level;
import info.system.*;
import processing.core.PApplet;

public class Main extends PApplet {

	public ArrayList<BaseSystem> systems;
	public RenderSystem renderSystem;
	public MenuSystem menuSystem;
	public InputSystem inputSystem;
	public AiSystem aiSystem;
	
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
		menuSystem = new MenuSystem(this);
		inputSystem = new InputSystem(this);
		aiSystem = new AiSystem(this);
		
		systems.add(inputSystem);
		systems.add(aiSystem);
		systems.add(renderSystem);
		systems.add(menuSystem);
		
		newGameEntity();
	}
	
	public void draw()
	{
		inputSystem.passMouse(mouseX, mouseY);
		for (int i = 0; i < systems.size(); i++)
		{
			systems.get(i).tick();
		}
		println(renderSystem.highlightedPart);
	}
	
	public void fill(Color c)
	{
		fill(c.r*255, c.g*255, c.b*255);
	}
	
	public void newGameEntity()
	{
		Enemy grunt0 = new Enemy(data.getModel("Grunt"),data.getModel("Grunt"));
		level.occupants.add(grunt0);
	}
	
	public void mousePressed()
	{
		if (mouseButton == LEFT)
		{
			inputSystem.queueLeftClick(mouseX, mouseY);
			//level.occupants.get(0).model.moveCenter(50, 50, 50);
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
