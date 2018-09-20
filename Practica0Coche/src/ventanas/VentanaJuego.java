package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.CocheJuego;
import ventanas.utils.JLabelGraficoAjustado;

public class VentanaJuego extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel pPrincipal;
	private JPanel pBotonera;
	private CocheJuego cJ = new CocheJuego();
	private boolean juegoSigue = true;
	private int ancho;
	private int alto;

	public VentanaJuego() {
		
		this.setTitle("Juego choche");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(900, 700);
		
		pPrincipal = new JPanel();
		pBotonera = new JPanel();
		pPrincipal.setLayout(null);
		pBotonera.setLayout(new FlowLayout());
		
		JButton bAcelera = new JButton("Acelera");
		JButton bFrena = new JButton("Frena");
		JButton bDerecha = new JButton("Gira Derecha");
		JButton bIzquierda = new JButton("Gira Izquierda");
		
		bAcelera.setFocusable(false);
		bFrena.setFocusable(false);
		bDerecha.setFocusable(false);
		bIzquierda.setFocusable(false);
		
		ancho = this.getWidth();
		alto = this.getHeight();

		
		pBotonera.add(bAcelera);
		pBotonera.add(bFrena);
		pBotonera.add(bDerecha);
		pBotonera.add(bIzquierda);
		
		pPrincipal.add(cJ.getlCoche());
		
		this.getContentPane().add(pPrincipal, BorderLayout.CENTER);
		this.getContentPane().add(pBotonera, BorderLayout.SOUTH);
		
		bAcelera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cJ.acelera(5);
				System.out.println(cJ.getMiVelocidad());
			}
		});
		
		bFrena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cJ.acelera(-5);
				System.out.println(cJ.getMiVelocidad());
			}
		});
		
		bIzquierda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cJ.gira(-10);
				System.out.println(cJ.getMiDireccionActual());
			}
		});
		
		bDerecha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cJ.gira(10);
				System.out.println(cJ.getMiDireccionActual());
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W) {
					cJ.acelera(5);
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					cJ.acelera(-5);
				}
				if(e.getKeyCode() == KeyEvent.VK_A) {
					cJ.gira(-10);
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					cJ.gira(10);
				}
				
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
	
			@Override
			public void windowClosing(WindowEvent e) {
				juegoSigue = false;
			}
		});
		
		//Hilo del movimiento del coche
		Thread hilo = new Thread() {		
			@Override
			public void run() {
				while(juegoSigue) {
					try {
						Thread.sleep(40);
						cJ.mueve(0.75);
						cJ.setPos(cJ.getPos());
						cJ.setRotacion(cJ.getMiDireccionActual());
						if(cJ.getPos().x < -10 || cJ.getPos().x > ancho -100 || cJ.getPos().y < -10 
								|| cJ.getPos().y > alto -150){
							cJ.setMiDireccionActual(cJ.getMiDireccionActual() + Math.PI);
							cJ.setRotacion(cJ.getMiDireccionActual());
						}
						
						pPrincipal.revalidate();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
			}
		};
		hilo.start();
		
		
	}
	
	public static void main(String[] args) {
		VentanaJuego vj = new VentanaJuego();
		vj.setVisible(true);
		vj.cJ.setPiloto("Javi");
	}
}
