package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Receiver implements Runnable {

    private DatagramSocket socket;
    private ConcurrentLinkedQueue<byte[]> packets;
    public Receiver(DatagramSocket socket) {
        this.socket = socket;
        packets = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte[] receiveBuffer = new byte[100];

            DatagramPacket recvPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            try {
                socket.receive(recvPacket);
                packets.add(recvPacket.getData());
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }

    public byte[] getPacket() {
       return getPacket(true);
    }

    public byte[] getPacket(boolean remove) {
        if (packets.size() == 0) {
            return null;
        }
        return remove ? packets.poll() : packets.peek();
    }
}
