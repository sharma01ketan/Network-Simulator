import java.util.ArrayList;
import java.util.Scanner;

public class testCase2 {
    static int mac = 0;
    public static class Hub{
        int identityNumber = 1000;
        ArrayList<Device> connectedDevices = new ArrayList<>();

        public static Hub addNode(Hub hub){
            Device newDevice = new Device();
            hub.connectedDevices.add(newDevice);
            return hub;
        }
    }
    public static class Device{
        int identityNumber;
        public Device() {
            this.identityNumber = mac++;
        }
    }

    public static class Switch{
        int identityNumber = 1000;
        ArrayList<Device> connectedDevices = new ArrayList<>();

        public static Switch addNode(Switch sw){
            Device newDevice = new Device();
            sw.connectedDevices.add(newDevice);
            return sw;
        }
    }

    public static void function(int numberOfDevices) throws InterruptedException {
        int senderId=0, recieverId=1;
        Scanner scn1 = new Scanner(System.in);
        System.out.print("Enter MAC Of Sender : ");
        System.out.println();
        senderId = scn1.nextInt();

        Scanner scn2 = new Scanner(System.in);
        System.out.print("Enter MAC Of Receiver : ");
        System.out.println();
        recieverId = scn2.nextInt();
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        if(senderId> numberOfDevices || recieverId > numberOfDevices){
            System.out.println("ERROR: NOT ENOUGH DEVICES!");
        }
        System.out.println("Enter text (type 'exit' to quit):");
        String input = scanner.nextLine();
        if (input.equals("exit")) {
        }
        System.out.println("Device "+senderId+" sends to buffer:");
        sb.append(input);
        System.out.println("Data goes form Buffer to Hub ");
//        System.out.println("Sending Data To Hub: ");
        StringBuilder binaryString = conversion.asciiToBinary(sb);
        dataTransfer.delayedPrint(binaryString);
        System.out.println("Hub Broadcasts within its domain ");
        for(int i=0;i<numberOfDevices;i++){
            if(i==recieverId){
                System.out.println("Data Received By : "+recieverId+" ");
                dataTransfer.delayedPrint(conversion.asciiToBinary(sb));
            }else{
                System.out.println("Data Rejected By: "+i);
            }
        }
    }
    public static void function1(int num1, int num2) throws InterruptedException {
        int senderId=0, recieverId=1;
        Scanner scn1 = new Scanner(System.in);
        System.out.print("Enter MAC Of Sender : ");
        System.out.println();
        senderId = scn1.nextInt();

        Scanner scn2 = new Scanner(System.in);
        System.out.print("Enter MAC Of Receiver : ");
        System.out.println();
        recieverId = scn2.nextInt();
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
//        if(senderId> numberOfDevices || recieverId > numberOfDevices){
//            System.out.println("ERROR: NOT ENOUGH DEVICES!");
//        }
        System.out.println("Enter text (type 'exit' to quit):");
        String input = scanner.nextLine();
        if (input.equals("exit")) {
        }
        System.out.println("Device "+senderId+" sends to buffer:");
        sb.append(input);
        System.out.println("Data goes form Buffer to Hub ");
//        System.out.println("Sending Data To Hub: ");
        StringBuilder binaryString = conversion.asciiToBinary(sb);
        dataTransfer.delayedPrint(binaryString);
        System.out.println("Hub Broadcasts within its domain ");
        System.out.println("Data is received by the Switch");
        System.out.println("The Second Hub broadcasts the data ");
        for(int i=num1+1;i<=num1+num2;i++ ){
//            System.out.println(i);
            if(i==recieverId){
                System.out.println("Data is received by "+recieverId);
            }else{
                System.out.println("Data is rejected by "+ i);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Switch switch1 = new Switch();
        System.out.println("Region One ");
        int numberOfDevices1=0;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Number Of Devices: ");
        System.out.println();
        numberOfDevices1 = scn.nextInt();
        for(int i = 0;i<numberOfDevices1;i++){
            switch1 = Switch.addNode(switch1);
        }
        Switch switch2 = new Switch();
        System.out.println("Region Two ");
        int numberOfDevices2=0;
        Scanner scn1 = new Scanner(System.in);
        System.out.print("Enter Number Of Devices: ");
        System.out.println();
        numberOfDevices2 = scn1.nextInt();
        for(int i = 0;i<numberOfDevices2;i++){
            switch2 = Switch.addNode(switch2);
        }
        System.out.println("Press 1 for Local");
        System.out.println("Press 2 for Hop to Hop");
        Scanner scn3 = new Scanner(System.in);
        int temp = scn3.nextInt();
        if(temp==1){
            System.out.println("Press 1 for first");
            System.out.println("Press 2 for second");
            Scanner scn4 = new Scanner(System.in);
            int temp4 = scn4.nextInt();
            if(temp4==1){
                function(numberOfDevices1);
            } else{
                function(numberOfDevices2);
            }
        } else{
            Scanner scn5 = new Scanner(System.in);
            int temp5 = 0;
            while(temp5>=0){
                System.out.println("Press -1 to Quit");
                System.out.println("Press 1 to Proceed");
                temp5 = scn5.nextInt();
                System.out.println("Collision Domains: "+ numberOfDevices1+numberOfDevices2);
                System.out.println("Broadcast Domains: 4");
                function1(numberOfDevices1,numberOfDevices2);
            }
        }
    }
}
//
//    int senderId=0, recieverId=1;
//    Scanner scn1 = new Scanner(System.in);
//        System.out.print("Enter MAC Of Sender : ");
//                System.out.println();
//                senderId = scn1.nextInt();
//
//                Scanner scn2 = new Scanner(System.in);
//                System.out.print("Enter MAC Of Receiver : ");
//                System.out.println();
//                recieverId = scn2.nextInt();
//                Scanner scanner = new Scanner(System.in);
//                StringBuilder sb = new StringBuilder();
//                if(senderId> numberOfDevices || recieverId > numberOfDevices){
//                System.out.println("ERROR: NOT ENOUGH DEVICES!");
//                }
//                System.out.println("Enter text (type 'exit' to quit):");
//                String input = scanner.nextLine();
//                if (input.equals("exit")) {
//                }
//                System.out.println("Device "+senderId+" sends to buffer:");
//                sb.append(input);
//                System.out.println("Data goes form Buffer to Hub ");
////        System.out.println("Sending Data To Hub: ");
//                StringBuilder binaryString = conversion.asciiToBinary(sb);
//                dataTransfer.delayedPrint(binaryString);
//                System.out.println("Hub Broadcasts within its domain ");
//                for(int i=0;i<numberOfDevices;i++){
//        if(i==recieverId){
//        System.out.println("Data Received By : "+recieverId+" ");
//        dataTransfer.delayedPrint(conversion.asciiToBinary(sb));
//        }else{
//        System.out.println("Data Rejected By: "+i);
//        }
//        }
