package info.entity;

public class Part {

	public float posX, posY, posZ;
	public float sizeX, sizeY, sizeZ;
	public float rotX, rotY, rotZ;
	public Color color;
	public long id;
	
	public Part()
	{
		id = (long)(System.currentTimeMillis()*Math.random()*Math.random());
	}
	
	public void move(float x, float y, float z)
	{
		posX += x; posY += y; posZ += z;
	}
	
	public void moveTo(float x, float y, float z)
	{
		posX = x; posY = y; posZ = z;
	}
	
	public void size(float x, float y, float z)
	{
		sizeX = x; sizeY = y; sizeZ = z;
	}
	
	public void rotate(float x, float y, float z)
	{
		rotX = x; rotY = y; rotZ = z;
	}
	
	public boolean within(double x, double y, double z)
	{
		return x >= posX - sizeX/2 && x <= posX + sizeX/2 &&
				 y >= posY - sizeY/2 && y <= posY + sizeY/2 &&
				 z >= posZ - sizeZ/2 && z <= posZ + sizeZ/2;
	}
	
	public boolean equals(Part other)
	{
		return id == other.id;
	}
	
}
