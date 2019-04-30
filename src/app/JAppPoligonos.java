package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;

public class JAppPoligonos extends JFrame
{
	LienzoPoligonos poligono;

	private JPanel contentPane;
	private JTextField txtLados;
	private JTextField txtRadio;
	private JTextField txtAnguloInicial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					JAppPoligonos frame = new JAppPoligonos();
					frame.setVisible(true);
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JAppPoligonos()
	{
		setResizable(false);
		setTitle("Examen U1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		poligono = new LienzoPoligonos();
		contentPane.add(poligono);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(250, 500));
		panel.setMinimumSize(new Dimension(250, 500));
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(null);
		
		JLabel lblPoligonoRegular = new JLabel("Poligono Regular");
		lblPoligonoRegular.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPoligonoRegular.setBounds(52, 24, 164, 27);
		panel.add(lblPoligonoRegular);
		
		JLabel lblLados = new JLabel("Lados");
		lblLados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLados.setBounds(71, 98, 36, 17);
		panel.add(lblLados);
		
		JLabel lblRadio = new JLabel("Radio");
		lblRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRadio.setBounds(71, 178, 34, 17);
		panel.add(lblRadio);
		
		JLabel lblAngulo = new JLabel("Angulo\r\n Inicial");
		lblAngulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAngulo.setBounds(34, 261, 78, 17);
		panel.add(lblAngulo);
		
		txtLados = new JTextField();
		txtLados.setText("0");
		txtLados.setBounds(117, 98, 86, 20);
		panel.add(txtLados);
		txtLados.setColumns(10);
		
		txtRadio = new JTextField();
		txtRadio.setText("200");
		txtRadio.setColumns(10);
		txtRadio.setBounds(117, 178, 86, 20);
		panel.add(txtRadio);
		
		txtAnguloInicial = new JTextField();
		txtAnguloInicial.setText("0");
		txtAnguloInicial.setColumns(10);
		txtAnguloInicial.setBounds(122, 261, 86, 20);
		panel.add(txtAnguloInicial);
		
		JButton btnDibujar = new JButton("Dibujar");
		btnDibujar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					poligono.setNumLados(Integer.parseInt(txtLados.getText()));
					poligono.setRadio(Integer.parseInt(txtRadio.getText()));
					poligono.setAnguloInicial(Integer.parseInt(txtAnguloInicial.getText()));
					poligono.repaint();
				} catch (NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(contentPane, "Ingresa solo numeros, por favor :)", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDibujar.setBounds(84, 387, 89, 23);
		panel.add(btnDibujar);
		
		JSlider sldLados = new JSlider();
		sldLados.setValue(0);
		sldLados.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {				
				poligono.setNumLados(sldLados.getValue());
				txtLados.setText("" + sldLados.getValue());
				poligono.repaint();
			}
		});
		sldLados.setMaximum(20);
		sldLados.setBounds(34, 126, 200, 26);
		panel.add(sldLados);
		
		JSlider sldRadio = new JSlider();
		sldRadio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				poligono.setRadio(sldRadio.getValue());
				txtRadio.setText("" + sldRadio.getValue());
				poligono.repaint();
			}
		});
		sldRadio.setValue(0);
		sldRadio.setMaximum(250);
		sldRadio.setBounds(34, 206, 200, 26);
		panel.add(sldRadio);
		
		JSlider sldAnguloInicial = new JSlider();
		sldAnguloInicial.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				poligono.setAnguloInicial(sldAnguloInicial.getValue());
				txtAnguloInicial.setText("" + sldAnguloInicial.getValue());
				poligono.repaint();
			}
		});
		sldAnguloInicial.setValue(0);
		sldAnguloInicial.setMaximum(360);
		sldAnguloInicial.setBounds(34, 297, 200, 26);
		panel.add(sldAnguloInicial);
		
		JCheckBox chkVerRadios = new JCheckBox("Ver radios");
		chkVerRadios.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chkVerRadios.isSelected())
					poligono.verRadios = true;
				else poligono.verRadios = false;
				
				poligono.repaint();
			}
		});
		chkVerRadios.setBounds(34, 339, 109, 23);
		panel.add(chkVerRadios);
	}
}
