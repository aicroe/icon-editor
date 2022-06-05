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
public class Triangle extends Tool {
	
	@Override
	public void drawGraphics(Graphics g) {
		
		Point o = getOrigin();
		Graphiclib.drawTriangle(g,
				o.x + getWidth() / 5 , 
				o.y + getHeight() - getHeight() / 5, 
				o.x + getWidth() / 2, 
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
		
		RectBounds bounds = getRectBounds(x1, y1, x2, y2);
		int _x1 = bounds.x;
		int _y1 = bounds.y + bounds.height;
		int _x2 = bounds.x + bounds.width;
		int _y2 = bounds.y + bounds.height;
		int _x3 = bounds.x + bounds.width / 2;
		int _y3 = bounds.y;
		GraphiclibMat.drawTriangle(icon,
				_x1, _y1, 
				_x2, _y2, 
				_x3, _y3, 
				color);
		
	}

}
