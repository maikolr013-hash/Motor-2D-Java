package Motor2DJava;

public class Main {
    public static void main(String[] args) {
        MotorJuego motor = new MotorJuego();
        GestorEntradas inputs = new GestorEntradas();

        System.out.println("Arrancando Motor 2D...");
        motor.cambiarEstado("JUGANDO");

        // Crear entidades
        Campeon garen = new Campeon("Garen", "Tanque", 10, 10, 32, 32, 600);
        Campeon teemo = new Campeon("Teemo", "Tirador", 50, 10, 32, 32, 400);

        motor.agregarEntidad(garen);
        motor.agregarEntidad(teemo);

        // Simular un frame
        motor.actualizar();

        // Simular input (Mover a Garen hacia Teemo para forzar colisión)
        inputs.simularDesplazamiento(garen, "DERECHA", 30);
        
        // Simular segundo frame (Aquí debería detectarse la colisión)
        motor.actualizar();

        // Simular ataque y guardar
        inputs.simularAtaque(garen, teemo, 150);
        
        String saveFile = motor.guardarPartida();
        System.out.println("\n--- ARCHIVO DE GUARDADO ---");
        System.out.println(saveFile);
        
        motor.cambiarEstado("GAME OVER");
    }
}