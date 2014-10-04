package info.entity;

import info.vector.*;
import info.entity.Part;

public class Player {

	public float posX, posY, posZ;
	public float tarX, tarY, tarZ;
	public float rotY, rotVertical;
	
	public Player()
	{
		posX = 100; posY = 0; posZ = 100;
		tarX = 0; tarY = 0; tarZ = 0;
		rotY = 0;
		rotVertical = 0;
	}
	
	public void update()
	{
		float dist = 100;
		tarX = posX + dist*(float)Math.cos(rotY);
		tarY = posY - dist*(float)Math.sin(rotVertical)*2;
		tarZ = posZ + dist*(float)Math.sin(rotY);
	}

	public Line getLookVector()
	{
		return new Line(tarX-posX,posX,tarY-posY,posY,tarZ-posZ,posZ);
	}

	public boolean lookingAtEntity(Part en)
	{
		Line lookVector = getLookVector();
		Plane plane = (planeFromPoints(
				new Point(en.posX,en.posY - en.sizeY/2,en.posZ),
				new Point(en.posX+en.sizeY/2,en.posY - en.sizeY/2,en.posZ),
				new Point(en.posX+en.sizeY/2,en.posY - en.sizeY/2,en.posZ+en.sizeZ/2)
				));
		Point intersection = plane.intersect(lookVector);

		if (en.within(intersection.x,intersection.y,intersection.z))
		{
			return true;
		}
		return false;
	}

	public Plane planeFromPoints(Point a, Point b, Point c)
	{
		int x = (int)((b.y - a.y)*(c.z - a.z) - (c.y - a.y)*(b.z - a.z));
		int y = (int)(-(b.x - a.x)*(c.z - a.z) + (c.x - a.x)*(b.z - a.z));
		int z = (int)((b.x - a.x)*(c.y - a.y) - (c.x - a.x)*(b.y - a.y));
		int d = (int)(x*a.x + y*a.y + z*a.z);
		//int e = (int)(x*b.x + y*b.y + z*b.z);
		//System.out.println(d + " " + e);
		return new Plane(x,y,z,d);
	}
	
}
