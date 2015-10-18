package net.kerfuffle.NetworkedGame;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import net.kerfuffle.Utilities.Coord;
import net.kerfuffle.Utilities.Quad;

public class Player {

	public Quad box;
	private float speed = 5;
	private int up, down, left, right;
	private boolean cameraFollow = true;
	private String name;
	
	public Player(Quad box, String name)
	{
		this.box = box;
		this.name = name;
	}
	
	public void checkMovement()
	{
		if (Keyboard.isKeyDown(up))
		{
			box.setPos(new Coord(box.getPos().getX(), box.getPos().getY() + speed));
			if(cameraFollow)
			{
				glTranslatef(0, -speed, 0);
			}
		}
		if (Keyboard.isKeyDown(down))
		{
			box.setPos(new Coord(box.getPos().getX(), box.getPos().getY() - speed));
			if(cameraFollow)
			{
				glTranslatef(0, speed, 0);
			}
		}
		if (Keyboard.isKeyDown(left))
		{
			box.setPos(new Coord(box.getPos().getX() - speed, box.getPos().getY()));
			if(cameraFollow)
			{
				glTranslatef(speed, 0, 0);
			}
		}
		if (Keyboard.isKeyDown(right))
		{
			box.setPos(new Coord(box.getPos().getX() + speed, box.getPos().getY()));
			if(cameraFollow)
			{
				glTranslatef(-speed, 0, 0);
			}
		}
	}
	
	public void setKeys(int up, int down, int left, int right)
	{
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	public void moveToMiddle()
	{
		Coord mid = new Coord(Main.WIDTH/2 - (box.getSize().getWidth()/2), Main.HEIGHT/2 - (box.getSize().getHeight()/2));
		box.setPos(mid);
	}
	public void setCameraFollow(boolean b)
	{
		cameraFollow = b;
	}
	
	
	public String toInitString()
	{
		String ret = String.format("%d,%d,%d,%d/%d/%d,%s;", box.getPos().getX(), box.getPos().getY(), speed, box.getColor().R(), box.getColor().G(), box.getColor().B(), name);
		return ret;
	}
	public String toString()
	{
		String ret = String.format("%d,%d;", box.getPos().getX(), box.getPos().getY());
		return ret;
	}
}
