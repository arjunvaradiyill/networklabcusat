import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String args[]) {
        DatagramSocket aSocket = null;

        if (args.length < 3) {
            System.out.println("Usage: java UDPClient <message> <server_hostname> <server_port>");
            System.exit(1);
        }

        try {
            aSocket = new DatagramSocket();
            byte[] m = args[0].getBytes();
            InetAddress aHost = InetAddress.getByName(args[1]);
            int serverPort = Integer.valueOf(args[2]).intValue();

            // Send the message to the server
            DatagramPacket request = new DatagramPacket(m, args[0].length(), aHost, serverPort);
            aSocket.send(request);

            // Receive the response from the server
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);

            // Print the received response
            System.out.println("Server Response: " + new String(reply.getData(), 0, reply.getLength()));
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null)
                aSocket.close();
        }
    }
}
