package org.example.view.tool;
import org.example.graphiclib.Graphiclib;
import org.example.view.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * @author diegogarcia
 *
 */
public abstract class Tool extends View {
	
	private boolean selected;
	private Point pressPoint;
	private Point releasePoint;
	public static final Color BORDER_COLOR = Color.CYAN;

	public Tool() {
		
		selected = false;
	}
	
	public boolean isSelected() {
		
		return selected;
	}
	
	public void setSelected(boolean selected) {
		
		this.selected = selected;
	}

	public Point getPressPoint() {
		
		return pressPoint;
	}

	public void setPressPoint(Point pressPoint) {
		
		this.pressPoint = pressPoint;
	}

	public Point getReleasePoint() {
		
		return releasePoint;
	}

	public void setReleasePoint(Point releasePoint) {
		
		this.releasePoint = releasePoint;
	}
	
	protected void highlightBounds(Graphics g) {
		
		Point o = getOrigin();
		int large = 3;
		g.setColor(BORDER_COLOR);
		Graphiclib.fillRect(g, o.x, o.y, getWidth(), large);
		Graphiclib.fillRect(g, o.x, o.y, large, getHeight());
		Graphiclib.fillRect(
				g, o.x + large, o.y + getHeight() - large, 
				getWidth() - large, large);
		Graphiclib.fillRect(
				g, o.x + getWidth() - large, o.y + large, 
				large, getHeight() - large);
		g.setColor(Color.BLACK);
		
	}
	
	public abstract void draw(
			Color[][] icon, 
			int x1, int y1, int x2, int y2, 
			Color color);
	
}
