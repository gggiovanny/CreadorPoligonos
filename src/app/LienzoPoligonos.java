package app;

import javax.swing.JPanel;
import java.awt.Graphics;

public class LienzoPoligonos extends JPanel
{
	private int radio;
	private int numLados;
	private int anguloInicial;
	public boolean verRadios;

	/**
	 * Create the panel.
	 */
	public LienzoPoligonos()
	{
		radio = 0;
		numLados = 0;
		anguloInicial = 0;
		verRadios = false;
	}
	
	public void paintComponent(Graphics gg)
	{
		super.paintComponent(gg);
		
		int ancho = getWidth();
		int alto = getHeight() - 20;
		
		int ox = getWidth() / 2;
		int oy = getHeight() /2;		
		
		if(numLados != 0 && radio != 0)
		{
		
			int deltaAngulo = 360 / numLados;	
			
			int anguloInicial2 = anguloInicial + 270; // se le suma 270 para que los 0 grados matematicos concuerden con los de la computadora
			int angulo = anguloInicial2;			
			
			// Se crean dos arreglos para guardar los valores de las vertices
			int[] x = new int[numLados];
			int[] y = new int[numLados];	
			
			for (int i = 0; i < numLados; i++)
			{
				angulo = anguloInicial2 + i*deltaAngulo;
				
				x[i] = ox + (int)(radio* Math.cos(Math.toRadians(angulo)));
				y[i] = oy + (int)(radio* Math.sin(Math.toRadians(angulo)));
				
				if(i > 0 ) // esto se hace a partir de la segunda iteracion
				{
					gg.drawLine(x[i-1], y[i-1], x[i], y[i]);			
				}
				if(verRadios)
					gg.drawLine(ox, oy, x[i], y[i]);
			}
			gg.drawLine(x[numLados-1], y[numLados-1], x[0], y[0]);
//			gg.drawOval(ox - radio, oy - radio, radio*2, radio*2);
		}
	}

	public int getRadio()
	{
		return radio;
	}

	public void setRadio(int radio)
	{
		this.radio = radio;
	}

	public int getNumLados()
	{
		return numLados;
	}

	public void setNumLados(int numLados)
	{
		this.numLados = numLados;
	}

	public int getAnguloInicial()
	{
		return anguloInicial;
	}

	public void setAnguloInicial(int anguloInicial)
	{
		this.anguloInicial = anguloInicial;
	}
	
	

}
