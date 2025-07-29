package poker;

public class Dealer {
    private Carta[] mano;
    private String jerarquia;

    public Dealer(Carta[] mano, String jerarquia) {
        this.mano = mano;
        this.jerarquia = jerarquia;
    }

    public String puntuar(String jugadas) {
        return "Jerarquía " + jerarquia + " con jugadas: " + jugadas;
    }

    public Carta[] repartir() {
        return mano;
    }
}
