package info.system;

import info.render.Main;

public abstract class BaseSystem {

	public Main main;
	
	public BaseSystem(Main main)
	{
		this.main = main;
	}
	
	public abstract void tick();
	
}
