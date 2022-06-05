package org.example.view;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * @author diegogarcia
 *
 */
public abstract class View {
	
	private Point origin;
	private int width;
	private int height;
	
	public View() {
		
	}
	
	public View(Point _origin, int _width, int _height) {
		
		origin = _origin;
		width = _width;
		height = _height;
	}
	
	public Point getOrigin() {
		
		return origin;
	}
	
	public int getWidth() {
		
		return width;
	}
	
	public int getHeight() {
		
		return height;
	}

	public void setOrigin(Point origin) {
		
		this.origin = origin;
	}

	public void setWidth(int width) {
		
		this.width = width;
	}

	public void setHeight(int height) {
		
		this.height = height;
	}
	
	public boolean isInBounds(Point p) {
		
		return origin.x <= p.x && origin.y <= p.y && 
				origin.x + width >= p.x && origin.y + height >= p.y;
	}
	
	public abstract void drawGraphics(Graphics g);
	
	public static RectBounds getRectBounds(
			int x1, int y1, int x2, int y2) {
		
		int xmax = Math.max(x1, x2);
		int xmin = Math.min(x1, x2);
		int ymax = Math.max(y1, y2);
		int ymin = Math.min(y1, y2);
		int width = xmax - xmin;
		int height = ymax - ymin;
		return new RectBounds(xmin, ymin, width, height);
		
	}
	
	public static class RectBounds {
		
		public int x;
		public int y;
		public int width;
		public int height;
		
		public RectBounds(int _x, int _y, int w, int h) {
			
			x = _x;
			y = _y;
			width = w;
			height = h;
		}
		
	}

}
