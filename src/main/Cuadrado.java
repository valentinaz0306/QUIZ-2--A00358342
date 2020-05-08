package main;

import processing.core.PApplet;

public class Cuadrado implements Runnable{
	
	private int posX;
	private int posY;
	private int velX;
	private int velY;
	private boolean mov;
	private PApplet app;
	boolean color;
	private char c;
	public int dir;
	
	public Cuadrado(int x, int y, boolean c, PApplet pApp, char cc) {
		
		setPosX(x);
		setPosY(y);
		color = c;
		setApp(pApp);
		dir = 1;
		mov = true;
		c=c;
		
	}
	
	public void dibujar() {
		//app.square(posX, posY);
	}
	
	public void moverse() {
	
	
		if(dir == 1) {
			posY+=20;
			dir=0;
		}else {
			posY-=20;
			dir=1;
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		
		try {
			while(mov) {
				Thread.sleep(1000);
				moverse();
			}
			
			

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}
	
	public boolean getColor(){
		return color;
	}
	
	public void stop() {
		mov = false;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
	

}
