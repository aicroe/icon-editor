package org.example.view.tool;

import org.example.graphiclib.Graphiclib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class ColorTool extends Tool {
	
	private Color color;
	
	public ColorTool(Color _color) {
		
		color = _color;
	}
	
	public Color getColor() {
		
		return color;
	}

	@Override
	public void drawGraphics(Graphics g) {

		g.setColor(color);
		Point o = getOrigin();
		Graphiclib.fillRect(g, o.x, o.y, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		if (isSelected()) {
			highlightBounds(g);
		}
		
		
	}

	@Override
	public void draw(
			Color[][] icon, 
			int x1, int y1, int x2, int y2,
			Color color) {
		
		throw new UnsupportedOperationException();
		
	}

}
