package info.level;

import java.util.ArrayList;

import info.entity.GameEntity;
import info.entity.Part;

public class Level {

	public ArrayList<GameEntity> occupants;
	public ArrayList<Part> parts;
	
	public Level()
	{
		occupants = new ArrayList<GameEntity>();
		parts = new ArrayList<Part>();
	}
	
}
