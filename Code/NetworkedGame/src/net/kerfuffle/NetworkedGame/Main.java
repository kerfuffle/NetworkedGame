package net.kerfuffle.NetworkedGame;

import static net.kerfuffle.Utilities.Util.*;
import static org.lwjgl.opengl.GL11.*;

import net.kerfuffle.Utilities.*;

import static org.lwjgl.input.Keyboard.*;
import org.lwjgl.opengl.Display;

public class Main {

	static final int WIDTH = 1000, HEIGHT = 700;
	
	static Player p = new Player(new Quad(new Coord(100, 100), new Size(50, 50), new RGB(0, 1, 1)), "Bob");
	
	public static void main(String args[])
	{
		setDisplay(WIDTH, HEIGHT, "Networked Game");
		
		Quad rel = new Quad(new Coord(50, 50), new Size(500, 10), new RGB(0, 1, 0));
		
		p.moveToMiddle();
		p.setKeys(KEY_W, KEY_S, KEY_A, KEY_D);
		
		while (!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT);
			
			p.checkMovement();
			p.box.draw();
			
			rel.draw();
			
			updateAndSync(60);
		}
	}
	
}
