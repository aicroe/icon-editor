package org.example.view.tool;
import org.example.graphiclib.GraphiclibMat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * @author diegogarcia
 *
 */
public class Rect extends Tool {
	
	public void drawGraphics(Graphics g) {
		
		Point o = getOrigin();
		g.drawRect(
				o.x + getWidth() / 8, 
				o.y + getHeight() / 4, 
				getWidth() - getWidth() / 4, 
				getHeight() - getHeight() / 2);
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
		GraphiclibMat.drawRect(icon, bounds.x, bounds.y,
				bounds.width, bounds.height, color);
		
	}

}
