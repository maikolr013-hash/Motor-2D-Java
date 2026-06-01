package Motor2DJava;

public abstract class EntidadVideojuego {
    protected String nombre;
    protected int x, y, w, h;
    protected int hp;

    public EntidadVideojuego(String nombre, int x, int y, int w, int h, int hp) {
        this.nombre = nombre;
        this.x = x; this.y = y; this.w = w; this.h = h;
        this.hp = hp;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getW() { return w; }
    public int getH() { return h; }
    public String getNombre() { return nombre; }
    public int getHp() { return hp; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void recibirDanio(int danio) { this.hp -= danio; }

    public abstract void actualizarEstado();
}