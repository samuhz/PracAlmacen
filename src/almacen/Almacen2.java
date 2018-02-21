package almacen;
import java.util.Arrays;

/**
 * Contiene dos zonas: zona ocupada y zona libre con un contador que indica cual es 
 * la �ltima posicion libre o el numero de elementos almacenados. Podemos a�adir siempre al final de 
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
	 * Constructor donde se fija tama�o m�ximo del Almac�n
	 */
	
	public Almacen2(int tama�o) {
		tvalores = new int[tama�o];
		init();
	}
	
	/**
	 * M�todo que pone todas las posiciones a LIBRES
	 */
	
	public void init() {
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen2.LIBRE;
		}
		valoresAlmacenados = 0;
	}

	/**
	 * M�todo que genera una cadena con los valores de la tabla
	 * @return devuelve la cadena con los valores de la tabla
	 */
	
	public String toString() {
		return "Almacen1 [tvalores=" + Arrays.toString(tvalores) + ", valoresAlmacenados=" + valoresAlmacenados + "]";
	}
	
	/**
	 * M�todo que devuelve el n�mero de posiciones libres
	 * @return devuelve el n�mero de posiciones libres
	 */
	
	public int numPosicionesLibres() {
		return this.tvalores.length - this.valoresAlmacenados;
	}
	
	/**
	 * Metodo que devuelve el n�mero de posiones ocupadas
	 * @return devuelve el n�mero de posiciones ocupadas
	 */
	
	public int numPosicionesOcupadas() {
		return this.valoresAlmacenados;
	}
	
	/**
	 * Metodo que devuelve verdadero o falsi si est� almacenado el par�metro en la tabla
	 * @param num - n�mero a buscar en la tabla
	 * @return devuelve true o false si est� almacenado
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
	 * M�todo que almacena el valor el la tabla, devuelve false si no puede almacenarlo
	 * @param num - n�mero a almacenar en la tabla
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
	 * M�todo que elimina el elemento de la tabla
	 * @param num - numero a eliminar de la tabla
	 * @return devuelve false si no est� en la tabla
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
	 * M�todo que indica si el almac�n esta lleno
	 * @return devuelve true o false seg�n est� lleno o no
	 */
	
	public boolean estaLleno() {
		return this.valoresAlmacenados == this.tvalores.length;
	}
}