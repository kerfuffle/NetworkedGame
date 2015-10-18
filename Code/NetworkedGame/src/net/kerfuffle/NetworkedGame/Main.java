package net.kerfuffle.NetworkedGame;

import static net.kerfuffle.Utilities.Util.*;
import static org.lwjgl.opengl.GL11.*;

import net.kerfuffle.Utilities.*;

import org.lwjgl.opengl.Display;

public class Main {

	static final int WIDTH = 1000, HEIGHT = 700;
	
	public static void main(String args[])
	{
		setDisplay(WIDTH, HEIGHT, "Networked Game");
		
		Quad q = new Quad(new Coord(100, 100), new Size(50, 50), new RGB(0, 1, 1));
		
		while (!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT);
			
			q.draw();
			
			updateAndSync(60);
		}
	}
	
}
