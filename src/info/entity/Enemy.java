package info.entity;

import java.util.ArrayList;

public class Enemy extends GameEntity {

	public Model frameDead;
	private ArrayList<Order> orders;
	
	public int health;
	
	public Enemy(Model model0, Model frameDead)
	{
		super(model0);
		this.frameDead = frameDead;
		
		orders = new ArrayList<Order>();
		health = 100;
	}
	
	public void queueOrder(String type, float... data)
	{
		orders.add(new Order(type, data));
	}
	
	public boolean available()
	{
		return orders.size() == 0;
	}
	
	public void tick()
	{
		if (orders.size() > 0)
		{
			if (orders.get(0).equals("move"))
			{
				float[] center = model.center();
				float[] target = orders.get(0).data;
				float speed = 1.5F;
				float angle = (float)Math.atan2(target[0] - center[0], target[2] - center[2]);
				super.model.moveCenter(center[0] + speed*(float)Math.sin(angle), 0, center[2] + speed*(float)Math.cos(angle));
				System.out.println("*");
				System.out.println(center[0] + " " + center[1] + " " + center[2]);
				center = model.center();
				if (dist(center[0],target[0],center[2],target[2]) < 5)
				{
					orders.remove(0);
				}
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
