package org.example.view;

import org.example.graphiclib.Graphiclib;
import org.example.graphiclib.GraphiclibMat;
import org.example.view.tool.ColorTool;
import org.example.view.tool.Tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * @author diegogarcia
 *
 */

public class EditPanel extends View {

	private int escale;
	private Color[][] icon;
	private Color[][] foreground;
	private Point originPreview;
	private RectBounds lastDrag;
	private static final RectBounds EMPTY_RECT = new RectBounds(0, 0, 0, 0);
	
	public EditPanel(int _escale, int iconWidth, int iconHeight) {
		
		escale = _escale;
		icon = new Color[iconWidth][iconHeight];
		foreground = new Color[iconWidth][iconHeight];
		lastDrag = EMPTY_RECT;
		setWidth(icon[0].length * escale);
		setHeight(icon.length * escale);
	}
	
	public void setOriginPreview(Point p) {
		
		originPreview = p;
	}
	
	private void drawGraphicsPreview(Graphics g) {
		
		Point o = originPreview;
		int rows = icon.length;
		int cols = icon[0].length;
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				g.setColor(getPixel(y, x));
				Graphiclib.putPixel(g, x + o.x + 1, y + o.y + 1);
			}
		}
		g.setColor(Color.BLACK);
		int width = icon[0].length + 2;
		int height = icon.length + 2;
		Graphiclib.drawRect(g, o.x, o.y, width, height);	
		
	}
	
	public synchronized void drawForeground(Tool tool, ColorTool colorTool) {
		
		Point o = getOrigin();
		Point p = tool.getPressPoint();
		Point r = tool.getReleasePoint();
		int x1 = (int)((p.x - o.x) / (float)escale);
		int y1 = (int)((p.y - o.y) / (float)escale);
		int x2 = (int)((r.x - o.x) / (float)escale);
		int y2 = (int)((r.y - o.y) / (float)escale);
		tool.draw(foreground, x1, y1, x2, y2, colorTool.getColor());
		lastDrag = getRectBounds(x1, y1, x2, y2);
		
	}
	
	public synchronized void clearForeground() {
		
		GraphiclibMat.fillRect(foreground,
				lastDrag.x, lastDrag.y, 
				lastDrag.width, lastDrag.height, null);
		lastDrag = EMPTY_RECT;
	}
	
	public synchronized void drawIcon(Tool tool, ColorTool colorTool) {
		
		Point o = getOrigin();
		Point p = tool.getPressPoint();
		Point r = tool.getReleasePoint();
		int x1 = (int)((p.x - o.x) / (float)escale);
		int y1 = (int)((p.y - o.y) / (float)escale);
		int x2 = (int)((r.x - o.x) / (float)escale);
		int y2 = (int)((r.y - o.y) / (float)escale);
		
		tool.draw(icon, x1, y1, x2, y2, colorTool.getColor());
	}
	
	private Color getPixel(int row, int col) {
		
		Color fc = foreground[row][col];
		if (fc == null) {
			Color c = icon[row][col];
			if (c == null) return Color.WHITE;
			else return c;
		}
		return fc;
		
	}
	
	@Override
	public void drawGraphics(Graphics g) {
		
		Point o = getOrigin();
		int x;
		int y;
		int rows = icon.length;
		int cols = icon[0].length;
		y = o.y;
		for (int row = 0; row< rows; row++) {
			x = o.x;
			for (int col = 0; col< cols; col++) {
				g.setColor(getPixel(row, col));
				Graphiclib.fillRect(g, x, y, escale, escale);
				x += escale;
			}
			y += escale;
		}
		g.setColor(Color.BLACK);
		for (y = o.y; y <= o.y + getHeight(); y += escale) {
			Graphiclib.drawLine(g, o.x, y, o.x + getWidth(), y);
		}
		for (x = o.x; x <= o.x + getWidth(); x += escale) {
			Graphiclib.drawLine(g, x, o.y, x, o.y + getHeight());
		}
		drawGraphicsPreview(g);
		
	}

}
