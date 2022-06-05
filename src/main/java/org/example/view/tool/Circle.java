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
public class Circle extends Tool {
	
	@Override
	public void drawGraphics(Graphics g) {
		
		Point o = getOrigin();
		Graphiclib.drawCircle(g,
				o.x + getWidth() / 2, 
				o.y + getHeight() / 2, 
				Math.min(getWidth(), getHeight()) / 4);
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
		int x = bounds.x + bounds.width / 2;
		int y = bounds.y + bounds.height / 2;
		int radix = Math.min(bounds.height, bounds.width) / 2;
		GraphiclibMat.drawCircle(icon, x, y, radix, color);
		
	}

}
