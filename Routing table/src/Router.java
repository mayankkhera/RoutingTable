import java.util.ArrayList;

public class Router{

	private ArrayList<EntryList> routingTable;
	
	//default constructor
	public Router(){
		routingTable = new ArrayList<EntryList>(100);
		for(int i=0; i<100; i++) {
			EntryList temp = new EntryList(i);
			routingTable.add(temp);
		}
	}
	
	//processes the packet by looking up in the table 
	public void processPacket(Packet pk){
		RoutingTableEntry temp = new RoutingTableEntry();
		temp.addEntry(pk.getDestNetwork(), pk.getPacketData());
		if(routingTable.get(findIndex(pk)).contains(pk))
			pk.processFoundPacket(pk.getPacketData());
		else if(!pk.processNotFoundPacket(pk.getPacketData()))
			routingTable.get(findIndex(pk)).add(temp);
	}

		/*if(!pk.processNotFoundPacket(pk.getPacketData())){
			RoutingTableEntry temp = new RoutingTableEntry();
			temp.addEntry(pk.getDestNetwork(), pk.getPacketData());
			routingTable.add(findIndex(pk.getDestNetwork()),temp);
		}*/
	

	//displays the sorted table when called
	public void displayTable(){

		System.out.println();
		System.out.println("Routing table is as follow: ");
		System.out.println();

		for(int i=0; i<routingTable.size(); i++){
			System.out.println(routingTable.get(i));
		}
	}

	//returns hash code for the packet	
	private int findIndex(Packet pk) {
		return pk.getDestNetwork().calcHash();		
	}
	
	/*public int collisionResolution(Packet pk) {
		int index = findIndex(pk);
		while(index<100) {
			if(routingTable.get(index)!=null)
				return index;
			index++;
		}
		return -1;
	}*/
	

}