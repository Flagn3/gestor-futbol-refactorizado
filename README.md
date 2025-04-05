## 1. Blocker issues (1)
##### issue java:S2975
Quitamos la implementación de la interfaz Clonable, y sustituimos el método `public Object clone()` por un método public `GestorFutbol copy(GestorFutbol gf)` al que le pasamos como parámetro un objeto de la clase GestorFutbol para realizar una copia del mismo.

---

## 2. High issues (1)
##### issue java:s3776

Refactorizamos el método `procesarTemporada()` para reducir su complejidad cognitiva de 18 hasta al menos 15. Para ello, refactorizamos su código en 3 métodos: `sumarPuntos()`, `checkLocalia()` y `clasificarResultado()`.

---

## 3. Medium issues (19)
##### issue java:S1068 (2)
Eliminamos los String NOMBRE_REAL_MADRID y NOMBRE_ATLETICO_MADRID, los cuales no se utilizan en ningún momento. Esto también resolverá 2 issues leves java:S3008, referentes a hacer coincidir el nombre de las variables con la expresión regular `'^[a-z][a-zA-Z0-9]*$'`.

##### issue java:S1854 (2)
Eliminamos las variables resultadosArray y presupuestoEstimado, las cuales no son utilizadas en ningún momento. Esto también resulverá otra issue media java:S2111, que pedía utilizar BigDecimal.valueOf en la declaración de la variable presupuestoEstimado, y 2 leves java:S1481 referentes a eliminar estas variables que no se utilizan.
Eliminamos también la linea `import java.math.BigDecimal` para que no aparezca una nueva issue leve.

##### issue java:S2589 (1)
Eliminamos la expresión `resultadosTemporada!=null` del if que comprueba si la lista de resultados está vacía.

##### issue java:S106 (13)
Reemplazamos todos los usos de System.out que existen por logger.

---

## 4. Low issues (5)
En un primer lugar eran 10, pero al resolver issues mayores, también se fueron resolviendo algunas de esta categoría.
##### issue java:S1104 (3)
Hacemos privados los atributos de la clase *equipoNombre*, *puntos* y *partidosTotales*, y generamos getters y setters para acceder a cada uno de ellos.

##### issue java:S1206 (1)
Generamos el `método hashCode()` para resolver esta issue.

##### issue java:S2167 (1)
En el return del if del método `compareTo()`, simplemente devolvemos -1 en lugar de `Integer.MIN_VALUE;`.
