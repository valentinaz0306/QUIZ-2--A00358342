package main;

import javax.swing.JOptionPane;

import excepciones.HiloExcpetion;
import processing.core.PApplet;

public class Main extends PApplet {

	Cuadrado[][] matrizCuadrados;
	private boolean fT = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");
	}

	public void settings() {
		size(600, 400);
	}

	public void setup() {
		int cX = 0;
		int cY = 0;
		matrizCuadrados = new Cuadrado[30][20];

		for (int i = 0; i < 30; i++) {
			cY++;
			for (int j = 0; j < 20; j++) {
				cX += 5;
				if (j % 2 == 0) {
					if (i % 2 == 0) {
						matrizCuadrados[i][j] = new Cuadrado(i * 20, j * 20, true, this, 'T');
					} else {
						matrizCuadrados[i][j] = new Cuadrado(i * 20, j * 20, false, this, 'F');
					}
				} else {
					if (i % 2 == 0) {
						matrizCuadrados[i][j] = new Cuadrado(i * 20, j * 20, false, this, 'F');
					} else {
						matrizCuadrados[i][j] = new Cuadrado(i * 20, j * 20, true, this, 'T');
					}
				}
			}
		}

	}

	public void draw() {
		background(255);

		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 20; j++) {
				Cuadrado c = matrizCuadrados[i][j];
				if (c.getColor()) {
				
					fill(0);
					
					rect(c.getPosX(), c.getPosY(), 20, 20);
				} else {
					fill(255);
					if(c.getC()=='R') {
						fill(230,0,38);
					}
					rect(c.getPosX(), c.getPosY(), 20, 20);
				}

			}
		}
	}

	public void mousePressed() {
		int y = mouseY;
		int x = mouseX;

		if (fT) {
			for (int i = 0; i < 30; i++) {
				for (int j = 0; j < 20; j++) {
					Cuadrado c = matrizCuadrados[i][j];
					if (i % 2 == 0) {

						Thread t = new Thread(c);
						t.start();

					}
				

				}
			}
		}
		
		fT=false;
		
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 20; j++) {
				Cuadrado c = matrizCuadrados[i][j];
				if(!c.getColor()) {
					
					if (x < c.getPosX() + 10 && x > c.getPosX() - 10 && y < c.getPosY() + 10 && y > c.getPosY() - 10) {
						c.stop();
						if(c.getC()=='R') {
							try {
								throw new HiloExcpetion();
							} catch (HiloExcpetion e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							
								System.out.println(e.getMessage());
							}
							
						}
						c.setC('R');
						
					}
				}
				
			}
		}
	}

}
