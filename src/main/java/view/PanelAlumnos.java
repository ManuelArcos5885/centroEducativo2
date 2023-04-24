package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import controller.ControladorAlumno;
import controller.ControladorValoracion;
import model.Estudiante;

import java.awt.Insets;

public class PanelAlumnos extends JPanel {
	private JTextField textField_Calificacion;
	private static int idMateria;
	private static int idProfesor;
	private static int idAlumno;
	



	/**
	 * Create the panel.
	 */
	public PanelAlumnos(int idAlumno, int idMateria, int idProfesor) {
		this.idAlumno = idAlumno;
		this.idMateria = idMateria;
		this.idProfesor = idProfesor;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{39, 76, 125, 0};
		gridBagLayout.rowHeights = new int[]{20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		Estudiante estudiante = ControladorAlumno.findById(idAlumno);
		JLabel NombreAlumno = new JLabel(estudiante.getNombre() +" " + estudiante.getApellido1() + ":");
		GridBagConstraints gbc_NombreAlumno = new GridBagConstraints();
		gbc_NombreAlumno.anchor = GridBagConstraints.EAST;
		gbc_NombreAlumno.insets = new Insets(0, 0, 0, 5);
		gbc_NombreAlumno.gridx = 1;
		gbc_NombreAlumno.gridy = 0;
		add(NombreAlumno, gbc_NombreAlumno);
		
		textField_Calificacion = new JTextField();
		GridBagConstraints gbc_textField_Calificacion = new GridBagConstraints();
		gbc_textField_Calificacion.weightx = 1.0;
		gbc_textField_Calificacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Calificacion.gridx = 2;
		gbc_textField_Calificacion.gridy = 0;
		add(textField_Calificacion, gbc_textField_Calificacion);
		textField_Calificacion.setColumns(10);
		
		
		if (ControladorValoracion.findById(idAlumno, idMateria, idProfesor) != null) {
			textField_Calificacion.setText("" + ControladorValoracion.findById(idAlumno, idMateria, idProfesor).getValoracion());
		}
	}
	
	
	

}
