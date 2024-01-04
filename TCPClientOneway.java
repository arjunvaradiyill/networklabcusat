import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClientOneway {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 12345);
            System.out.println("Connected to server");

            // Send data from client to server
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Enter data to send to server (type 'exit' to close):");
                String data = sc.nextLine();
                pw.println(data);
                pw.flush();

                if (data.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            client.close(); // Close the client socket
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
