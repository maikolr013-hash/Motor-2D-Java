package Motor2DJava;

import java.util.ArrayList;
import java.util.List;

public class MotorJuego {
    private String estadoActual;
    private List<EntidadVideojuego> entidades;

    public MotorJuego() {
        this.estadoActual = "MENU";
        this.entidades = new ArrayList<>();
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estadoActual = nuevoEstado;
        System.out.println(">>> ESTADO DEL MOTOR CAMBIADO A: " + estadoActual + " <<<");
    }

    public void agregarEntidad(EntidadVideojuego e) {
        entidades.add(e);
        System.out.println("[MOTOR] Entidad añadida: " + e.getNombre());
    }

    public void actualizar() {
        if (!estadoActual.equals("JUGANDO")) return;
        System.out.println("\n--- INICIO FRAME ACTUALIZACION ---");
        for (EntidadVideojuego e : entidades) {
            e.actualizarEstado();
        }
        detectarColisiones();
        System.out.println("--- FIN FRAME ACTUALIZACION ---\n");
    }

    private void detectarColisiones() {
        for (int i = 0; i < entidades.size(); i++) {
            for (int j = i + 1; j < entidades.size(); j++) {
                EntidadVideojuego e1 = entidades.get(i);
                EntidadVideojuego e2 = entidades.get(j);

                boolean colisionX = e1.getX() < e2.getX() + e2.getW() && e1.getX() + e1.getW() > e2.getX();
                boolean colisionY = e1.getY() < e2.getY() + e2.getH() && e1.getY() + e1.getH() > e2.getY();

                if (colisionX && colisionY) {
                    System.out.println("[COLISIÓN] ¡" + e1.getNombre() + " ha colisionado con " + e2.getNombre() + "!");
                }
            }
        }
    }

    public String guardarPartida() {
        System.out.println("[SISTEMA] Guardando partida rápida...");
        StringBuilder json = new StringBuilder("{\n  \"estado\": \"" + estadoActual + "\",\n  \"entidades\": [\n");
        for (int i = 0; i < entidades.size(); i++) {
            EntidadVideojuego e = entidades.get(i);
            json.append("    { \"nombre\": \"").append(e.getNombre()).append("\", \"x\": ").append(e.getX())
                .append(", \"y\": ").append(e.getY()).append(", \"hp\": ").append(e.getHp()).append(" }");
            if (i < entidades.size() - 1) json.append(",");
            json.append("\n");
        }
        json.append("  ]\n}");
        return json.toString();
    }
}