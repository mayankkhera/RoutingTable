//subclass of Packet inheriting all methods and redefining two methods 
public class DataPacket extends Packet {
	
	//does the action required if the packet is found
	public boolean processFoundPacket(String portCode) {
		System.out.println("Data being routed out "+portCode+" to "+ super.getDestNetwork() +" is: "+super.getPacketData());
		return true;
	}
	
	//does the action require if the packet is not found
	public boolean processNotFoundPacket(String portCode) {
		System.out.println("Packet to "+ super.getDestNetwork() +" is being dropped");
		return true;
	}
	
}
