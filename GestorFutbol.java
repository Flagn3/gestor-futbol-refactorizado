package practica_refactorizacion_casa;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorFutbol implements Comparable<GestorFutbol> {

	public static final Logger logger = Logger.getLogger(GestorFutbol.class.getName());

	// Atributos del equipo
	private String equipoNombre; // Nombre del equipo
	private int puntos; // Puntos acumulados por el equipo

	// Variable estática para contar los partidos jugados en total
	private static int partidosTotales = 0;

	public String getEquipoNombre() {
		return equipoNombre;
	}

	public void setEquipoNombre(String equipoNombre) {
		this.equipoNombre = equipoNombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public static int getPartidosTotales() {
		return partidosTotales;
	}

	public static void setPartidosTotales(int partidosTotales) {
		GestorFutbol.partidosTotales = partidosTotales;
	}

	public static void main(String[] args) {
		// Se crea una instancia del equipo principal con su nombre
		GestorFutbol equipoPrincipal = new GestorFutbol("Atlético Madrid");

		// Lista de resultados de partidos durante la temporada
		List<String> resultadosTemporada = Arrays.asList("victoria local", "empate visitante", "derrota local",
				"victoria visitante!", "empate", "victoria!", "derrota", "empate local", "victoria local");

		// Procesar los resultados y calcular puntos
		equipoPrincipal.procesarTemporada(resultadosTemporada);

		// Conversión de la lista de resultados a array (eliminado)

		// Se crea un objeto para representar el presupuesto del equipo (eliminado)

		// Verificación de si hay resultados y salida del programa si se cumple
		if (!resultadosTemporada.isEmpty()) {
			System.exit(1);
		}

		// Se crea otro equipo para comparar con el principal
		GestorFutbol otroEquipo = new GestorFutbol("Real Madrid");

		// Comparación entre dos equipos (por nombre)
		logger.log(Level.INFO, "Comparación entre equipos: {0}", equipoPrincipal.compareTo(otroEquipo));
	}

	// Constructor que inicializa el equipo con su nombre y puntos en 0
	public GestorFutbol(String nombreEquipo) {
		this.equipoNombre = nombreEquipo;
		this.puntos = 0;
	}

	// Procesa la lista de resultados y actualiza los puntos del equipo
	public void procesarTemporada(List<String> resultados) {
		for (String resultado : resultados) {

			// Se suman los puntos según el tipo de resultado
			sumarPuntos(resultado);

			// Se muestra si el partido fue como local o visitante
			checkLocalia(resultado);

			// Clasifica el resultado según su longitud
			clasificarResultado(resultado);

			// Detecta si el resultado tiene un signo de énfasis (!)
			if (resultado.endsWith("!")) {
				logger.info("¡Resultado enfatizado!");
			}

			// Separador visual entre partidos
			logger.info("----------------------");
		}
	}

	/**
	 * @param resultado
	 */
	private void sumarPuntos(String resultado) {
		if (resultado.equals("victoria")) {
			puntos += 3;
			logger.log(Level.INFO, "Victoria. Puntos acumulados: {0}", puntos);
		} else if (resultado.equals("empate")) {
			puntos += 1;
			logger.log(Level.INFO, "Empate. Puntos acumulados: {0}", puntos);
		} else if (resultado.equals("derrota")) {
			logger.log(Level.INFO, "Derrota. Puntos acumulados: {0}", puntos);
		}
	}

	/**
	 * @param resultado
	 */
	private void checkLocalia(String resultado) {
		if (resultado.contains("local")) {
			logger.info("Jugado como local.");
			if (resultado.length() > 10) {
				logger.log(Level.INFO, "Detalle adicional: {0}", resultado);
			}
		} else if (resultado.contains("visitante")) {
			logger.info("Jugado como visitante.");
			if (resultado.length() > 8) {
				logger.log(Level.INFO, "Comentario: {0}", resultado);
			}
		}
	}

	/**
	 * @param resultado
	 */
	private void clasificarResultado(String resultado) {
		switch (resultado.length()) {
		case 7:
			logger.info("Resultado corto.");
			break;
		case 14:
			logger.info("Resultado medio.");
			break;
		default:
			logger.info("Resultado de longitud estándar.");
			break;
		}
	}

	// Método para comparar si dos objetos GestorFutbol representan el mismo equipo
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof GestorFutbol))
			return false;
		GestorFutbol otro = (GestorFutbol) obj;
		return this.equipoNombre.equals(otro.equipoNombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipoNombre);
	}

	// Crea una copia del objeto actual
	public GestorFutbol copy(GestorFutbol gf) {
		return gf;
	}

	// Compara dos objetos GestorFutbol por su nombre de equipo
	@Override
	public int compareTo(GestorFutbol otro) {
		if (this.equipoNombre == null || otro.equipoNombre == null) {
			return -1;
		}
		return this.equipoNombre.compareTo(otro.equipoNombre);
	}
}
