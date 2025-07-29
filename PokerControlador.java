package poker;

public class PokerControlador {
    private Mesa mesa;
    private Dealer dealer;
    private Usuario[] jugadores;

    public PokerControlador() {
        Carta[] cartasIniciales = new Carta[0];
        this.dealer = new Dealer(cartasIniciales, "Ninguna");
        this.jugadores = new Usuario[0];
        this.mesa = new Mesa(jugadores, cartasIniciales, dealer);
    }

    public void configurarPartida(Usuario[] jugadores, Carta[] mazoDealer) {
        this.jugadores = jugadores;
        this.dealer = new Dealer(mazoDealer, "Ninguna");
        this.mesa = new Mesa(jugadores, mazoDealer, dealer);
    }

    public void iniciarRonda() {
        if (mesa.cantidadUsuario()) {
            System.out.println("Iniciando nueva ronda...");
            
            for (Usuario jugador : jugadores) {
                Carta[] cartasRepartidas = dealer.repartir();
                jugador.setMano(cartasRepartidas); 
                System.out.println("Jugador: " + jugador.jugadas());
            }
            evaluarJugadas();
        } else {
            System.out.println("No hay jugadores en la mesa.");
        }
    }

    private void evaluarJugadas() {
        for (Usuario jugador : jugadores) {
            Mano mano = new Mano(jugador.getMano());
            String resultado = "Resultado: " + 
                               "Color: " + mano.color() + ", " +
                               "Escalera: " + mano.escalera() + ", " +
                               "Par: " + mano.par();
            
            System.out.println("Evaluación para jugador con $" + jugador.getDinero() + ": " + resultado);
        }
    }

    public void cambiarDealer(Dealer nuevoDealer) {
        this.dealer = mesa.cambioDealer(nuevoDealer);
        System.out.println("Nuevo dealer asignado.");
    }

    public void reiniciarJuego() {
        if (mesa.reiniciar()) {
            this.jugadores = new Usuario[0];
            System.out.println("Juego reiniciado con éxito.");
        }
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
}
