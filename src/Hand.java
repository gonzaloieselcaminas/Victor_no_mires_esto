import java.util.Scanner;
public class Hand {

    private static Deck deck = new Deck(); //se crea un nuevo deck para sacar las cartas de ahi
    private Card [] hand = new Card[12];  //este array son las cartas en tu mano. Tamaño 12 porque en el mejor de los casos con 12 cartas ya perderías
    private int handNumber = 0; //este número es para moverse a través del array de las cartas en tu mano

    public Hand() {
       deck.shuffle(); // barajas la baraja de cartas
       getCard(); // este metodo es de esta clase, no confundir con el get card de la clase deck
       getCard();
    } // baraja todas las cartas y coloca dos en tu mano

    private void getCard() {
        hand[handNumber] = deck.getCard(); //sacas la ultima carta de la baraja y la pones en tu mano
        handNumber ++;
    }// saca una carta de la baraja y la coloca en tu mano

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < hand.length; i ++) {
            if (hand[i] != null) {
                s += hand[i] + "\n";
            } else {
                break;
            }
        }
        // No os rayeis con esto. Solo se crea un String con las cartas de tu mano. La cosa de debajo crea un String con lo que hay entre el caracter 0
        // y el ultimo caracter de s. Es para quitarle el ultimo salto de linea. Me parece más comodo de que el string que hay en la clase deck pero elegid el que querais.
        // en caso de que useis este: (nombre de string).substring(caracterInicial, caracterFinal) y te da el string que haya dentro de esos limites.
        s = s.substring(0, s.length() - 1);
        return s;
    }// devuelve un string de las cartas de tu mano

    public boolean getNewCard() { //hago que me devuelva un booleano porque asi se matan dos pajaros de un tiro (mas informacion dentro del metodo)
        System.out.println("Want new card?\nYES (Y)\nNO (N)"); // pregunta si quieres una nueva carta o no
        boolean respuestaValida = false; //booleano con la condicion para que se rompa el bucle de respuesta
        boolean answer = false; //el booleano que devuelve el metodo
        char response; //se usa para almacenar la respuesta
        while (!respuestaValida) {
            Scanner input = new Scanner(System.in); // estas dos lineas convierten a response en el primer caracter del string que metas y lo vuelven mayuscula
            response = input.next().toUpperCase().charAt(0);
            if (response != 'Y' && response != 'N') { //en caso de que respondas algo que no sea Y o N, te insulta y se reinicia el bucle
                System.out.println("Eso no es una respuesta valida, imbecil"); // por lo que puedes volver a contestar hasta que respondas o Y o N
                continue;
            }
            respuestaValida = true; //esto funciona porque no puedes alcanzar esta lines si no respondes bien, y si respondes bien, ya no se tiene que repetir el bucle
            if (response == 'Y') { //si la respuesta es Y
                getCard();
            } else { // si no
                answer = true; // este booleano se usa para acabar el juego. (mirar main) Si no quieres otra carta, se acaba el juego.
            } // no se pone a false en la otra parte del if porque ya esta inicializado a false
        }
        return answer;
    } //te pregunta si quieres o no una nueva carta

    public int blackJackNumber() {
        boolean [] ases = new boolean[4]; //este array cuenta la cantidad de ases que hay. Tamaño 4 porque solo hay 4 ases
        int asesNumbers = 0; // numero para moverse por el array de ases
        int blackJack = 0; // numero de la suma de los valores de las cartas. Se le van a ir sumando el valor de las cartas y luego se le hace un return
        for (int i = 0; i < hand.length; i ++) {
            if (hand[i] != null) { // mientras que el array no tenga ningun null
                switch (hand[i].getNumber()) {
                    case 11: case 12: case 13: blackJack += 10; // caso J, Q, K: valor = 10
                    break;
                    case 1: ases[asesNumbers] = true; // caso as: valor = 11 y añade un true al array de ases para confirmar su existencia para luego
                    asesNumbers ++;
                    blackJack += 11;
                    break;
                    default: blackJack += hand[i].getNumber(); // cualquier otro caso: valor = numero que es.
                }
            } else { //como he llenado el array de la mano en orden se que si hay un null, ya no hay mas cartas delante, por lo que acabo el bucle
                break;
            }
        }
        int numberOfAses = 0; //este numero y bucle cuentan el numero de ases que hay
        for (int i = 0; i < ases.length; i++) {
            if (ases[i]) {
                numberOfAses ++;
            } else {
                break;
            }
        }
        while (blackJack > 21) {  //este bucle existe para que en caso de que te pases de 21 los ases actuen como un 1 en vez de un 11
            if (numberOfAses == 0) { // si no hay ases en tu mano, directamnete se sale del bucle
                break;
            }
            blackJack -= 10; // si hay al menos un as, le resta 10 al numero total (que es lo mismo que poner el as a valor 1)
            numberOfAses --; // y se resta un as indicando asi que ya tiene valor 1. La condicion de arriba tambien sirve por si a pesar de haber cambiado
        } // ya el valor de todos los ases, se sigue pasando de 21, aso que se rompa tambien el bucle
        return blackJack;
    } //devuelve el valor numerico de las cartas de tu mano
}
