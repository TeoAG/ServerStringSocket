import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.net.UnknownHostException;//gestione problematiche qual'ora il server non sia raggiungibile


public class IntClient {
    public static void main(String[] args) {
        try {
            System.out.println("tentativo di connessione al server...");
            try (Socket s = new Socket("localhost", 9999)){
                System.out.println("connessione stabilita con il server.");
                
                PrintWriter out=new PrintWriter(s.getOutputStream(), true); //creo oggetto di OutPrintWriter per mandare dati al server. l'autoflush dice che il dato debba essere mandato nell'immediato
                String messaggio= "Ciao, questo e' il tuo numero casuale: "+ Math.random();
                out.println(messaggio);
                System.out.println("il client ha inviato: " + messaggio);
            } catch (UnknownHostException e) {
                System.err.println("impossibile trovare il server: " + e.getMessage());
                
            }
        } catch (IOException e) {
            System.err.println("errore di comunicazione con il server: " + e.getMessage());
        }
    }
}
