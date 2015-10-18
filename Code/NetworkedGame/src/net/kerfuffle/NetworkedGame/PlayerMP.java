package net.kerfuffle.NetworkedGame;

import net.kerfuffle.Utilities.Quad;

public class PlayerMP {

	Quad box;
	float speed;
	private String name;
	
	public PlayerMP(String name, Quad box)
	{
		this.name = name;
		this.box = box;
	}
	
}
