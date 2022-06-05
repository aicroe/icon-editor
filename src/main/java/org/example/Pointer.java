package org.example;

import org.example.view.EditPanel;
import org.example.view.Toolbox;
import org.example.view.tool.*;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author diegogarcia
 *
 */
public class Pointer extends MouseAdapter {
	
	private Tool currentTool;
	private ColorTool currentColor;
	private Toolbox toolbox;
	private Toolbox colorBox;
	private EditPanel editPanel;
	private Editor owner;
	
	private static final EmptyTool EMPTY_TOOL = new EmptyTool();
	static {
		EMPTY_TOOL.setOrigin(new Point(0, 0));
		EMPTY_TOOL.setWidth(10000);
		EMPTY_TOOL.setHeight(10000);
	}
	
	public Pointer() {
		
		currentTool = EMPTY_TOOL;
		currentColor = new ColorTool(Color.BLACK);
		
	}
	
	public void setOwner(Editor owner) {

		this.owner = owner;
		toolbox = (Toolbox) owner.getView(Editor.TOOLBOX);
		colorBox = (Toolbox) owner.getView(Editor.COLORS_BOX);
		editPanel = (EditPanel) owner.getView(Editor.EDIT_PANEL);
		
	}
	
	public void setCurrentTool(Tool t) {
		
		currentTool = t;
	}
	
	public void setCurrentColor(ColorTool t) {
		
		currentColor = t;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		Point p = e.getPoint();
		if (editPanel.isInBounds(p) && currentTool.getPressPoint() != null){
			currentTool.setReleasePoint(p);
			
			if (currentTool instanceof Pencil |
					currentTool instanceof Eraser) {
				editPanel.drawIcon(currentTool, currentColor);
				currentTool.setPressPoint(p);
				
			} else {
				editPanel.clearForeground();
				editPanel.drawForeground(currentTool, currentColor);
				
			}
			owner.repaint();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Point p = e.getPoint();
		if (toolbox.isInBounds(p)) {
			currentTool.setSelected(false);
			currentTool = toolbox.getTool(p, currentTool);
			currentTool.setSelected(true);
			
		} else if (colorBox.isInBounds(p)) {
			currentColor.setSelected(false);
			currentColor = (ColorTool)colorBox.getTool(p, currentColor);
			currentColor.setSelected(true);
			
		} else if (editPanel.isInBounds(p)) {
			return;
			
		} else {
			currentTool.setSelected(false);
			currentTool = EMPTY_TOOL;
		}
		owner.repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		Point p = e.getPoint();
		if (editPanel.isInBounds(p)){
			currentTool.setPressPoint(p);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		editPanel.clearForeground();
		if (editPanel.isInBounds(e.getPoint())) {
			if (currentTool.getPressPoint() != null) {
				currentTool.setReleasePoint(e.getPoint());
				editPanel.drawIcon(currentTool, currentColor);
				currentTool.setPressPoint(null);
				currentTool.setReleasePoint(null);
			}
		}
		owner.repaint();
		
	}
	
}
