package BasDatBio2018.BDBproyect;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Panel extends JPanel {
	private JTextField textField_consulta;
	private JTextField textField_tiempo;
	private JTextComponent textArea;
	private ArrayList<String> listaConsultas;
	private JComboBox comboBox_consultas;

	/**
	 * Create the panel.
	 */
	public Panel() {
		
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		textField_consulta = new JTextField();
		textField_consulta.setBounds(226, 38, 478, 36);
		add(textField_consulta);
		textField_consulta.setColumns(10);
		
		JButton btnEjecutarConsulta = new JButton("Ejecutar consulta");
		btnEjecutarConsulta.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEjecutarConsulta.setBounds(26, 38, 155, 37);
		btnEjecutarConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				resFinal();
			}
		});
		add(btnEjecutarConsulta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(100, 155, 145, 42);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Optimizado", "No optimizado"}));
		comboBox.setMaximumRowCount(2);
		add(comboBox);
		
		JLabel lblTiempo = new JLabel("Tiempo :");
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTiempo.setBounds(12, 485, 56, 22);
		add(lblTiempo);
		
		textField_tiempo = new JTextField();
		textField_tiempo.setEditable(false);
		textField_tiempo.setBounds(83, 485, 116, 22);
		add(textField_tiempo);
		textField_tiempo.setColumns(10);
		
		JComboBox comboBox_Select_BD = new JComboBox();
		comboBox_Select_BD.setBounds(398, 155, 145, 42);
		comboBox_Select_BD.setModel(new DefaultComboBoxModel(new String[] {"MySQL", "MariaDB", "SQLServer"}));
		add(comboBox_Select_BD);
		
		JLabel lblNewLabel = new JLabel("SGBD :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(330, 168, 56, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 165, 71, 22);
		add(lblNewLabel_1);
		
		
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(12, 180, 658, 193);
		JScrollPane scroll=new JScrollPane(textArea);
		
		scroll.setBounds(0, 235, 767, 217);
		
		add(scroll);
		
		comboBox_consultas = new JComboBox();
		comboBox_consultas.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent arg0) {
				String selecto =(String)comboBox_consultas.getSelectedItem();
				textField_consulta.setText(selecto);
			}
		});
		
		comboBox_consultas.setBounds(226, 120, 478, 22);
		add(comboBox_consultas);
		
		JLabel lblNewLabel_2 = new JLabel("Historial de Consultas :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(26, 122, 155, 19);
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(670, 484, 97, 25);
		add(btnNewButton);
		
		listaConsultas = new ArrayList<String>();
		

	}

	public void resFinal(){
		String consulta = textField_consulta.getText();
		
		Conexion conex= new Conexion(consulta);
		textArea.setText("Su consulta : '"+conex.get_Request()+"' ha sido realizada");
		textField_consulta.setText("");
		textField_tiempo.setText("Mucho tiempo");
		comboBox_consultas.addItem(consulta);
	}
}
