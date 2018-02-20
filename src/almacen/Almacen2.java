package almacen;
import java.util.Arrays;

// Tabla dos zonas: zona ocupada y zona libre Con un contador que indica cual es la última posición libre, 
//o el número de elementos almacenados. Podemos añadir siempre al final de la zona ocupada 
//o insertar en orden para mantener siempre la tabla ordenada. Cuando eliminamos un elemento desplazamos 
//para que no haya huecos.

public class Almacen2 {

	static private final int LIBRE = 0;

	private int tvalores[];
	private int valoresAlmacenados;

	// Constructores sin parámetros creo una tabla de 10 elementos
	public Almacen2() {
		this(10); // Llamo al constructor con parámetros
	}

	// Constructor donde se fija tamaño máximo del Almacén
	public Almacen2(int tamaño) {
		tvalores = new int[tamaño];
		init();
	}

	// Pone todas las posiciones a LIBRES
	public void init() {
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen2.LIBRE;
		}
		valoresAlmacenados = 0;
	}

	// Muestra una cadena con los valores de la tabla
	public String toString() {
		return "Almacen1 [tvalores=" + Arrays.toString(tvalores) + ", valoresAlmacenados=" + valoresAlmacenados + "]";
	}

	// Devuelve el números de posiciones libres
	public int numPosicionesLibres() {
		return this.tvalores.length - this.valoresAlmacenados;
	}

	// Devuelve el número de posiones ocupadas
	public int numPosicionesOcupadas() {
		return this.valoresAlmacenados;
	}

	// Devuelve verdadero o falso si está almacenado el valor en la tabla
	public boolean estaValor(int num) {
		for (int i = 0; i < this.valoresAlmacenados; i++) {
			if (this.tvalores[i] == num) {
				return true;
			}
		}
		return false;
	}

	// Almacena el valor el la tabla, devuelve false sin no puede almacenarlo
	public boolean ponValor(int num) {
		if(this.tvalores.length != this.valoresAlmacenados) {
			this.tvalores[this.valoresAlmacenados] = num;
			this.valoresAlmacenados++;
			return true;
		}
		return false;
	}

	// Elimina el elemento de la tabla, si no esta devuelve false
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

	// Indica si el almacén esta lleno
	public boolean estaLleno() {
		return this.valoresAlmacenados == this.tvalores.length;
	}
}