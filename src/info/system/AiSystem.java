package info.system;

import info.entity.Bullet;
import info.entity.Enemy;
import info.entity.Part;
import info.render.Main;

public class AiSystem extends BaseSystem {

	public AiSystem(Main main) {
		super(main);
	}

	public void tick()
	{
		for (int i = main.level.occupants.size() - 1; i >= 0; i--)
		{
			if (main.level.occupants.get(i) instanceof Enemy)
			{
				Enemy en = (Enemy)main.level.occupants.get(i);
				if (en.order == null)
				{
					System.out.println("made order");
					move(en,(float)(500*Math.random()),(float)(500*Math.random()));
				}
				en.tick();
				/*if (main.renderSystem.highlightedPart != null)
				{
					for (int j = 0; j < en.model.parts.size(); j++)
					{
						Part p = en.model.parts.get(j);
						if (p.equals(main.renderSystem.highlightedPart))
						{
							main.level.occupants.remove(i);
						}
					}
				}*/
			}
		}
		for (int i = 0; i < main.level.parts.size(); i++)
		{
			if (main.level.parts.get(i) instanceof Bullet)
			{
				Bullet b = (Bullet)main.level.parts.get(i);
				b.move(b.velX, b.velY, b.velZ);
				//b.move(main.player.posX, main.player.posY, main.player.posZ);
			}
		}
	}

	public void move(Enemy en, float targetX, float targetY)
	{
		//float targetX = 500*(float)Math.random(), targetY = 500*(float)Math.random();
		//float targetX = (float)(Math.random()*500 - 250), targetY = (float)(Math.random()*500 - 250);
		float[] center = en.model.center();
		//Calculate unit vector
		//float dist = main.dist(targetX,targetY,center[0],center[2]); 
		float ux = 1.5F*(float)(Math.random()-0.5);//(targetX - center[0])/dist;
		float uy = 1.5F*(float)(Math.random()-0.5);//(targetY - center[1])/dist;
		//Rotate properly
		float angle = (float)Math.atan2(ux,uy);
		en.model.globalRotate = angle;
		en.queueOrder("move",ux,0,uy,(int)(Math.random()*250 + 500));
	}

}
