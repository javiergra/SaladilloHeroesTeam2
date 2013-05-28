package es.iessaladillo.juegos.saladillo.model;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import es.iessaladillo.juegos.saladillo.model.components.Mapa;
import es.iessaladillo.juegos.saladillo.util.CargadorNiveles;
import es.iessaladillo.juegos.saladillo.util.Direccion;
import es.iessaladillo.juegos.saladillo.util.Entidad;

@SuppressWarnings("serial")
public class SaladilloHeroes extends JPanel {
	private static SaladilloFacade f;
	
	public SaladilloHeroes() {
		
	}
	
	static {
		f = new SaladilloFacade();
		
		ArrayList<Entidad> entidades = CargadorNiveles.cargarNivel("src/1.lvl");
		f.cargarMapa(entidades.toArray(new Entidad[entidades.size()]));
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame root = new JFrame("Saladillo Heroes");
		SaladilloHeroes game = new SaladilloHeroes();
		
		root.add(game);
		root.setVisible(true);
		root.setFocusable(true);
		root.setSize(740, 460);
		root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		root.setResizable(false);
		root.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent k) {
				Direccion d = null;
				
				switch(k.getKeyCode()) {
					case KeyEvent.VK_UP: d = Direccion.UP; break;
					case KeyEvent.VK_DOWN: d = Direccion.DOWN; break;
					case KeyEvent.VK_LEFT: d = Direccion.LEFT; break;
					case KeyEvent.VK_RIGHT: d = Direccion.RIGHT; break;
					case KeyEvent.VK_R: f.setMapa((Mapa) f.reiniciarNivel());
				}

				if(d != null) f.setMapa((Mapa) f.mover(d));
			}

			public void keyReleased(KeyEvent k) {
				// No se hace nada al soltar la tecla.

			}

			public void keyTyped(KeyEvent k) {
				// Innecesario porque se ejecuta cuando se pulsa la tecla.
			}
		});
		
		game.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
		
		while(true) {
			root.repaint();
			
			Thread.sleep(50);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		drawString(g2d, f.mapaToAscii(f.getMapa()), 48, 8);
		drawString(g2d, "Diamantes restantes: " + f.diamantesEnMapa(), 16, getHeight() - 42);
		drawString(g2d, "Muévete con las teclas de dirección", getWidth() - 400, getHeight() - 42);
	}
	
	private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
}
