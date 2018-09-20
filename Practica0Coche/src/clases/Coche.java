package clases;

import java.awt.Point;

public class Coche {

	//Sigo el esquema de ayuda de la práctica 0 en ALUD
	private double miVelocidad;
	protected double miDireccionActual;
	protected Point pos;
	private String piloto;
	
	public Coche() {
		this.miVelocidad = 0;
		this.miDireccionActual = 0;
		this.pos = new Point(0, 0);
		this.piloto = "";
	}
	
	public double getMiVelocidad() {
		return miVelocidad;
	}

	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}

	public double getMiDireccionActual() {
		return miDireccionActual;
	}

	public void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	@Override
	public String toString() {
		return "Coche [miVelocidad=" + miVelocidad + ", miDireccionActual=" + miDireccionActual + ", pos=" + pos
				+ ", piloto=" + piloto + "]";
	}

	public void acelera( double aceleracion ) {  
		this.miVelocidad += aceleracion;
	} 
	
	public void gira( double giro ) {  
		this.miDireccionActual += giro * Math.PI / 180;
	} 
	
	public void mueve( double tiempoDeMovimiento ) {  
		pos.x += miVelocidad * tiempoDeMovimiento * Math.cos(miDireccionActual);
		pos.y += miVelocidad * tiempoDeMovimiento * Math.sin(miDireccionActual);
	} 
	
}
