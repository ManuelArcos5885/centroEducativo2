package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorAlumno;
import controller.ControladorMateria;
import controller.ControladorProfesor;
import model.Estudiante;
import model.Materia;
import model.Profesor;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private static JComboBox comboBox_Profesor;
	private static JComboBox comboBox_Materia;
	private static JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{45, 374, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{22, 14, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Materia");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBox_Materia = new JComboBox();
		GridBagConstraints gbc_comboBox_Materia = new GridBagConstraints();
		gbc_comboBox_Materia.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Materia.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Materia.gridx = 1;
		gbc_comboBox_Materia.gridy = 0;
		contentPane.add(comboBox_Materia, gbc_comboBox_Materia);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		comboBox_Profesor = new JComboBox();
		GridBagConstraints gbc_comboBox_Profesor = new GridBagConstraints();
		gbc_comboBox_Profesor.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Profesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Profesor.gridx = 1;
		gbc_comboBox_Profesor.gridy = 1;
		contentPane.add(comboBox_Profesor, gbc_comboBox_Profesor);
		
		JButton btnNewButton = new JButton("Botom refrescar alumnado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAlumnos();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.gridwidth = 6;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{374, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{14, 0, 14, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_2 = new JLabel("a continuacion deben aparecer todos los estudiantes con un elemento");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 4;
		gbc_lblNewLabel_2.weightx = 1.0;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("para que puedas introducir su nota, para el profesor y la materia determinada");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.weightx = 1.0;
		gbc_lblNewLabel_3.gridwidth = 4;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 5;
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		
		JButton btnNewButton_1 = new JButton("Guardar las notas de todos los alumnos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 7;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		cargarMateria();
		cargarProfesor();
		
	}
	
	private static void cargarProfesor() {
		List<Profesor> ps = ControladorProfesor.findAllProvincias();
		
		for (Profesor profesor : ps) {
			comboBox_Profesor.addItem(profesor);
		}
	}
	
	private static void cargarMateria() {
		List<Materia> ps = ControladorMateria.findAllProvincias();
		
		for (Materia profesor : ps) {
			comboBox_Materia.addItem(profesor);
		}
	}
	
	private static void cargarAlumnos() {
		panel_1.removeAll();
		
		List<Estudiante> es = ControladorAlumno.findAllProvincias();
		Materia m = (Materia) comboBox_Materia.getSelectedItem();
		Profesor pr = (Profesor) comboBox_Profesor.getSelectedItem();
		
		
		for (Estudiante e : es) {
			PanelAlumnos p = new PanelAlumnos(e.getId(),m.getId(),pr.getId());
			
			panel_1.add(p);
			panel_1.repaint();
			panel_1.updateUI();
			
		}
		
		
		
		
	}

}
