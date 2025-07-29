package poker;

public class Carta {
    private String figuras;
    private String color;
    private int numero;

    public Carta(String figura, String color, int numero) {
        this.figuras = figura;
        this.color = color;
        this.numero = numero;
    }

    public String obtenerFigura() {
        return figuras;
    }

    public String obtenerColor() {
        return color;
    }

    public int obtenerNumero() {
        return numero;
    }
}
