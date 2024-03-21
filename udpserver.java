import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class udpserver {

    public static void main(String[] args) throws IOException, Exception {
        DatagramSocket s = new DatagramSocket(6788);
        byte [] buffer = new byte[1024];

        while (true) {
            DatagramPacket request = new DatagramPacket(buffer, buffer.length );
            s.receive(request);

            String[] message = (new String(request.getData())).split("");
            byte[] sendMsg = (message[1]+ "Server processed").getBytes();
            DatagramPacket reply = new DatagramPacket(sendMsg, sendMsg.length,request.getAddress() , request.getPort());
            s.send(reply);
            System.out.println("server: "+ new String(reply.getData()));
            
        }
}}