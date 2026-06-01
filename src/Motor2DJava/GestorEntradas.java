package Motor2DJava;

public class GestorEntradas {
    public void simularDesplazamiento(EntidadVideojuego entidad, String direccion, int pixeles) {
        System.out.println("[INPUT] Moviendo " + entidad.getNombre() + " hacia " + direccion);
        switch (direccion.toUpperCase()) {
            case "ARRIBA": entidad.setY(entidad.getY() - pixeles); break;
            case "ABAJO": entidad.setY(entidad.getY() + pixeles); break;
            case "IZQUIERDA": entidad.setX(entidad.getX() - pixeles); break;
            case "DERECHA": entidad.setX(entidad.getX() + pixeles); break;
        }
    }

    public void simularAtaque(EntidadVideojuego atacante, EntidadVideojuego objetivo, int danio) {
        System.out.println("[INPUT] " + atacante.getNombre() + " ataca a " + objetivo.getNombre());
        objetivo.recibirDanio(danio);
    }
}