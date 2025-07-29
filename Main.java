package poker;

public class Main {
    public static void main(String[] args) {
        PokerControlador controlador = new PokerControlador();

        Carta c1 = new Carta("Corazón", "Rojo", 5);
        Carta c2 = new Carta("Pica", "Negro", 10);
        Carta[] cartas = {c1, c2};
        
        Usuario usuario = new Usuario(cartas, 100.0f);
        Usuario[] jugadores = {usuario};

        controlador.configurarPartida(jugadores, cartas);

        controlador.iniciarRonda();

        System.out.println("¿Hay usuarios en la mesa?: " + controlador.getMesa().cantidadUsuario());
    }
}