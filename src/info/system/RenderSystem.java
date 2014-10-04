package info.system;

import info.entity.Model;
import info.entity.Part;
import info.render.Main;

public class RenderSystem extends BaseSystem {

	public RenderSystem(Main main) {
		super(main);
	}

	public void tick()
	{
		main.background(255);
		main.noStroke();
		main.camera(main.player.posX,main.player.posY,main.player.posZ,
				main.player.tarX,main.player.tarY,main.player.tarZ,
				0,-1,0);
		main.perspective(3.14F/3,15F/9F,1,10000);
		for (int i = 0; i < main.level.occupants.size(); i++)
		{
			Model model = main.level.occupants.get(i).model;
			for (int j = 0; j < model.parts.size(); j++)
			{
				Part part = model.parts.get(j);
				render(part,model.globalRotate);
			}
		}
	}
	
	public void render(Part p, float globalRotate)
	{
		main.pushMatrix();
		main.rotateY(globalRotate);
		main.pushMatrix();
		main.translate(p.posX, p.posY, p.posZ);
		main.rotateX(p.rotX);
		main.rotateY(p.rotY);
		main.rotateZ(p.rotZ);
		main.fill(p.color);
		main.box(p.sizeX, p.sizeY, p.sizeZ);
		main.popMatrix();
		main.popMatrix();
	}
	
}
