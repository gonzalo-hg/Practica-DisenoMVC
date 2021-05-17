package mx.uam.is.practicadiseno.vista;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

import mx.uam.is.practicadiseno.negocio.ManejadorProxy;
import mx.uam.is.practicadiseno.negocio.Observador;

public class Ventana extends JFrame implements Observador {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JScrollPane jScrollPane = null;

	@SuppressWarnings("rawtypes")
	private JList jList = null;

	private JTextField jTextField = null;

	private JButton jButtonAgregar = null;

	private JButton jButtonBorrar = null;

	// Referencia al programa
	private ManejadorProxy manejador;

	private Ventana ventana;

	/**
	 * This is the default constructor
	 * @param pasamos la referencia el ManejadorProxy
	 */
	public Ventana(ManejadorProxy manejadorProxy) {
		super();
		initialize(ventana);
		// Guarda la referencia al programa
		this.manejador = manejadorProxy;
		// Metodo para cerrar la ventana
		// this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		actualiza();
		// Agregamos el observador
		manejador.agregaObservador(this);
	}

	@SuppressWarnings("unchecked")
	public void actualiza() {
		getJList().setListData(manejador.dameDatos());
		// manejador.dameDatos();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize(Ventana ventana) {
		this.setSize(406, 319);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				// Codigo llamado cuando se cierra la ventana
				manejador.quitaObservador(ventana);

			}

		});
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);// Cierrra las ventanas
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJButtonAgregar(), null);
			jContentPane.add(getJButtonBorrar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(15, 16, 361, 178));
			jScrollPane.setViewportView(getJList());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jList
	 *
	 * @return javax.swing.JList
	 */
	@SuppressWarnings("rawtypes")
	private JList getJList() {
		if (jList == null) {
			jList = new JList();
		}
		return jList;
	}

	/**
	 * This method initializes jTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(16, 202, 272, 28));
			jTextField.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// Este codigo se invoca cuando se presiona agregar
					@SuppressWarnings("unused")
					boolean retorno = manejador.agrega(getJTextField().getText());
					// Actualiza la lista

					actualiza();

					// Borra el contenido del campo de texto
					getJTextField().setText("");
					// Pone texto de estatus

				}
			});
		}
		return jTextField;
	}

	/**
	 * This method initializes jButtonAgregar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAgregar() {
		if (jButtonAgregar == null) {
			jButtonAgregar = new JButton();
			jButtonAgregar.setBounds(new Rectangle(292, 202, 83, 27));
			jButtonAgregar.setText("Agregar");
			jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// Este codigo se invoca cuando se presiona agregar
					manejador.agrega(getJTextField().getText());
					manejador.notifica();
					actualiza();
					getJTextField().setText("");
				}
			});
		}
		return jButtonAgregar;
	}

	/**
	 * This method initializes jButtonBorrar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonBorrar() {
		if (jButtonBorrar == null) {
			jButtonBorrar = new JButton();
			jButtonBorrar.setBounds(new Rectangle(183, 243, 193, 28));
			jButtonBorrar.setText("BorrarSeleccionado");
			jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// Este codigo se invoca cuando se presiona borrar
					if (getJList().getSelectedValue() != null) {
						String seleccionado = getJList().getSelectedValue().toString();
						manejador.borra(seleccionado);
						manejador.notifica();
						actualiza();

					}
				}
			});
		}
		return jButtonBorrar;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
