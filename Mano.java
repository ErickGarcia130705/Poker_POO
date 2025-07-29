package poker;

public class Mano {
     private Carta[] cartas;

    public Mano(Carta[] cartas) {
        this.cartas = cartas;
    }

    public String color() {
        if (cartas.length > 0) {
            return cartas[0].obtenerColor();
        }
        return "";
    }

    public String escalera() {
        if (cartas.length >= 2) {
            int diff = cartas[1].obtenerNumero() - cartas[0].obtenerNumero();
            return (diff == 1 || diff == -1) ? "Sí hay escalera" : "No hay escalera";
        }
        return "No hay suficientes cartas";
    }

    public String par() {
        if (cartas.length >= 2 && cartas[0].obtenerNumero() == cartas[1].obtenerNumero()) {
            return "Hay un par";
        }
        return "No hay par";
    }
}
