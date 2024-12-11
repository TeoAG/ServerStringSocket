import java.io.IOException; //gestisce errori di input output
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader; //per leggere i dati da un flusso di input
import java.io.InputStreamReader; //converte il flusso di byte in caratteri leggibili

public class IntServer {
    @SuppressWarnings("unused")
    public static void main(String[] args) throws Exception {
        // creare un server che riceva dal client una stringa di testo e un numero
        // random
        System.out.println("server in avvio...");
        try (ServerSocket ss = new ServerSocket(9999)) {
            System.out.println("server avviato. In attesa di connessioni sulla porta: " + ss.getLocalPort());
            CicloServer: while (true) {
                try (Socket s = ss.accept()) {
                    System.out.println("connessione accettata da: " + s.getInetAddress());
                    // Stampa nel log l'indirizzo del client che si è connesso
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    String ricevuto = in.readLine();

                    if (ricevuto!= null){
                        System.out.println("Il server riceve: "+ ricevuto);
                    }else{
                        System.out.println("connessione chiusa senza inviare dati");
                    }
                } catch (IOException e) {
                    System.err.println("Errore comunicazione Client: "+ e.getMessage());
                    
                }
            }

        } catch (Exception e) {
          
        }

    }
}
