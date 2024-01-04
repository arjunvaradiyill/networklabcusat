import java.io.*;
import java.net.*;

public class TCPServerOneway {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(12345);
            System.out.println("Waiting For Client");
            Socket server = ss.accept();
            System.out.println("Server is connected");

            // Receive data from client
            BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));

            while (true) {
                String data = br.readLine();
                System.out.println("Received data from client: " + data);

                if (data.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            ss.close(); // Close the ServerSocket
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
