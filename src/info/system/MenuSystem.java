package info.system;

import info.render.Main;

public class MenuSystem extends BaseSystem {

	public MenuSystem(Main main)
	{
		super(main);
	}
	
	public void tick()
	{
		main.hint(main.DISABLE_DEPTH_TEST);
		main.camera();
		main.perspective();
		
		main.stroke(0);
		main.fill(255);
		main.rect(745,445,10,10);
		
		main.hint(main.ENABLE_DEPTH_TEST);
	}
	
}
