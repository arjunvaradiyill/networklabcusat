import java.io.*;
import java.net.*;

class TCPServermul2 {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(888);
        Socket s = ss.accept();
        System.out.println("Connection established");

        PrintStream ps = new PrintStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str, str1;
            while ((str = br.readLine()) != null) {
                if (str.equals("multiply")) {
                    // Read two numbers from the client
                    int num1 = Integer.parseInt(br.readLine());
                    int num2 = Integer.parseInt(br.readLine());

                    // Perform multiplication
                    int result = num1 * num2;

                    // Send the result back to the client
                    ps.println("Result: " + result);
                } else {
                    System.out.println(str);
                    str1 = kb.readLine();
                    ps.println(str1);
                }
            }
        }
    }
}
