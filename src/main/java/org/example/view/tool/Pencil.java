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
public class Pencil extends Tool {

	@Override
	public void drawGraphics(Graphics g) {
		
		Point o = getOrigin();
		Graphiclib.fillRect(g,
				o.x + getWidth() / 2 - 2,
				o.y + getHeight() / 2 - 2, 4, 4);
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
