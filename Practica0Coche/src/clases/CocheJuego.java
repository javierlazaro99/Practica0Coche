package clases;

import java.awt.Point;

import ventanas.utils.JLabelGraficoAjustado;

public class CocheJuego extends Coche {
	
	private JLabelGraficoAjustado lCoche;
	
	public CocheJuego() {
		this.lCoche = new JLabelGraficoAjustado("src/ventanas/utils/coche.png", 100, 100);
		this.lCoche.setRotacion(Math.PI / 2);
	}
	
	public JLabelGraficoAjustado getlCoche() {
		return lCoche;
	}

	public void setlCoche(JLabelGraficoAjustado lCoche) {
		this.lCoche = lCoche;
	}

	@Override
	public void setPos(Point pos) {
		lCoche.setLocation(pos);
	}
	
	public void setRotacion(double miDireccionActual) {
		lCoche.setRotacion(miDireccionActual + Math.PI/2);
	}

}
