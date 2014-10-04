package info.entity;

import java.util.ArrayList;

import processing.core.PApplet;

public class Enemy extends GameEntity {

	public Model frameDead;
	public Order order;
	
	public int health;
	
	public Enemy(Model model0, Model frameDead)
	{
		super(model0);
		this.frameDead = frameDead;
		
		order = null;
		health = 100;
	}
	
	public void queueOrder(String type, float... data)
	{
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i] + " ");
		}
		System.out.println();
		order = (new Order(type, data));
	}
	
	public float lastDist = 10000;
	public void tick()
	{
		if (order != null)
		{
			if (order.equals("move"))
			{
				float[] center = model.center();
				float[] data = order.data;
				//float speed = 1.5F;
				
				super.model.moveCenter(center[0] + data[0], 0, center[2] + data[2]);
				order.data[3]--;
				if (order.data[3] <= 0)
				{
					order = null; return;
				}
				
				/*
				//float angle = (float)Math.atan2(target[0] - center[0], target[2] - center[2]);
				//super.model.moveCenter(target[0] - center[0],target[2] - center[2]);
				//System.out.println(PApplet.dist(center[0],center[2],target[0],target[2]));
				//System.out.println(center[0] + " " + center[2] + ";" + target[0] + " " + target[2]);
				
				//super.model.moveCenter(center[0] + speed*(float)Math.cos(angle), 0, center[2] + speed*(float)Math.sin(angle));
				super.model.moveCenter(center[0] + speed*target[0], 0, center[2] + speed*target[2]);
				//System.out.println("*");
				center = model.center();
				float dist = PApplet.dist(center[0],center[2],target[3],target[5]);
				
				if (Math.random() < 0.01)
				{
					System.out.println(center[0] + " " + center[2] + " " + target[3] + " " + target[5]);
					System.out.println(dist);
				}
				if (dist > lastDist)
				{
					System.out.println("finished order " + center[2] + " " + target[2]);
					order = null;
					return;
				}
				lastDist = dist;
				if (dist < 50)
				{
					System.out.println("finished order " + target[3] + " " + target[5]);
					order = null;
					return;
				}
				if (center[0] <= -500)
				{
					order = null;
					super.model.moveCenter(-500, 0, center[2]);
					return;
				}
				else if (center[2] <= -500)
				{
					order = null;
					super.model.moveCenter(center[0],0,-500);
					return;
				}
				else if (center[0] >= 500)
				{
					order = null;
					super.model.moveCenter(500, 0, center[2]);
					return;
				}
				else if (center[2] >= 500)
				{
					order = null;
					super.model.moveCenter(center[0],0,500);
					return;
				}*/
				//System.out.println(center[2] + " " + target[2]);
				//System.out.println(dist(center[0],target[0],center[2],target[2]));
			}
		}
	}
	
	//Wrapper class for an order containing the name and its respective data
	public class Order
	{
		private String type;
		public float[] data;
		
		public Order(String type, float[] data)
		{
			this.type = type;
			this.data = data;
		}
		
		public boolean equals(String t) {return type.equals(t);}
	}
	
}
