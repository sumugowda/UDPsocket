import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpclient {
    public static void main(String[] args) throws Exception{
        DatagramSocket s = new DatagramSocket();
        String msg = "Text Message" ;
        InetAddress host = InetAddress.getByName("localhost");
        byte[] b = msg.getBytes();
        DatagramPacket request = new DatagramPacket(b, b.length,host,6788);
        s.send(request);
        byte[] buffer = new byte[1000];
        
        // Continuously receive messages from the server
        while (true) {
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            s.receive(reply);
            System.out.println("Client received: " + new String(reply.getData()));
        }
    }
}
