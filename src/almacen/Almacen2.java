package almacen;
import java.util.Arrays;

/**
 * Contiene dos zonas: zona ocupada y zona libre con un contador que indica cual es 
 * la última posicion libre o el numero de elementos almacenados. Podemos añadir siempre al final de 
 * la zona ocupada o insertar en orden para mantener siempre la tabla cordinada. Cuando eliminamos
 * un elemento desplazamos para que no haya huecos
 * @author Samuel
 * @author Andres
 */

public class Almacen2 {

	static private final int LIBRE = 0;

	private int tvalores[];
	private int valoresAlmacenados;

	/**
	 * Constructor que crea una tabla de 10 elementos
	 */
	
	public Almacen2() {
		this(10); 
	}
	
	/**
	 * Constructor donde se fija tamaño máximo del Almacén
	 */
	
	public Almacen2(int tamaño) {
		tvalores = new int[tamaño];
		init();
	}
	
	/**
	 * Método que pone todas las posiciones a LIBRES
	 */
	
	public void init() {
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen2.LIBRE;
		}
		valoresAlmacenados = 0;
	}

	/**
	 * Método que genera una cadena con los valores de la tabla
	 * @return devuelve la cadena con los valores de la tabla
	 */
	
	public String toString() {
		return "Almacen1 [tvalores=" + Arrays.toString(tvalores) + ", valoresAlmacenados=" + valoresAlmacenados + "]";
	}
	
	/**
	 * Método que devuelve el número de posiciones libres
	 * @return devuelve el número de posiciones libres
	 */
	
	public int numPosicionesLibres() {
		return this.tvalores.length - this.valoresAlmacenados;
	}
	
	/**
	 * Metodo que devuelve el número de posiones ocupadas
	 * @return devuelve el número de posiciones ocupadas
	 */
	
	public int numPosicionesOcupadas() {
		return this.valoresAlmacenados;
	}
	
	/**
	 * Metodo que devuelve verdadero o falsi si está almacenado el parámetro en la tabla
	 * @param num - número a buscar en la tabla
	 * @return devuelve true o false si está almacenado
	 */
	
	public boolean estaValor(int num) {
		for (int i = 0; i < this.valoresAlmacenados; i++) {
			if (this.tvalores[i] == num) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Método que almacena el valor el la tabla, devuelve false si no puede almacenarlo
	 * @param num - número a almacenar en la tabla
	 * @return devuelve false si no puede almacenarlo
	 */

	public boolean ponValor(int num) {
		if(this.tvalores.length != this.valoresAlmacenados) {
			this.tvalores[this.valoresAlmacenados] = num;
			this.valoresAlmacenados++;
			return true;
		}
		return false;
	}

	/**
	 * Método que elimina el elemento de la tabla
	 * @param num - numero a eliminar de la tabla
	 * @return devuelve false si no está en la tabla
	 */
	 
	public boolean sacarValor(int num) {
		boolean esta = false;
		for (int j = 0; j < this.valoresAlmacenados; j++) {
			if (this.tvalores[j] == num) {
				this.valoresAlmacenados--;
				esta = true;
			}
			if (this.tvalores[j] != LIBRE && esta) {
				if ((j + 1 <= this.tvalores.length)) {
					this.tvalores[j] = this.tvalores[j + 1];
				} else {
					this.tvalores[j] = LIBRE;
				}
			}
		}
		if (esta) {
			this.tvalores[this.valoresAlmacenados] = LIBRE;	
		}
		return esta;
	}

	/**
	 * Método que indica si el almacén esta lleno
	 * @return devuelve true o false según esté lleno o no
	 */
	
	public boolean estaLleno() {
		return this.valoresAlmacenados == this.tvalores.length;
	}
}