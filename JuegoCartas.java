package poker;

public class JuegoCartas {
    private final Carta[][] matriz; 

    public JuegoCartas() {
        this.matriz = new Carta[14][2];
    }

    private int idxNumero(int n) {
        if (n < 1) n = 1;
        if (n > 13) n = 13;
        return n;
    }

    private int idxColor(String color) {
        return "Rojo".equalsIgnoreCase(color) ? 0 : 1;
    }

    
    public void registrar(Carta c) {
        if (c == null) return;
        matriz[idxNumero(c.obtenerNumero())][idxColor(c.obtenerColor())] = c;
    }

    public boolean existe(int numero, String color) {
        return matriz[idxNumero(numero)][idxColor(color)] != null;
    }

    public Carta obtener(int numero, String color) {
        return matriz[idxNumero(numero)][idxColor(color)];
    }

    public void limpiar() {
        for (int i = 1; i <= 13; i++) {
            matriz[i][0] = null;
            matriz[i][1] = null;
        }
    }

    public Carta[][] getMatriz() {
        return matriz;
    }

public class Jugadas {
    private final Carta[][] matriz; 

    public Jugadas() {
        this.matriz = new Carta[14][2];
    }

    private int idxNumero(int n) {
        if (n < 1) n = 1;
        if (n > 13) n = 13;
        return n;
    }

    private int idxColor(String color) {
        return "Rojo".equalsIgnoreCase(color) ? 0 : 1;
    }

    public void registrar(Carta c) {
        if (c == null) return;
        matriz[idxNumero(c.obtenerNumero())][idxColor(c.obtenerColor())] = c;
    }

    public boolean existe(int numero, String color) {
        return matriz[idxNumero(numero)][idxColor(color)] != null;
    }

    public Carta obtener(int numero, String color) {
        return matriz[idxNumero(numero)][idxColor(color)];
    }

    public void limpiar() {
        for (int i = 1; i <= 13; i++) {
            matriz[i][0] = null;
            matriz[i][1] = null;
        }
    }

    public Carta[][] getMatriz() {
        return matriz;
    }
}

}
