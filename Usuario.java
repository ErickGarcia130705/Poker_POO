package poker;

public class Usuario extends Persona {
    private float dinero;

    public Usuario(Carta[] mano, float dinero) {
        super(mano);
        if (dinero < 0) {
            throw new IllegalArgumentException("El dinero no puede ser negativo");
        }
        this.dinero = dinero;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("El dinero no puede ser negativo");
        }
        this.dinero = cantidad;
    }

    public void apostar(float cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La apuesta debe ser positiva");
        }
        if (cantidad > dinero) {
            throw new IllegalArgumentException("No tienes suficiente dinero");
        }
        this.dinero -= cantidad;
    }

    public void recibirPremio(float cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("El premio debe ser positivo");
        }
        this.dinero += cantidad;
    }

    public String jugadas() {
        Mano m = new Mano(getMano());
        return "Dinero: $" + dinero + 
               " | Color: " + m.color() + 
               ", Escalera: " + m.escalera() + 
               ", Par: " + m.par();
    }

    public String toString() {
        return "Usuario con $" + dinero + " y " + getCantidadCartas() + " cartas";
    }
}
