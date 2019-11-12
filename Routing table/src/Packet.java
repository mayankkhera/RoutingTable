import java.util.Scanner;

//this class manages packet's data like destination source and portcode or packet String depending on the kind of object created out of this class
public class Packet {
	
	//private instances
	private IPAddress source;
	private IPAddress destination;
	private String pack;
	
	//default constructor initializing the instances of class
	public Packet() {
		source = new IPAddress();
		destination = new IPAddress();
		pack = "";
	}
	
	//reads the packet information using scanner passed as a parameter
	public boolean readPacket(Scanner keyboard) {
		boolean temp = destination.readAddress(keyboard) & source.readAddress(keyboard);
		pack = keyboard.next();
		return temp;
	}
	
	//returns destination IPAddress
	public IPAddress getDestNetwork() {
		return destination;
	}
	
	//Does the action if the process is found
	public boolean processFoundPacket(String portCode) {
		return true;
	}
	
	//does the action if the process is not found
	public boolean processNotFoundPacket(String IP) {
		return true;
	}
	
	//returns packetData when invoked
	public String getPacketData() {
		return pack;
	}
	
}
