package org.example.view;
import org.example.graphiclib.Graphiclib;
import org.example.view.tool.Tool;

import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * @author diegogarcia
 *
 */
public class Toolbox extends View {

	private Tool[][] tools;
	private int cols;
	private int rows;
	private int toolWidth;
	private int toolHeight;
	
	public Toolbox(int rows, int cols) {
		
		tools = new Tool[rows][cols];
		this.rows = rows;
		this.cols = cols;
	}
	
	public Tool[][] getTools() {
		
		return tools;
	}

	public int getCols() {
		
		return cols;
	}

	public int getRows() {
		
		return rows;
	}
	
	public int getToolWidth() {
		
		return toolWidth;
	}

	public int getToolHeght() {
		
		return toolHeight;
	}
	
	public void addTool(Tool tool, int row, int col) {
		
		tools[row][col] = tool;
	}
	
	public Tool getTool(Point p, Tool defaultReturn) {
		
		if (isInBounds(p)) {
			for (int i = 0; i< tools.length; i++) {
				for (int j = 0; j< tools[0].length; j++) {
					Tool tool = tools[i][j]; 
					if (tool.isInBounds(p)) {
						return tool;
					}
				}
			}
		}
		return defaultReturn;
	}
	
	public void setUp() {
		
		if (getWidth() <= 0 || getHeight() <= 0) 
			throw new UnsupportedOperationException();
		toolWidth = getWidth() / cols;
		toolHeight = getHeight() / rows;
		for (int row = 0; row < tools.length; row++) {
			Tool[] rowTools = tools[row];
			for (int col = 0; col < tools[0].length; col++) {
				Tool tool = rowTools[col];
				Point o = getOrigin();
				Point toolOrigin = new Point(
						o.x + col * toolWidth,
						o.y + row * toolHeight);
				tool.setOrigin(toolOrigin);
				tool.setWidth(toolWidth);
				tool.setHeight(toolHeight);
			}
		}
	}

	@Override
	public void drawGraphics(Graphics g) {
		
		for (Tool[] rowTools : tools) {
			for (Tool tool: rowTools) {
				tool.drawGraphics(g);
			}
		}
		Point o = getOrigin();
		for (int y = o.y; y <= o.y + getHeight(); y += toolHeight) {
			Graphiclib.drawLine(g, o.x, y, o.x + getWidth(), y);
		}
		for (int x = o.x; x <= o.x + getWidth(); x += toolWidth) {
			Graphiclib.drawLine(g, x, o.y, x, o.y + getHeight());
		}
		
	}

}
