package poker;

public class Persona {
    private Carta[] mano;

    public Persona(Carta[] mano) {
        if (mano == null) {
            throw new IllegalArgumentException("La mano no puede ser null");
        }
        this.mano = mano.clone();
    }

    public Carta[] getMano() {
        return mano.clone(); 
    }

    public void setMano(Carta[] nuevaMano) {
        if (nuevaMano == null) {
            throw new IllegalArgumentException("La mano no puede ser null");
        }
        this.mano = nuevaMano.clone();
    }

    public int getCantidadCartas() {
        return mano.length;
    }
}
