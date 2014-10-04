package info.entity;

import java.util.ArrayList;

public class Model {

	public ArrayList<Part> parts;
	
	public Model()
	{
		parts = new ArrayList<Part>();
	}
	
	public void moveCenter(float x, float y, float z)
	{
		float[] center = center();
		//Displacement[] d = new Displacement[parts.size()];
		for (int i = 0; i < parts.size(); i++)
		{
			Displacement d = new Displacement(parts.get(i), center);
			parts.get(i).moveTo(center[0], center[1], center[2]);
			parts.get(i).move(d.x, d.y, d.z);
		}
	}
	
	public class Displacement
	{
		float x, y, z;
		public Displacement(float a, float b, float c) {x = a; y = b; z = c;}
		public Displacement(Part p, float[] center)
		{
			x = p.posX - center[0];
			y = p.posY - center[1];
			z = p.posZ - center[2];
		}
	}
	
	public float[] center()
	{
		if (parts.size() <= 0) return null;
		float minX = parts.get(0).posX, 
				maxX = parts.get(0).posX, 
				minY = parts.get(0).posY, 
				maxY = parts.get(0).posY, 
				minZ = parts.get(0).posZ, 
				maxZ = parts.get(0).posZ;
		for (int i = 0; i < parts.size(); i++)
		{
			if (parts.get(i).posX < minX) minX = parts.get(i).posX;
			else if (parts.get(i).posX > maxX) maxX = parts.get(i).posX;
			if (parts.get(i).posY < minY) minY = parts.get(i).posY;
			else if (parts.get(i).posY > maxY) maxY = parts.get(i).posY;
			if (parts.get(i).posZ < minZ) minZ = parts.get(i).posZ;
			else if (parts.get(i).posZ > maxZ) maxZ = parts.get(i).posZ;
		}
		return new float[]{(minX+maxX)/2,(minY+maxY)/2,(minZ+maxZ)/2};
	}
	
	public boolean hitbox(float x, float y, float z)
	{
		if (parts.size() <= 0) return false;
		float minX = parts.get(0).posX, 
				maxX = parts.get(0).posX, 
				minY = parts.get(0).posY, 
				maxY = parts.get(0).posY, 
				minZ = parts.get(0).posZ, 
				maxZ = parts.get(0).posZ;
		for (int i = 0; i < parts.size(); i++)
		{
			if (parts.get(i).posX < minX) minX = parts.get(i).posX;
			else if (parts.get(i).posX > maxX) maxX = parts.get(i).posX;
			if (parts.get(i).posY < minY) minY = parts.get(i).posY;
			else if (parts.get(i).posY > maxY) maxY = parts.get(i).posY;
			if (parts.get(i).posZ < minZ) minZ = parts.get(i).posZ;
			else if (parts.get(i).posZ > maxZ) maxZ = parts.get(i).posZ;
		}
		return x >= minX && x <= maxX &&
				y >= minY && y <= maxY &&
				z >= minZ && z <= maxZ;
	}
	
}
