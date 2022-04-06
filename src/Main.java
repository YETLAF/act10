import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            Deck deck = new Deck();
            String[] valor = new String[]{ "2","3","4","5","6","7","8","9","10","A","J","Q","k"};
            String[] palo = new String[]{"tréboles", "corazones", "picas", "diamantes"}; //declaramos los valores para todos los atributos
            int contador = 1;
            ArrayList<Card> card = new ArrayList();
            String nombre_usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario");
            System.out.print("Estas son las opciones de cartas: ");

            for(int x = 0; x < palo.length; ++x) {
                for(int y = 0; y < valor.length; ++y) {
                    Card carta = new Card(palo[x], get_color(palo[x]), valor[y]);
                    card.add(carta);
                    System.out.print("\nNúm " + contador + "; ");
                    System.out.print("Palo: " + palo[x] + "; ");
                    System.out.print("Valor: " + valor[y] + "; ");
                    System.out.print("Color: " + get_color(palo[x]));
                    ++contador;
                }
            }

            deck.setCard(card);
            System.out.println("\nEl tamaño de la carta es:" + deck.getCard().size());
            System.out.println();
            show_menu(nombre_usuario, deck);
        } catch (Exception var10) {
            System.out.println("Finalizando programa por una excepción");
        }

    }

    public static String get_color(String palo) { //declaramos los colores
        String color;
        if (!palo.equals("picas") && !palo.equals("tréboles")) {
            color = "rojo";
        } else {
            color = "negro";
        }

        return color;
    }

    public static void show_menu(String nombre_usuario, Deck deck) throws Exception { //Excepcion agregada
        int intentos = 0;
        int permitidos = 3;
        new Scanner(System.in);

        int opcion =0;
        do {
            System.out.println("Bienvenido a poker!");
            System.out.println("Selecciona una opcion ");
            System.out.println("1. Mezclar deck");
            System.out.println("2. Sacar una carta");
            System.out.println("3. Carta al azar");
            System.out.println("4. Generar una mano de 5 cartas");
            System.out.println("0. Salir");
            System.out.println();
            opcion = Integer.parseInt(JOptionPane.showInputDialog(nombre_usuario + ", elija una opcion"));
            switch(opcion) {
                case 1:
                    deck.mix();
                    break;
                case 2:
                    deck.head();
                    break;
                case 3:
                    deck.pick();
                    break;
                case 4:
                    deck.hand();
                    break;
            }

            if (opcion < 0 || opcion > 4) {
                ++intentos;
                int rest = permitidos - intentos;
                System.out.println("Quedan " + rest + " intentos");
                System.out.println();
            }

            if (intentos == 3) {
                throw new Exception("Se han agotado las cartas");
            }
        } while(opcion != 0);

        System.out.println("Ha salido del programa ");
    }
}
