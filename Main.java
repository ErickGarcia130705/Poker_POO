package poker;

public class Main {
    public static void main(String[] args) {
        PokerControlador controlador = new PokerControlador();

        String resultadoRonda = controlador.iniciarRonda();
        System.out.println(resultadoRonda);

        System.out.println("Hay usuarios en la mesa?: " + controlador.hayUsuariosEnMesa());
    }
}
