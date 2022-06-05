package org.example.view.tool;
import org.example.graphiclib.Graphiclib;
import org.example.graphiclib.GraphiclibMat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * @author diegogarcia
 *
 */
public class Eraser extends Tool {

	@Override
	public void drawGraphics(Graphics g) {
		
		Point o = getOrigin();
		g.setColor(Color.WHITE);
		Graphiclib.fillRect(g,
				o.x + getWidth() / 3, 
				o.y + getHeight() / 5, 
				getWidth() - 2 * getWidth() / 3, 
				getHeight() - 2 * getHeight() / 5);
		g.setColor(Color.BLACK);
		Graphiclib.drawRect(g,
				o.x + getWidth() / 3, 
				o.y + getHeight() / 5, 
				getWidth() - 2 * getWidth() / 3, 
				getHeight() - 2 * getHeight() / 5);
		if (isSelected()) {
			highlightBounds(g);
		}
		
		
	}

	@Override
	public void draw(
			Color[][] icon, 
			int x1, int y1, int x2, int y2,
			Color _ignored) {
		
		GraphiclibMat.drawLine(icon, x1, y1, x2, y2, Color.WHITE);
		
	}

}
