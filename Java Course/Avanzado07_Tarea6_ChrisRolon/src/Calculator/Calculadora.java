package Calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora {

	private JFrame frmCalculator;
	private JTextField txtValue01;
	private JTextField txtValue02;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setFont(new Font("Chiller", Font.PLAIN, 12));
		frmCalculator.setTitle("CALCULATOR");
		frmCalculator.setBounds(100, 100, 491, 311);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		JLabel lblScreen = new JLabel("[RESULT]");
		lblScreen.setHorizontalAlignment(SwingConstants.TRAILING);
		lblScreen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblScreen.setBounds(0, 0, 475, 33);
		frmCalculator.getContentPane().add(lblScreen);
		
		JLabel lblValue01 = new JLabel("First Value");
		lblValue01.setBounds(27, 78, 86, 23);
		frmCalculator.getContentPane().add(lblValue01);
		
		JLabel lblValue02 = new JLabel("Second Value:");
		lblValue02.setBounds(27, 116, 86, 23);
		frmCalculator.getContentPane().add(lblValue02);
		
		txtValue01 = new JTextField();
		txtValue01.setBounds(123, 78, 103, 23);
		frmCalculator.getContentPane().add(txtValue01);
		txtValue01.setColumns(10);
		
		txtValue02 = new JTextField();
		txtValue02.setColumns(10);
		txtValue02.setBounds(122, 116, 104, 23);
		frmCalculator.getContentPane().add(txtValue02);
		
		JButton btnSign = new JButton("Convert sign to view numbers");
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invertirSigno();
			}

			private void invertirSigno() {
				double nUno, nDos;
				Double result=0.0;
				if(!txtValue01.getText().isEmpty()) {
					nUno=Double.parseDouble(txtValue01.getText());
					result=0-nUno;
					txtValue01.setText(result.toString());
					lblScreen.setText(result.toString());
				}else {
					 JOptionPane.showMessageDialog(null,
				                "Enter a value to calculate",
				                "WARNING",
				                JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(!txtValue02.getText().isEmpty()) {
					nDos=Double.parseDouble(txtValue02.getText());
					result=0-nDos;
					lblScreen.setText(result.toString());
					txtValue02.setText(result.toString());
				}else {
					 JOptionPane.showMessageDialog(null,
				                "Enter a value to calculate",
				                "WARNING",
				                JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSign.setBounds(245, 78, 207, 61);
		frmCalculator.getContentPane().add(btnSign);
		
		JLabel lblOp = new JLabel("Operations:");
		lblOp.setBounds(27, 168, 99, 23);
		frmCalculator.getContentPane().add(lblOp);
		
		JComboBox cboOp = new JComboBox();
		cboOp.setModel(new DefaultComboBoxModel(new String[] {"SELECT OPERATION", "Addition", "Subtraction", "Multiplication", "Division"}));
		cboOp.setBounds(122, 168, 132, 22);
		frmCalculator.getContentPane().add(cboOp);
		
		JButton btnResult = new JButton("Calculate");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblScreen.setText(ObtnerResultado());
			}

			private String ObtnerResultado() {
				String resulT="";
				int valor=cboOp.getSelectedIndex();
				switch (valor) {
				case -1:
					resulT="Option not selected";
					break;
				case 0:
					resulT="Invalid operation";
					break;
				case 1:
					resulT=suma();
					break;
				case 2:
					resulT=resta();
					break;
				case 3:
					resulT=multiP();
					break;
				default:
					resulT=division();
					break;
				}
				
				
				return resulT;
			}

			private String division() {
				double nUno=0, nDos=0, result=0;
				String msG="";
				if(!txtValue02.getText().isEmpty()) {
					try {
						nDos=Double.parseDouble(txtValue02.getText());
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
				                "ONLY NUMBERS",
				                "WARNING",
				                JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,
			                "Enter a value to calculate",
			                "WARNING",
			                JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(!txtValue01.getText().isEmpty()) {
					try {
						nUno=Double.parseDouble(txtValue01.getText());
						
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
				                "ONLY NUMBERS",
				                "WARNING",
				                JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,
			                "Enter a value to calculate",
			                "WARNING",
			                JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				if(nDos==0) {
					msG="Cannot divide by zero";
				}else {
					result=nUno/nDos;
					msG=nUno+" divided by "+nDos+" = "+result;
				}
				return msG;
			}

			private String multiP() {
				double nUno=0, nDos=0, result=0;
				String msG="";
				if(!txtValue02.getText().isEmpty()) {
					try {
						nDos=Double.parseDouble(txtValue02.getText());
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
				                "ONLY NUMBERS",
				                "WARNING",
				                JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,
			                "Enter a value to calculate",
			                "WARNING",
			                JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(!txtValue01.getText().isEmpty()) {
					try {
						nUno=Double.parseDouble(txtValue01.getText());
						
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
				                "ONLY NUMBERS",
				                "WARNING",
				                JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,
			                "Enter a value to calculate",
			                "WARNING",
			                JOptionPane.INFORMATION_MESSAGE);
				}
				result=nUno*nDos;
				msG=nUno+" multiplied by "+nDos+" = "+result;
				return msG;
			}

			private String resta() {
				double nUno=0, nDos=0, result=0;
				String msG="";
				if(!txtValue02.getText().isEmpty()) {
					try {
						nDos=Double.parseDouble(txtValue02.getText());
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
				                "ONLY NUMBERS",
				                "WARNING",
				                JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,
			                "Enter a value to calculate",
			                "WARNING",
			                JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(!txtValue01.getText().isEmpty()) {
					try {
						nUno=Double.parseDouble(txtValue01.getText());
						
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
				                "ONLY NUMBERS",
				                "WARNING",
				                JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,
			                "Enter a value to calculate",
			                "WARNING",
			                JOptionPane.INFORMATION_MESSAGE);
				}
				result=nUno-nDos;
				msG=nUno+" minus "+nDos+" = "+result;
				return msG;
			}

			private String suma() {
				double nUno=0, nDos=0, result=0;
				String msG="";
				if(!txtValue02.getText().isEmpty()) {
					try {
						nDos=Double.parseDouble(txtValue02.getText());
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
				                "ONLY NUMBERS",
				                "WARNING",
				                JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,
			                "Enter a value to calculate",
			                "WARNING",
			                JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(!txtValue01.getText().isEmpty()) {
					try {
						nUno=Double.parseDouble(txtValue01.getText());
						
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
				                "ONLY NUMBERS",
				                "WARNING",
				                JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,
			                "Enter a value to calculate",
			                "WARNING",
			                JOptionPane.INFORMATION_MESSAGE);
				}
				result=nUno+nDos;
				msG=nUno+" plus "+nDos+" = "+result;
				return msG;
			}
		});
		btnResult.setBounds(278, 168, 174, 23);
		frmCalculator.getContentPane().add(btnResult);
		
		JButton btnClean = new JButton("Clean all fields");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cerarCampos();
				
			}

			private void cerarCampos() {
				
				txtValue01.setText(" ");
				txtValue02.setText(" ");
				lblScreen.setText("[SET NUMBERS]");
				cboOp.setSelectedIndex(0);
			}
		});
		btnClean.setBounds(27, 223, 425, 23);
		frmCalculator.getContentPane().add(btnClean);
	}
}
