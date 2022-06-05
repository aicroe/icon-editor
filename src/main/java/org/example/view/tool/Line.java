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
public class Line extends Tool {

	@Override
	public void drawGraphics(Graphics g) {
		
		Point o = getOrigin();
		Graphiclib.drawLine(g,
				o.x + getWidth() / 5, 
				o.y + getHeight() / 5, 
				o.x + getWidth() - getWidth() / 5,
				o.y + getHeight() - getHeight() / 5);
		if (isSelected()) {
			highlightBounds(g);
		}
		
	}

	@Override
	public void draw(
			Color[][] icon,
			int x1, int y1, int x2, int y2,
			Color color) {
		
		GraphiclibMat.drawLine(icon, x1, y1, x2, y2, color);
		
	}

}
