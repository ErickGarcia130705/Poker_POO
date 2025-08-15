package poker;
import java.util.ArrayList;
import java.util.List;

public class PokerControlador {
    private Mesa mesa;
    private Dealer dealer;
    private Usuario[] jugadores;

    private final List<Carta> cartasDinamicas = new ArrayList<>();

    private final Jugadas jugadas = new Jugadas();

    public class Jugadas 
    {
    private Carta[][] matriz = new Carta[14][2];

    public void registrar(Carta c) {
        if (c != null) {
            int fila = c.obtenerNumero(); 
            int columna = c.obtenerColor().equalsIgnoreCase("Rojo") ? 0 : 1;
            matriz[fila][columna] = c;
        }
    }

    public boolean existe(int numero, String color) {
        int columna = color.equalsIgnoreCase("Rojo") ? 0 : 1;
        return matriz[numero][columna] != null;
    }

    public Carta obtener(int numero, String color) {
        int columna = color.equalsIgnoreCase("Rojo") ? 0 : 1;
        return matriz[numero][columna];
    }

    public void limpiar() {
        matriz = new Carta[14][2];
    }
}

    public PokerControlador() {
        inicializarPartida();
    }

    private void inicializarPartida() {
    Carta c1 = new Carta("Corazón", "Rojo", 5);
    Carta c2 = new Carta("Pica", "Negro", 10);
    Carta[] cartas = { c1, c2 };

    cartasDinamicas.add(c1);
    cartasDinamicas.add(c2);
    for (Carta c : cartasDinamicas) {
        jugadas.registrar(c);
    }

    this.dealer = new Dealer(new Carta[0], "Ninguna");
    this.jugadores = new Usuario[] {
        new Usuario(cartas, 100.0f)
    };

    this.mesa = new Mesa(jugadores, cartas, dealer);
}

    public void agregarCartaDinamica(Carta c) {
        if (c != null) {
            cartasDinamicas.add(c);
            jugadas.registrar(c);
        }
    }

    public Carta removerUltimaCarta() {
        if (cartasDinamicas.isEmpty()) return null;
        return cartasDinamicas.remove(cartasDinamicas.size() - 1);
    }

    public List<Carta> getCartasDinamicas() {
        return List.copyOf(cartasDinamicas);
    }

    public boolean existeJugada(int numero, String color) {
        return jugadas.existe(numero, color);
    }

    public Carta obtenerJugada(int numero, String color) {
        return jugadas.obtener(numero, color);
    }

    public void limpiarJugadas() {
        jugadas.limpiar();
    }


    public String iniciarRonda() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ronda iniciada.\n");
        sb.append("Cartas dinámicas actuales: ").append(cartasDinamicas.size()).append("\n");
        return sb.toString();
    }

    public boolean hayUsuariosEnMesa() {
        return (mesa != null) && mesa.cantidadUsuario();
    }

    public boolean reiniciarJuego() {
        return (mesa != null) && mesa.reiniciar();
    }

    public void configurarPartida(Usuario[] jugadores, Carta[] cartas) {
        this.jugadores = jugadores;
        if (this.dealer == null) {
            this.dealer = new Dealer(new Carta[0], "Ninguna");

        }
        this.mesa = new Mesa(jugadores, cartas, dealer);
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Usuario[] getJugadores() {
        return jugadores;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void setJugadores(Usuario[] jugadores) {
        this.jugadores = jugadores;
    }
    public String mostrarCartasYJugada() {
    if (mesa == null || mesa.getCartas() == null) {
        return "No hay cartas en la mesa.\n";
    }

    StringBuilder sb = new StringBuilder("Cartas en mesa:\n");
    for (Carta c : mesa.getCartas()) {
        if (c != null) {
            sb.append(c.obtenerFigura())
              .append(" ")
              .append(c.obtenerColor())
              .append(" ")
              .append(c.obtenerNumero())
              .append("\n");
        }
    }

    Carta[] cartas = mesa.getCartas();
    if (cartas.length >= 2 && cartas[0] != null && cartas[1] != null) {
        if (cartas[0].obtenerNumero() == cartas[1].obtenerNumero()) {
            sb.append("Jugada: Par\n");
        } else {
            sb.append("Jugada: Carta alta ").append(
                Math.max(cartas[0].obtenerNumero(), cartas[1].obtenerNumero())
            ).append("\n");
        }
    }

    return sb.toString();
}
}


    public boolean reiniciarJuego() {
        return mesa.reiniciar();
    }

}
