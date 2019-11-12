//class extends RoutingPacket inheriting all methods and redefining two methods 
public class RoutingPacket extends Packet {
	
	//Does the action required if packet is found
	public boolean processFoundPacket(String portCode) {
		System.out.println("Entry is already in table " + super.getPacketData().toString());
		return true;
	}
	
	//Does the action required if the packet wasn't found.
	public boolean processNotFoundPacket(String portCode) {
		System.out.println("Adding " + super.getDestNetwork().toString() +" "+ portCode+ " to routing table");
		System.out.println("inserting at index "+super.getDestNetwork().calcHash()+" "+super.getDestNetwork());
		return false;
	}
	
}
