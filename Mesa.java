package poker;

public class Mesa {
    private Usuario[] jugadores;
    private Carta[] cartas;
    private Dealer dealer;

    public Mesa(Usuario[] jugadores, Carta[] cartas, Dealer dealer) {
        this.jugadores = jugadores;
        this.cartas = cartas;
        this.dealer = dealer;
    }

    public boolean reiniciar() {
        if (jugadores != null && jugadores.length > 0) {
            for (Usuario jugador : jugadores) {
                jugador.setMano(new Carta[0]);
            }
            return true;
        }
        return false;
    }

    public boolean cantidadUsuario() {
        return jugadores.length > 0;
    }

    public Dealer cambioDealer(Dealer d) {
        this.dealer = d;
        return this.dealer;
    }

    public Carta[] getCartas() {
        return cartas;
    }

}
