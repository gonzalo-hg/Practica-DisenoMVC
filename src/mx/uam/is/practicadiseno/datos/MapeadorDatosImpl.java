package mx.uam.is.practicadiseno.datos;

import java.util.ArrayList;
import java.util.List;

public class MapeadorDatosImpl implements MapeadorDatos {
	// La estructura que contiene los datos
	private List<String> datos = new ArrayList<String>();

	/**
	 * Constructor de la clase MapeadorDatosImpl
	 * 
	 */
	public MapeadorDatosImpl() {
		// TODO Auto-generated constructor stub
		datos.add("Entrada Mapeador 1");
		datos.add("Entrada Mapeador 2");
		datos.add("Entrada Mapeador 3");
	}

	/**
	 * Agrega datos a la lista
	 * 
	 * @param dato, es el dato a ingresar
	 * @return true si el dato no existe en la lista y se agrego false si el dato
	 *         existe y por lo tanto no se agrego
	 */
	public boolean agrega(String dato) {
		// TODO Auto-generated method stub
		if (!datos.equals("") && !datos.contains(dato)) {
			datos.add(dato);
			return true;
		}
		return false;
	}

	/**
	 * @param Dato a borrar de la ventana
	 * @return Elimina el dato de la lista
	 * @Override
	 */
	public boolean borra(String dato) {
		// TODO Auto-generated method stub
		return datos.remove(dato);
	}

	/**
	 * @return Convierte la lista a un arreglo de cadenas y lo regresa
	 * 
	 */
	@Override
	public String[] dameDatos() {
		//
		String arregloDatos[] = new String[datos.size()];
		datos.toArray(arregloDatos);
		return arregloDatos;
	}

	/**
	 * @param Dato cadena
	 * @return Devuelve true si el dato existe en la lista falso si el dato no se
	 *         encuentra en la lista
	 */
	@Override
	public boolean contiene(String dato) {
		// TODO Auto-generated method stub
		if (datos.contains(dato))
			return true;
		return false;
	}

}
