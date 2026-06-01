package Motor2DJava;

public class Campeon extends EntidadVideojuego {
    private String rol;

    public Campeon(String nombre, String rol, int x, int y, int w, int h, int hp) {
        super(nombre, x, y, w, h, hp);
        this.rol = rol;
    }

    @Override
    public void actualizarEstado() {
        System.out.println("[ENTIDAD] " + nombre + " (" + rol + ") en posicion (" + x + "," + y + ") - HP: " + hp);
    }
}