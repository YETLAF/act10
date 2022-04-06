import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
        private List<Card> card;
        private int nocards = 52;

        public int getNum_cartas() {return nocards;}
        public void setNum_cartas(int nocards) {this.nocards = nocards;}
        public List<Card> getCard() {return card;}
        public void setCard(List<Card> card) {this.card = card;}

        public String mix() throws Exception //shuffle
        {
            try
            {
                Collections.shuffle(card);
            }
            catch(Exception e)
            {
                throw new Exception("Se detiene el programa debido a una excepcion");
            }
            return "Las cartas fueron mezcladas";
        }

        public void head() throws Exception
        {
            try
            {
                System.out.println("La carta tiene las siguientes caracteristicas");
                System.out.print("Palo: " + card.get(0).getPalo() + "; ");
                System.out.print("Valor: " + card.get(0).getValor() + "; ");
                System.out.print("Color: " + card.get(0).getColor());

                card.remove(0);
                nocards -= 1;
                System.out.println("\nSe ha eliminado la carta, quedan: " + nocards);
            }

            catch(Exception e)
            {
                throw new Exception("Se detiene el programa debido a una excepcion");
            }
        }

        public void pick() throws Exception
        {
            int numero;
            Random no = new Random();
            try
            {
                numero = no.nextInt((nocards));

                System.out.println("La carta " + (numero + 1) + " del deck es: ");
                System.out.print("Palo: " + card.get(numero).getPalo() + "; ");
                System.out.print("Valor: " + card.get(numero).getValor() + "; ");
                System.out.print("Color: " + card.get(numero).getColor());

                card.remove(numero);
                nocards -= 1;
                System.out.println("\nSe elimino la carta " + (numero + 1) + ", quedan: " + nocards);
            }

            catch(Exception e)
            {
                throw new Exception("Se detiene el programa debido a una excepcion");
            }
        }

        public void hand() throws Exception
        {
            String[] palo = new String[5];
            String[] valor = new String[5];
            String[] color = new String[5];

            int numero;
            try
            {
                Random num_rand = new Random();

                for(int x = 0; x < 5; x++)
                {
                    numero = num_rand.nextInt((nocards));

                    palo[x] = card.get(numero).getPalo();
                    valor[x] = card.get(numero).getValor();
                    color[x] = card.get(numero).getColor();

                    System.out.print("Palo: " + palo[x] + "; ");
                    System.out.print("Valor: " + valor[x] + "; ");
                    System.out.print("Color: " + color[x] + "\n");

                    card.remove(numero);
                    nocards -= 1;
                    System.out.println("Se elimino la carta" + (numero + 1) + ", quedan: " + nocards);
                    System.out.println();
                }
            }

            catch(Exception e)
            {
                throw new Exception("Se detiene el programa debido a una excepcion");
            }
        }
    }
