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
				render(model,part,model.globalRotate);
			}
		}
		main.translate(500,0,500);
		main.fill(255,0,0);
		main.box(25);
	}
	
	public void render(Model m, Part p, float globalRotate)
	{
		main.pushMatrix();
		//main.rotateY((float)Math.PI);
		//main.pushMatrix();
		float[] c = m.center();
		main.translate(c[0], c[1], c[2]);
		main.rotateY(globalRotate);//(float)Math.PI/4);
		main.pushMatrix();
		main.translate(p.posX - c[0], p.posY - c[1], p.posZ - c[2]);
		main.rotateX(p.rotX);
		main.rotateY(p.rotY);
		main.rotateZ(p.rotZ);
		main.fill(p.color);
		main.box(p.sizeX, p.sizeY, p.sizeZ);
		main.popMatrix();
		main.popMatrix();
	}
	
}
