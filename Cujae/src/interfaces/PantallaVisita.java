package interfaces;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;

import auxiliar.Configuracion;
import auxiliar.Convert;
import auxiliar.Direccion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;

import logica.Visitante;

public class PantallaVisita extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Visitante visitante;
	private JLabel labelFoto;
	private JButton botonDirecionAdelante;
	private JButton botonDireccionIzquierda;
	private JButton botonDireccionAtras;
	private JButton botonDirecionDerecha;
	private JButton botonDireccionGirarHorario;
	private JButton botonDireccionGirarAntiHorario;
	private JButton salirBotonPantallaVisita;

	public void actualizarFoto(){
		
		ImageIcon icono;
		String foto = visitante.getFotoPOV();
		
		if(existeFoto(foto))
			icono = Convert.rezizarImagen(foto, 723, 484);
		else
			icono = Convert.resizarURL(PantallaVisita.class.getResource(foto), 723, 484);
		
		labelFoto.setIcon(icono);
	}

	private boolean existeFoto(String foto) {
		
		boolean existe = true;
		
		if(foto.charAt(0) == '/')
			existe = false;
		
		return existe;
	}

	public void moverVisita(Direccion dir){
		if(visitante.moverse(dir))
			actualizarFoto();
		else
			JOptionPane.showMessageDialog(null, "No es posible moverse a la dirección deseada");
	}

	public PantallaVisita(final JFrame ventanaAnterior, Configuracion configActual, Visitante visitanteOriginal) {

		this.visitante = visitanteOriginal;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelBotones.setBorder(null);
		panelBotones.setBounds(10, 297, 152, 176);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);

		botonDireccionGirarHorario = new JButton("");
		botonDireccionGirarHorario.setBounds(120, 0, 33, 33);
		botonDireccionGirarHorario.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/giro.png")));
		botonDireccionGirarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				visitante.rotarSentidoHorario();
				actualizarFoto();

			}
		});
		panelBotones.add(botonDireccionGirarHorario);
		

		salirBotonPantallaVisita = new JButton("Salir");
		salirBotonPantallaVisita.setBounds(31, 153, 89, 23);
		salirBotonPantallaVisita.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelBotones.add(salirBotonPantallaVisita);
		salirBotonPantallaVisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		

		botonDirecionAdelante = new JButton("");
		botonDirecionAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				moverVisita(Direccion.N);

			}
		});
		botonDirecionAdelante.setBounds(63, 11, 26, 47);
		panelBotones.add(botonDirecionAdelante);
		botonDirecionAdelante.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/arriba.png")));

		botonDireccionIzquierda = new JButton("");
		botonDireccionIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverVisita(Direccion.O);
			}
		});
		botonDireccionIzquierda.setBounds(10, 55, 53, 23);
		panelBotones.add(botonDireccionIzquierda);
		botonDireccionIzquierda.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/izquierda.png")));

		botonDirecionDerecha = new JButton("");
		botonDirecionDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverVisita(Direccion.E);
			}
		});
		botonDirecionDerecha.setBounds(89, 55, 53, 23);
		panelBotones.add(botonDirecionDerecha);
		botonDirecionDerecha.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/derecha.png")));

		botonDireccionAtras = new JButton("");
		botonDireccionAtras.setBounds(63, 77, 26, 45);
		botonDireccionAtras.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/abajo.png")));
		botonDireccionAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moverVisita(Direccion.S);
			}
		});
		panelBotones.add(botonDireccionAtras);
		

		botonDireccionGirarAntiHorario = new JButton("");
		botonDireccionGirarAntiHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				visitante.rotarSentidoAntiHorario();
				actualizarFoto();

			}
		});
		botonDireccionGirarAntiHorario.setBounds(0, 0, 33, 33);
		panelBotones.add(botonDireccionGirarAntiHorario);

		labelFoto = new JLabel("");
		labelFoto.setIcon(null);
		labelFoto.setBounds(0, 0, 723, 484);
		contentPane.add(labelFoto);
		
		actualizarFoto();

		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {

				ventanaAnterior.setEnabled(true);
				ventanaAnterior.setVisible(true);

			}

			@Override
			public void windowClosed(WindowEvent e) {
				ventanaAnterior.setEnabled(true);
				ventanaAnterior.setVisible(true);
			}

			@Override
			public void windowActivated(WindowEvent e) {

			}
		});
	}




}
