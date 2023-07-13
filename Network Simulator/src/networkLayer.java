import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class networkLayer {
    public static  HashMap<Integer,StringBuilder> MacToIndex = new HashMap<>();
    public static HashMap<Integer,TreeNode> IndexToTreeNode = new HashMap<>();
    static class TreeNode{
        //Router val 1
        //Switch val 2
        //Computer val 3
        int val;
        int index;
        TreeNode left,back,right,next;
        ArrayList<StringBuilder> INTERFACE,IP,MAC,ARPTABLE,MACTABLE,ROUTINGTABLE;
        HashMap<StringBuilder,Integer> SWITCHTABLE = new HashMap<>();
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(){
        }
        public static ArrayList<StringBuilder> generateMacAddress(){
            Random random = new Random();
            ArrayList<StringBuilder> mac = new ArrayList<>();
            int n = 20;
            while(n-->0){
                StringBuilder macAddress = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    int hexValue = random.nextInt(256);
                    macAddress.append(String.format("%02X", hexValue));
                    if (i != 5) {
                        macAddress.append("-");
                    }
                }
                mac.add(macAddress);
            }
            for(int i=0;i<mac.size();i++) {
                networkLayer.MacToIndex.put(i,mac.get(i));
            }
            return mac;
        }
    }

    public static void SendMessage(){
        Scanner scanner = new Scanner(System.in);
        int sender = 0,receiver=0;
        System.out.println("Enter Sender: ");
        sender = scanner.nextInt();
        System.out.println("Enter Receiver :");
        receiver = scanner.nextInt();
        if( (sender== 1 && receiver ==2) || (sender== 2 && receiver ==1)){
            localTransfer(sender,receiver);
        } else if( receiver==3 || receiver==4 ){
            localTransfer(sender,receiver);
        }
    }

    public static void  localTransfer(int sender, int receiver){
        StringBuilder senderMAC, receiverMAC,mySwitchMAC,routerMAC;
        if(sender==1 && receiver ==2) {
            TreeNode mySwitch = IndexToTreeNode.get(4); // mySwitchMAC = mySwitch.MAC.get(1);
            TreeNode senderNode = IndexToTreeNode.get(6); senderMAC = senderNode.MAC.get(0);
            TreeNode receiverNode = IndexToTreeNode.get(7); receiverMAC = receiverNode.MAC.get(0);
            TreeNode routerNode = IndexToTreeNode.get(3); routerMAC = routerNode.MAC.get(1);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the data: ");
            String s = scanner.next();
            System.out.println("Sender " + senderMAC + " does not know the MAC Address of Receiver ");
            System.out.println("Sender " + senderMAC + " initiates an ARP request ");
            System.out.println("ARP packet has a question: Are you " + receiverNode.IP.get(0) + " ?");
            System.out.println(senderMAC + " sends ARP to Switch1");
            System.out.println("MAC Table of Switch1: ");
            System.out.println(mySwitch.SWITCHTABLE);
            System.out.println("Switch Floods the Network with ARP packets ");
            System.out.println("ARP sent to: "+receiverMAC);
            System.out.println("ARP sent to: "+routerMAC);
            System.out.println(receiverMAC+" responds with ARP packet");
            System.out.println("Creates an ARP packet: " +
                    " SOURCE: " + receiverMAC +
                    " DESTINATION: "+senderMAC +
                    " DATA: I AM THE DESTINATION"
            );
            mySwitch.SWITCHTABLE.put(senderMAC,6);
            mySwitch.SWITCHTABLE.put(receiverMAC,7);
            System.out.println("Switch Receives the ARP Packet from "+receiverMAC);
            System.out.println("Switch Table is updated "+mySwitch.SWITCHTABLE);
            System.out.println(senderMAC + " gets the receivers address");
            System.out.println(senderMAC + " makes a packet: ");
            System.out.println("Source: "+senderMAC+ " Destination: "+receiverMAC + " DATA: "+s);
            System.out.println("Packet goes to the switch");
            System.out.println("Switch Directly Sends it to the Destination");
            System.out.println(receiverMAC + "gets the message: "+s);
            System.out.println(receiverMAC +" sends ACK to "+senderMAC);

        } else if(sender == 2 && receiver == 1){
            TreeNode mySwitch = IndexToTreeNode.get(5); // mySwitchMAC = mySwitch.MAC.get(1);
            TreeNode senderNode = IndexToTreeNode.get(7); senderMAC = senderNode.MAC.get(0);
            TreeNode receiverNode = IndexToTreeNode.get(6); receiverMAC = receiverNode.MAC.get(0);
            TreeNode routerNode = IndexToTreeNode.get(3); routerMAC = routerNode.MAC.get(1);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the data: ");
            String s = scanner.next();
            System.out.println("Sender " + senderMAC + " does not know the MAC Address of Receiver ");
            System.out.println("Sender " + senderMAC + " initiates an ARP request ");
            System.out.println("ARP packet has a question: Are you " + receiverNode.IP.get(0) + " ?");
            System.out.println(senderMAC + " sends ARP to Switch1");
            System.out.println("MAC Table of Switch1: ");
            System.out.println(mySwitch.SWITCHTABLE);
            System.out.println("Switch Floods the Network with ARP packets ");
            System.out.println("ARP sent to: "+receiverMAC);
            System.out.println("ARP sent to: "+routerMAC);
            System.out.println(receiverNode.MAC.get(0)+" responds with ARP packet");
            System.out.println("Creates an ARP packet: " +
                    " SOURCE: " + receiverMAC +
                    " DESTINATION: "+senderMAC +
                    " DATA: I AM THE DESTINATION"
            );
            mySwitch.SWITCHTABLE.put(senderMAC,6);
            mySwitch.SWITCHTABLE.put(receiverMAC,7);
            System.out.println("Switch Receives the ARP Packet from "+receiverMAC);
            System.out.println("Switch Table is updated "+mySwitch.SWITCHTABLE);
            System.out.println(senderMAC + " gets the receivers address");
            System.out.println(senderMAC + " makes a packet: ");
            System.out.println("Source: "+senderMAC+ " Destination: "+receiverMAC + " DATA: "+s);
            System.out.println("Packet goes to the switch");
            System.out.println("Switch Directly Sends it to the Destination");
            System.out.println(receiverMAC + "gets the message: "+s);
            System.out.println(receiverMAC +" sends ACK to "+senderMAC);

        }

        else if( (sender==1||sender==2) && (receiver==3||receiver==4) ){
            TreeNode senderNode = IndexToTreeNode.get(sender+5); senderMAC = senderNode.MAC.get(0);
            TreeNode receiverNode = IndexToTreeNode.get(sender+5); receiverMAC = receiverNode.MAC.get(0);

            TreeNode alongSenderNode = sender==1?IndexToTreeNode.get(7):IndexToTreeNode.get(6);
            StringBuilder alongSenderMAC = alongSenderNode.MAC.get(0);
            TreeNode alongReceiverNode = receiver==3?IndexToTreeNode.get(9):IndexToTreeNode.get(8);
            StringBuilder alongReceiverMAC = alongReceiverNode.MAC.get(0);
            TreeNode mySwitch = IndexToTreeNode.get(5);
            TreeNode otherSwitch = IndexToTreeNode.get(5);
            TreeNode myRouterNode = IndexToTreeNode.get(2);
            StringBuilder myRouterMAC0 = myRouterNode.MAC.get(0);
            StringBuilder myRouterMAC1 = myRouterNode.MAC.get(1);
            TreeNode mainRouterNode = IndexToTreeNode.get(1);
            StringBuilder mainRouterMAC0 = mainRouterNode.MAC.get(0);
            StringBuilder mainRouterMAC1 = mainRouterNode.MAC.get(1);
            TreeNode otherRouterNode = IndexToTreeNode.get(3);
            StringBuilder otherRouterMAC0 = otherRouterNode.MAC.get(0);
            StringBuilder otherRouterMAC1 = otherRouterNode.MAC.get(1);





            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the data: ");
            String s = scanner.next();

            System.out.println("Sender knows that the receiver lies in another network");
            System.out.println("Sender needs the MAC address of the gateway");
            System.out.println("Sender makes an ARP request and sends it to the Switch within its network");
            System.out.println("Sender " + senderMAC + " does not know the MAC Address of gateway ");
            System.out.println("Sender " + senderMAC + " initiates an ARP request ");
            System.out.println("ARP packet has a question: Are you " + myRouterNode.IP.get(1) + " ?");
            System.out.println(senderMAC + " sends ARP to Switch1");
            System.out.println("MAC Table of Switch1: ");
            System.out.println(mySwitch.SWITCHTABLE);
            System.out.println("Switch Floods the Network with ARP packets ");
            System.out.println("ARP sent to: "+myRouterMAC1);
            System.out.println("ARP sent to: "+ alongSenderMAC);
            System.out.println(myRouterMAC1+" responds with ARP packet");
            System.out.println("Creates an ARP packet: " +
                    " SOURCE: " + myRouterMAC1 +
                    " DESTINATION: "+senderMAC +
                    " DATA: I AM THE DESTINATION"
            );
            mySwitch.SWITCHTABLE.put(senderMAC,sender+5);
            mySwitch.SWITCHTABLE.put(myRouterMAC1,2);
            System.out.println("Switch Receives the ARP Packet from "+myRouterMAC1);
            System.out.println("Switch Table is updated "+mySwitch.SWITCHTABLE);
            System.out.println(senderMAC + " gets the receivers address");
            System.out.println(senderMAC + " makes a packet: ");
            System.out.println("L3 HEADER: ");
            System.out.println("Source: "+senderNode.IP.get(0)+" Destination: "+receiverNode.IP.get(0));
            System.out.println("L2 HEADER: ");
            System.out.println("Source: "+senderMAC+" Destination: "+myRouterMAC1);
            System.out.println("The Packet arrives at the interface 1 of Router2");
            System.out.println("Router2 knows that the receiver IP lies on its interface 0, via its routing table");
            System.out.println("Router1 knows that the receiver IP lies on its interface 1, via its routing table");
            System.out.println("Router3 knows that the receiver IP lies on its interface 1, via its routing table");

            System.out.println("The packet is with Router3, now it has to send the data within its network");
            System.out.println("Router3 has to create a L2 header so that the packet can be sent to the receiver");
            System.out.println("Sender " + otherRouterMAC1 + " does not know the MAC Address of Receiver ");
            System.out.println("Sender " + otherRouterMAC1 + " initiates an ARP request ");
            System.out.println("ARP packet has a question: Are you " + receiverNode.IP.get(0) + " ?");
            System.out.println(otherRouterMAC1 + " sends ARP to Switch2");
            System.out.println("MAC Table of Switch2: ");
            System.out.println(otherSwitch.SWITCHTABLE);
            System.out.println("Switch Floods the Network with ARP packets ");
            System.out.println("ARP sent to: "+receiverMAC);
            System.out.println("ARP sent to: "+alongReceiverMAC);
            System.out.println(receiverMAC+" responds with ARP packet");
            System.out.println("Creates an ARP packet: " +
                    " SOURCE: " + receiverMAC +
                    " DESTINATION: "+otherRouterMAC1 +
                    " DATA: I AM THE DESTINATION"
            );
            otherSwitch.SWITCHTABLE.put(receiverMAC,receiver+5);
            otherSwitch.SWITCHTABLE.put(otherRouterMAC1,5);
            System.out.println("Switch Receives the ARP Packet from "+receiverMAC);
            System.out.println("Switch Table is updated "+otherSwitch.SWITCHTABLE);
            System.out.println(otherRouterMAC1 + " gets the receivers address");
            System.out.println("This address is sent back to the original sender");
            System.out.println("The sender makes a frame then: ");
            System.out.println("L2 HEADER: ");
            System.out.println("Source: "+senderMAC + " Destination: "+myRouterMAC1);
            System.out.println("L3 HEADER: ");
            System.out.println("Source: "+senderNode.IP.get(0)+" Destination: "+receiverNode.IP.get(0));
            System.out.println("DATA: "+s);
            System.out.println("Then the data is sent to the receiver");
            System.out.println("The receiver then sends an Acknowledgement to the Sender");




        }
    }

    public static void main(String[] args) {
        //MADE THE DATA STRUCTURE
        TreeNode router1 = new TreeNode(1);
        TreeNode router2 = new TreeNode(1);
        TreeNode router3 = new TreeNode(1);
        TreeNode switch1 = new TreeNode(2);
        TreeNode switch2 = new TreeNode(2);
        TreeNode dev1 = new TreeNode(3);
        TreeNode dev2 = new TreeNode(3);
        TreeNode dev3 = new TreeNode(3);
        TreeNode dev4 = new TreeNode(3);
        router1.left = router2; router1.right = router3;
        router2.left = switch1; router2.back = router1;
        router3.right = switch2; router3.back = router1;
        switch1.left = dev1; switch1.right = dev2;
        switch1.back = router2;
        switch2.left = dev3; switch2.right = dev4;
        switch2.back = router3;
        dev1.back = switch1;dev2.back = switch1;
        dev3.back = switch2;dev4.back = switch2;

        ArrayList<StringBuilder> MACs = TreeNode.generateMacAddress();

        int num = 0;
        //ALLOCATED INDEX TO ALL
        ArrayList<StringBuilder> r1 = new ArrayList<>();
        r1.add(MACs.get(num++));r1.add(MACs.get(num++));
        router1.MAC = r1; router1.index = 1;


        ArrayList<StringBuilder> r2 = new ArrayList<>();
        r2.add(MACs.get(num++));r2.add(MACs.get(num++));
        router2.MAC = r2; router2.index = 2;

        ArrayList<StringBuilder> r3 = new ArrayList<>();
        r3.add(MACs.get(num++));r3.add(MACs.get(num++));
        router3.MAC = r3; router3.index = 3;

        //ALLOCATED INDEX TO SWITCH
        switch1.index = 4;
        switch2.index = 5;
        //ALLOCATED MAC ADDRESSES
        ArrayList<StringBuilder>  r4 = new ArrayList<>();
        r4.add(MACs.get(num++));
        dev1.MAC = r4; dev1.index = 6;

        ArrayList<StringBuilder>  r5 = new ArrayList<>();
        r5.add(MACs.get(num++));
        dev2.MAC = r5; dev2.index = 7;

        ArrayList<StringBuilder>  r6 = new ArrayList<>();
        r6.add(MACs.get(num++));
        dev3.MAC = r6; dev3.index = 8;

        ArrayList<StringBuilder>  r7 = new ArrayList<>();
        r7.add(MACs.get(num++));
        dev4.MAC = r7; dev4.index = 9;
        //ALLOCATED IP ADDRESSES
        ArrayList<StringBuilder> r1IP = new ArrayList<>();
        r1IP.add(new StringBuilder("20.0.0.1/8"));
        r1IP.add(new StringBuilder("30.0.0.1/8"));
        router1.IP = r1IP;

        ArrayList<StringBuilder> r2IP = new ArrayList<>();
        r2IP.add(new StringBuilder("20.0.0.2/8"));
        r2IP.add(new StringBuilder("10.0.0.1/8"));
        router2.IP = r2IP;

        ArrayList<StringBuilder> r3IP = new ArrayList<>();
        r3IP.add(new StringBuilder("30.0.0.2/8"));
        r3IP.add(new StringBuilder("40.0.0.1/8"));
        router1.IP = r3IP;

        ArrayList<StringBuilder> dev1IP = new ArrayList<>();
        dev1IP.add(new StringBuilder("10.0.0.2/8"));
        dev1.IP = dev1IP;

        ArrayList<StringBuilder> dev2IP = new ArrayList<>();
        dev2IP.add(new StringBuilder("10.0.0.3/8"));
        dev2.IP = dev2IP;

        ArrayList<StringBuilder> dev3IP = new ArrayList<>();
        dev3IP.add(new StringBuilder("40.0.0.2/8"));
        dev3.IP = dev3IP;

        ArrayList<StringBuilder> dev4IP = new ArrayList<>();
        dev4IP.add(new StringBuilder("40.0.0.3/8"));
        dev4.IP = dev4IP;
        //GENERATE THE ROUTING TABLE FOR THE DEVICES
        ArrayList<StringBuilder> IPADDRESSES = new ArrayList<>();
        IPADDRESSES.add(new StringBuilder("10.0.0.2/8"));
        IPADDRESSES.add(new StringBuilder("10.0.0.3/8"));
        IPADDRESSES.add(new StringBuilder("40.0.0.2/8"));
        IPADDRESSES.add(new StringBuilder("40.0.0.3/8"));

        dev1.ROUTINGTABLE = new ArrayList<>(IPADDRESSES);
        dev2.ROUTINGTABLE = new ArrayList<>(IPADDRESSES);
        dev3.ROUTINGTABLE = new ArrayList<>(IPADDRESSES);
        dev4.ROUTINGTABLE = new ArrayList<>(IPADDRESSES);
        //filling IndexToTreeNode
        networkLayer.IndexToTreeNode.put(1,router1);
        networkLayer.IndexToTreeNode.put(2,router2);
        networkLayer.IndexToTreeNode.put(3,router3);
        networkLayer.IndexToTreeNode.put(4,switch1);
        networkLayer.IndexToTreeNode.put(5,switch2);
        networkLayer.IndexToTreeNode.put(6,dev1);
        networkLayer.IndexToTreeNode.put(7,dev2);
        networkLayer.IndexToTreeNode.put(8,dev3);
        networkLayer.IndexToTreeNode.put(9,dev4);


        SendMessage();
        System.out.println(router1.back);
    }

}