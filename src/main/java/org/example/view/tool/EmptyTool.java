package org.example.view.tool;
import org.example.graphiclib.Graphiclib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * @author diegogarcia
 *
 */
public class EmptyTool extends Tool {
	
	@Override
	public void drawGraphics(Graphics g) {
		
		g.setColor(Color.LIGHT_GRAY);
		Point o = getOrigin();
		Graphiclib.fillRect(g, o.x, o.y, getWidth(), getHeight());
		g.setColor(Color.BLACK);
	}

	@Override
	public void draw(
			Color[][] icon, 
			int x1, int y1, int x2, int y2,
			Color color) {
		// TODO Auto-generated method stub
		
	}

}
