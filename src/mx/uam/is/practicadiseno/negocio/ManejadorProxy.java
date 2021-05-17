package mx.uam.is.practicadiseno.negocio;

public class ManejadorProxy implements Manejador{
	
	private Manejador manejador;
/**
 * @param Manejador
 * 
 * */
	
	public ManejadorProxy(Manejador manejador) {
		System.out.println("Se invocó el Constructor ManejadorProxy(Manejador manejador)");
		this.manejador = manejador;
	}
	/**
	 * Metodo para ver los datos del arregloo
	 * @param void
	 * @return regresa la referencia al manejador.dameDatos()
	 * */
	@Override
	public String[] dameDatos() {
		// TODO Auto-generated method stub
		System.out.println("Se invocó el método dameDatos()");
		return manejador.dameDatos();
	}
	/**
	 * Metodo para ver si un dato puede ser agregado a la lista
	 * @param String dato 
	 * @return regresa la referencia manejador.agrega(dato)
	 * */
	@Override
	public boolean agrega(String dato) {
		// TODO Auto-generated method stub
		System.out.println("Se invocó el método agrega(String dato)");
		return manejador.agrega(dato);
	}

	/**
	 * Metodo para borrar un dato de la lista
	 * @param String dato
	 * @return la referencia al manejador.borra(dato)
	 * */
	@Override
	public boolean borra(String dato) {
		// TODO Auto-generated method stub
		System.out.println("Se invocó el método borra(String dato)");
		return manejador.borra(dato);
	}

	/**
	 * Metodo para terminar el programa
	 * @param
	 * @return 
	 * */
	@Override
	public void finaliza() {
		// TODO Auto-generated method stub
		manejador.finaliza();
	}

	/**
	 * Metodo para agregar un observador 
	 * @param Observador 
	 * @return regresa la referncia a manejador.agregaObservador(o)
	 * */
	@Override
	public boolean agregaObservador(Observador o) {
		// TODO Auto-generated method stub
		System.out.println("Se invocó el método agregaObservador(Observador o)");
		return manejador.agregaObservador(o);
	}
	/**
	 * Metodo para eliminar un observador 
	 * @param Observador
	 * @return regresa la referencia a manejador.quitaObservador(o)
	 * */
	@Override
	public boolean quitaObservador(Observador o) {
		// TODO Auto-generated method stub
		System.out.println("Se invocó el método quitaObservador(Observador o)");
		return manejador.quitaObservador(o);
	}
	/**
	 * Metodo para monitorear los cambios en los observadores
	 * @param
	 * @return 
	 * */
	@Override
	public void notifica() {
		// TODO Auto-generated method stub
		System.out.println("Se invocó el método notifica()");
		manejador.notifica();
	}

}
