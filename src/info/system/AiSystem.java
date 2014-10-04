package info.system;

import info.entity.Enemy;
import info.render.Main;

public class AiSystem extends BaseSystem {

	public AiSystem(Main main) {
		super(main);
	}
	
	public void tick()
	{
		for (int i = 0; i < main.level.occupants.size(); i++)
		{
			if (main.level.occupants.get(i) instanceof Enemy)
			{
				Enemy en = (Enemy)main.level.occupants.get(i);
				if (en.available())
				{
					//float targetX = 500*(float)Math.random(), targetY = 500*(float)Math.random();
					float targetX = -500, targetY = -500;
					float[] center = en.model.center();
					float angle = (float)Math.atan2(targetX - center[0], targetY - center[2]);
					en.model.globalRotate = angle;
					en.queueOrder("move",targetX,0,targetY);
				}
				en.tick();
			}
		}
	}

}
