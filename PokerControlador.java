package poker;

public class PokerControlador {
    private Mesa mesa;
    private Dealer dealer;
    private Usuario[] jugadores;

    public PokerControlador() {
        inicializarPartida();
    }

    private void inicializarPartida() {

        Carta c1 = new Carta("Corazón", "Rojo", 5);
        Carta c2 = new Carta("Pica", "Negro", 10);
        Carta[] mazoDealer = {c1, c2};

        Usuario usuario = new Usuario(mazoDealer, 100.0f);
        jugadores = new Usuario[]{usuario};

        dealer = new Dealer(mazoDealer, "Ninguna");
        mesa = new Mesa(jugadores, mazoDealer, dealer);
    }

    public String iniciarRonda() {
        StringBuilder resultado = new StringBuilder();

        if (mesa.cantidadUsuario()) {
            resultado.append("Iniciando nueva ronda...\n");

            for (Usuario jugador : jugadores) {
                Carta[] cartasRepartidas = dealer.repartir();
                jugador.setMano(cartasRepartidas);
                resultado.append("Jugador: ").append(jugador.jugadas()).append("\n");
            }

            resultado.append(evaluarJugadas());
        } else {
            resultado.append("No hay jugadores en la mesa.\n");
        }

        return resultado.toString();
    }

    private String evaluarJugadas() {
        StringBuilder resultado = new StringBuilder();

        for (Usuario jugador : jugadores) {
            Mano mano = new Mano(jugador.getMano());
            String evaluacion = "Resultado: " +
                                "Color: " + mano.color() + ", " +
                                "Escalera: " + mano.escalera() + ", " +
                                "Par: " + mano.par();

            resultado.append("Evaluación para jugador con $")
                     .append(jugador.getDinero())
                     .append(": ")
                     .append(evaluacion)
                     .append("\n");
        }

        return resultado.toString();
    }

    public boolean hayUsuariosEnMesa() {
        return mesa.cantidadUsuario();
    }
}

