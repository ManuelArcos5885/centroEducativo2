package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class VentanaPrincipal extends JFrame {



	/**
	 * 
	 */
	public VentanaPrincipal() {
		super("Gestion estudiantes");
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * 
	 * @return
	 */
	private JTabbedPane getTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.add("Gestion estudiantes", new SplitPanel());

		return tabbedPane;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}

}
