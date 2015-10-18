package net.kerfuffle.Server;

import net.kerfuffle.Utilities.Coord;
import net.kerfuffle.Utilities.RGB;
import net.kerfuffle.Utilities.Size;

public class PlayerData {

	private Coord pos;
	private Size size;
	private float speed;
	private RGB color;
	private String name;
	
	public PlayerData(Coord pos, float speed, RGB color, String name)
	{
		this.pos = pos;
		this.speed = speed;
		this.color = color;
		this.name = name;
	}
	
	public void setPos(Coord pos)
	{
		this.pos = pos;
	}
	
	public String toInitString()
	{
		String ret = String.format("%d,%d,%d,%d/%d/&d,%s;", pos.getX(), pos.getY(), speed, color.R(), color.G(), color.B(), name);
		return ret;
	}
	public String toString()
	{
		String ret = String.format("%d,%d;", pos.getX(), pos.getY());
		return ret;
	}
	
}
