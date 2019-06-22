package com.sph.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sph.main.Game;

public class Player extends Entity {
	
	public boolean right, left, up, down;
	public int right_dir = 0;
	public int left_dir = 1;
	public int dir = right_dir;
	public double speed = 1.5;
	
	private int frames = 0, maxFrames = 5;
	private int index = 0, maxIndex = 5;
	private boolean moved = false;
	
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	
	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		rightPlayer = new BufferedImage[6];
		leftPlayer = new BufferedImage[6];
		for(int i = 0; i < 6; i++) {
			rightPlayer[i] = Game.spritesheet.getSprite(0 + (i*50), 0, 36, 36);
		}
		for(int i = 0; i < 6; i++) {
			leftPlayer[i] = Game.spritesheet.getSprite(0 + (i*50), 37, 36, 36);
		}
	}
	
	public void tick() {
		moved = false;
		if(right) {
			moved = true;
			dir = right_dir;
			x += speed;
		}
		else if(left) {
			moved = true;
			dir = left_dir;
			x -= speed;
		}
		if(up) {
			moved = true;
			y -= speed;
		}
		else if(down) {
			moved = true;
			y += speed;
		}
		
		if(moved) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		if(dir == right_dir) {
			g.drawImage(rightPlayer[index], this.getX(), this.getY(), null);
		}else if(dir ==  left_dir) {
			g.drawImage(leftPlayer[index], this.getX(), this.getY(), null);
		}
		
	}
	
}
