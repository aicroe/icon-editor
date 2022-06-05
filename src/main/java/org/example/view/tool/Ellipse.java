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
public class Ellipse extends Tool {
	
	public void drawGraphics(Graphics g) {
		
		Point o = getOrigin();
		Graphiclib.drawEllipse(g,
				o.x + getWidth() / 2, 
				o.y + getHeight() / 2, 
				getWidth() / 3, 
				getHeight() / 5);
		if (isSelected()) {
			highlightBounds(g);
		}
		
	}

	@Override
	public void draw(
			Color[][] icon, 
			int x1, int y1, int x2, int y2,
			Color color) {

		RectBounds bounds = getRectBounds(x1, y1, x2, y2);
		int rx = bounds.width / 2;
		int ry = bounds.height / 2;
		int x = bounds.x + rx;
		int y = bounds.y + ry;
		GraphiclibMat.drawEllipse(icon, x, y, rx, ry, color);
		
	}

}
