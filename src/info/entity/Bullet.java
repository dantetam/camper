package info.entity;

public class Bullet extends Part {

	public float velX, velY, velZ;
	
	public Bullet(float x, float y, float z)
	{
		size(0.5F,0.5F,0.5F);
		velX = x/10; velY = y/10; velZ = z/10;
		super.color = new Color(0,0,0);
	}
	
}
