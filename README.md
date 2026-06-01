# Mini-Motor 2D: Grieta del Invocador Demake
**Autor:** Maikol Rojas

## 1. Título y Temática Elegida
El proyecto es la lógica interna de un motor 2D basado en un "demake" de League of Legends. El sistema permite gestionar campeones en un mapa cuadriculado, controlar sus estados, simular el movimiento, detectar colisiones simples entre personajes y realizar guardados rápidos del estado de la partida en formato JSON simulado.

## 2. Arquitectura del Software
Se ha optado por un diseño minimalista orientado a objetos con 5 clases, respetando el límite establecido:
* **Main**: Punto de entrada que simula la ejecución del programa y las acciones del jugador por consola.
* **MotorJuego**: Clase controladora central que gestiona el `Game Loop`, la colección de entidades, los estados de la partida y lógicas avanzadas (colisiones y guardado).
* **EntidadVideojuego**: Clase abstracta que define las propiedades físicas y de estado de cualquier objeto en pantalla (coordenadas, tamaño, puntos de vida).
* **Campeon**: Clase concreta que hereda de `EntidadVideojuego`, añadiendo roles específicos y comportamientos de actualización.
* **GestorEntradas**: Clase encargada de traducir los comandos del usuario en acciones dentro del juego (movimiento, ataques).

## 3. Diagrama de Clases UML

```mermaid
classDiagram
    class Main {
        +main(args: String[]) void
    }
    class MotorJuego {
        -estadoActual: String
        -entidades: List~EntidadVideojuego~
        +cambiarEstado(nuevoEstado: String) void
        +agregarEntidad(e: EntidadVideojuego) void
        +actualizar() void
        -detectarColisiones() void
        +guardarPartida() String
    }
    class GestorEntradas {
        +simularDesplazamiento(e: EntidadVideojuego, direccion: String, pixeles: int) void
        +simularAtaque(atacante: EntidadVideojuego, objetivo: EntidadVideojuego, danio: int) void
    }
    class EntidadVideojuego {
        <<abstract>>
        #nombre: String
        #x: int
        #y: int
        #w: int
        #h: int
        #hp: int
        +getX() int
        +getY() int
        +getW() int
        +getH() int
        +getNombre() String
        +getHp() int
        +setX(x: int) void
        +setY(y: int) void
        +recibirDanio(danio: int) void
        +actualizarEstado()* void
    }
    class Campeon {
        -rol: String
        +actualizarEstado() void
    }

    Main --> MotorJuego : inicializa
    Main --> GestorEntradas : usa
    MotorJuego o-- EntidadVideojuego : contiene


## 4. Especificación de Casos de Uso

**Caso de Uso 1: Mover Campeón**
* **Objetivo:** Desplazar a un campeón por las coordenadas del mapa.
* **Actor Principal:** Jugador
* **Flujo Principal:** 1. El jugador emite un comando de dirección. 2. `GestorEntradas` intercepta el comando. 3. Se actualizan las coordenadas (x, y). 4. `MotorJuego` verifica colisiones en la nueva posición.
* **Reglas de Negocio:** El desplazamiento se realiza aplicando saltos matemáticos sobre los ejes X e Y.

**Caso de Uso 2: Guardar Partida Rápida**
* **Objetivo:** Exportar el estado actual de las entidades y el motor.
* **Actor Principal:** Jugador
* **Flujo Principal:** 1. El jugador solicita guardar. 2. `MotorJuego` recopila el estado actual. 3. Se itera sobre la lista de entidades obteniendo coordenadas y vida. 4. Se formatea la información a JSON simulado. 5. Se imprime el resultado por consola.
    
## 5. Bitácora del Uso de Inteligencia Artificial

* **Herramienta:** Gemini (Google). Rol: Arquitecto de software y asistente en Java.
* **Control de Errores de la IA:** Durante el diseño inicial, la IA cometió un error de sobre-ingeniería intentando generar clases de más (RenderizadorVisual, GestorAudio). Tuve que corregir esto manualmente con prompts restrictivos para unificar lógicas y no superar la estricta limitación de 6 clases máximas.
* **Reflexión Crítica:** Programar asistido por IA tiene la inmensa ventaja de eliminar el tiempo perdido en el código "boilerplate" repetitivo. Sin embargo, el peligro es que los LLMs tienden a ignorar las restricciones de la tarea si no se les frena, obligando al alumno a tomar un rol de director técnico riguroso para asegurar que no se desvía de la rúbrica.
    EntidadVideojuego <|-- Campeon : hereda
    GestorEntradas ..> EntidadVideojuego : modifica
