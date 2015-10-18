package net.kerfuffle.NetworkedGame;

import static net.kerfuffle.Utilities.Util.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

public class Main {

	static final int WIDTH = 1000, HEIGHT = 700;
	
	public static void main(String args[])
	{
		setDisplay(WIDTH, HEIGHT, "Networked Game");
		
		while (!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT);
			
			
			
			updateAndSync(60);
		}
	}
	
}
