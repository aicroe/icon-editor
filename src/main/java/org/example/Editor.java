package org.example;

import org.example.view.EditPanel;
import org.example.view.Toolbox;
import org.example.view.View;
import org.example.view.tool.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JFrame;

/**
 * 
 * @author diegogarcia
 *
 */
@SuppressWarnings("serial")
public class Editor extends JFrame {
	
	public static final int NUM_VIEWS = 3;
	public static final int TOOLBOX = 0;
	public static final int COLORS_BOX = 1;
	public static final int EDIT_PANEL = 2;
	
	private View[] views;
	private Pointer pointer;
	private Image offscreen;
	private Graphics offgraphics;
	
	public Editor(int width, int height) {
		
		views = new View[NUM_VIEWS];
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public View getView(int i) {
		
		return views[i];
	}
	
	public void setController(Pointer p) {
		
		pointer = p;
		addMouseListener(pointer);
		addMouseMotionListener(pointer);
	}
	
	public void init() {
		
		Pencil pencil = new Pencil();
		ColorTool blackTool = new ColorTool(new Color(51, 51, 51));
		pencil.setSelected(true);
		blackTool.setSelected(true);
		
		Toolbox toolbox = new Toolbox(4, 2);
		toolbox.setOrigin(new Point(30, 60));
		toolbox.addTool(pencil, 0, 0);
		toolbox.addTool(new Line(), 0, 1);
		toolbox.addTool(new Circle(), 1, 0);
		toolbox.addTool(new Ellipse(), 1, 1);
		toolbox.addTool(new Rect(), 2, 0);
		toolbox.addTool(new Triangle(), 2, 1);
		toolbox.addTool(new Eraser(), 3, 0);
		toolbox.addTool(new EmptyTool(), 3, 1);
		toolbox.setWidth(80);
		toolbox.setHeight(160);
		toolbox.setUp();
		
		EditPanel editPanel = new EditPanel(10, 64, 64);
		editPanel.setOrigin(new Point(150, 60));
		editPanel.setOriginPreview(new Point(30, 450));
		
		Toolbox colorsBox = new Toolbox(8, 2);
		colorsBox.setOrigin(new Point(40, 255));
		colorsBox.addTool(blackTool, 0, 0);
		colorsBox.addTool(new ColorTool(Color.GRAY), 0, 1);
		colorsBox.addTool(new ColorTool(Color.RED), 1, 0);
		colorsBox.addTool(new ColorTool(Color.ORANGE), 1, 1);
		colorsBox.addTool(new ColorTool(Color.YELLOW), 2, 0);
		colorsBox.addTool(new ColorTool(Color.GREEN), 2, 1);
		colorsBox.addTool(new ColorTool(Color.BLUE), 3, 0);
		colorsBox.addTool(new ColorTool(Color.PINK), 3, 1);
		colorsBox.addTool(new ColorTool(Color.WHITE), 4, 0);
		colorsBox.addTool(new ColorTool(Color.LIGHT_GRAY), 4, 1);
		colorsBox.addTool(new ColorTool(Color.MAGENTA), 5, 0);
		colorsBox.addTool(new ColorTool(new Color(127, 255, 212)), 5, 1);
		colorsBox.addTool(new ColorTool(new Color(150, 75, 0)), 6, 0);
		colorsBox.addTool(new ColorTool(new Color(102, 0, 153)), 6, 1);
		colorsBox.addTool(new ColorTool(new Color(0, 168, 107)), 7, 0);
		colorsBox.addTool(new ColorTool(new Color(255, 112, 40)), 7, 1);
		colorsBox.setHeight(160);
		colorsBox.setWidth(40);
		colorsBox.setUp();
		
		views[TOOLBOX] = toolbox;
		views[COLORS_BOX] = colorsBox;
		views[EDIT_PANEL] = editPanel;
		
		pointer.setCurrentColor(blackTool);
		pointer.setCurrentTool(pencil);
		pointer.setOwner(this);
	}
	
	@Override
	public void paint(Graphics g) {

		if (offgraphics == null) {
			offscreen = createImage(getWidth(), getHeight());
			offgraphics = offscreen.getGraphics();
		}
		offgraphics.clearRect(0, 0, getWidth(), getHeight());
		for (View view : views) {
			view.drawGraphics(offgraphics);
		}
		g.drawImage(offscreen, 0, 0, null);
	}

}
