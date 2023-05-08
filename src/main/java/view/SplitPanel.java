package view;

import javax.swing.JSplitPane;

public class SplitPanel extends JSplitPane {
	
	public SplitPanel () {
		super();
		this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.setTopComponent(new TablaAlumno());
		this.setBottomComponent(new OpcionesAlumno());
	}
	
	

}
