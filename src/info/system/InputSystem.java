package info.system;

import info.entity.Bullet;
import info.entity.GameEntity;
import info.render.Main;
import info.vector.Line;

import java.util.ArrayList;

public class InputSystem extends BaseSystem {

	private ArrayList<Character> keyPresses;

	public InputSystem(Main main)
	{
		super(main);
		keyPresses = new ArrayList<Character>();
	}

	//Goes through keys backwards to avoid arraylist trap
	public void tick()
	{
		for (int i = keyPresses.size() - 1; i >= 0; i--)
		{
			executeAction(keyPresses.get(i));
			keyPresses.remove(i);
		}
		for (int i = 0; i < keyHeld.length; i++)
		{
			if (keyHeld[i])
			{
				float dist = 3;
				//System.out.println(i+97);
				if (i == 97 - 97) //a
				{
					//Limit movement to an axis
					main.player.posX += dist*Math.cos(main.player.rotY + Math.PI/2);
					main.player.tarX += dist*Math.cos(main.player.rotY + Math.PI/2);
					main.player.posZ += dist*Math.sin(main.player.rotY + Math.PI/2);
					main.player.tarZ += dist*Math.sin(main.player.rotY + Math.PI/2);
				}
				else if (i == 100 - 97) //d
				{
					//Limit movement to an axis
					main.player.posX += dist*Math.cos(main.player.rotY - Math.PI/2);
					main.player.tarX += dist*Math.cos(main.player.rotY - Math.PI/2);
					main.player.posZ += dist*Math.sin(main.player.rotY - Math.PI/2);
					main.player.tarZ += dist*Math.sin(main.player.rotY - Math.PI/2);
				}
				else if (i == 115 - 97) //s
				{
					//Limit movement to an axis
					main.player.posX -= dist*Math.cos(main.player.rotY);
					main.player.tarX -= dist*Math.cos(main.player.rotY);
					main.player.posZ -= dist*Math.sin(main.player.rotY);
					main.player.tarZ -= dist*Math.sin(main.player.rotY);
				}
				else if (i == 119 - 97) //w
				{
					//Limit movement to an axis
					main.player.posX += dist*Math.cos(main.player.rotY);
					main.player.tarX += dist*Math.cos(main.player.rotY);
					main.player.posZ += dist*Math.sin(main.player.rotY);
					main.player.tarZ += dist*Math.sin(main.player.rotY);
				}
				/*else if (i == 113 - 97) //q
				{
					//Limit movement to an axis
					main.player.posY -= dist;
					main.player.tarY -= dist;
				}
				else if (i == 101 - 97) //e
				{
					//Limit movement to an axis
					main.player.posY += dist;
					main.player.tarY += dist;
				}*/
				if (i == 0 || i == 3 || i == 4 || i == 16 || i == 18 || i == 22)
				{
					//main.setUpdateFrame(50);
					//if (moving) main.setUpdateFrame(10);
					main.player.update();
				}
				//System.out.println(moving);
				//main.redraw();
			}
		}
		for (int i = clicks.size() - 1; i >= 0; i--)
		{
			Click c = clicks.get(i);
			if (c.type.equals("Left"))
			{
				passLeftMouseClick(c.mouseX, c.mouseY);
			}
			else if (c.type.equals("Right"))
			{
				passRightMouseClick(c.mouseX, c.mouseY);
			}
			clicks.remove(i);
		}
	}

	//Stores which keys are being held (such as panning with WASD)
	public boolean[] keyHeld = new boolean[26];
	public void queueKey(char key)
	{
		if (key >= 97 && key <= 122)
		{
			keyHeld[key-97] = true;
		}
		keyPresses.add(0,key);
	}

	public void keyReleased(char key)
	{
		if (key >= 97 && key <= 122)
		{
			keyHeld[key-97] = false;
		}
	}

	//public float lastMouseX = main.width/2; //public float lastMouseY = main.height/2;
	public void passMouse(float mouseX, float mouseY)
	{
		float dX = (mouseX - main.centerX)/(main.centerX);
		float dY = (mouseY - main.centerY)/(main.centerY);
		main.player.rotY = -(float)Math.PI*dX; //Axis is weird, oh well
		main.player.rotVertical = (float)Math.PI/4*dY;
		main.player.update();
	}

	public ArrayList<Click> clicks = new ArrayList<Click>();
	public class Click {String type; float mouseX, mouseY; Click(String t, float x, float y) {type = t; mouseX = x; mouseY = y;}}
	public void queueLeftClick(float mouseX, float mouseY)
	{
		clicks.add(0, new Click("Left",mouseX, mouseY));
	}
	public void queueRightClick(float mouseX, float mouseY)
	{
		clicks.add(0, new Click("Right",mouseX, mouseY));
	}

	//Make a system to cycle through units on a list
	//private ArrayList<GameEntity> lastList = null;
	//private int num = 0;
	public void passLeftMouseClick(float mouseX, float mouseY)
	{
		Line lv = main.player.getLookVector(); //.unit();
		//lv = new Line(lv.xCo/10,lv.yCo/10,lv.zCo/10,0,0,0);
		Bullet b = new Bullet((float)lv.xCo, (float)lv.yCo, (float)lv.zCo);
		b.move(main.player.posX, main.player.posY, main.player.posZ);
		main.level.parts.add(b);
		
		GameEntity en = main.renderSystem.highlightedEntity;
		if (en != null)
		{
			main.level.occupants.remove(en);
		}
	}

	public void passRightMouseClick(float mouseX, float mouseY)
	{
		
	}

	/*public void test()
	{
		for (int i = 0; i < keyHeld.length; i++)
		{
			if (keyHeld[i])
			{
				//System.out.println(i+97);
				if (i == 0)
				{
					//Limit movement to an axis
					main.player.posX += 10;
					main.player.tarX += 10;
				}
			}
		}
	}*/

	public void executeAction(char key)
	{
		if (key == 32)
		{
	
		}
	}

}
