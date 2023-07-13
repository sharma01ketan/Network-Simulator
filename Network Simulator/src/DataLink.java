import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLink {
    static int id = 0;
    static int ip = 0;
    public static class Switch{
        int identityNumber = 1000;
        ArrayList<Device> connectedDevices = new ArrayList<>();

        public static Switch addNode(Switch sw){
            Device newDevice = new Device();
            sw.connectedDevices.add(newDevice);
            return sw;
        }
    }
    public static class Device{
        int identityNumber;
        int ipNumber;
        public Device() {
            this.identityNumber = id++;
            this.ipNumber = ip++;
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
                dataTransfer.sendDataWithin(numberOfDevices1);
            } else{
                dataTransfer.sendDataWithin(numberOfDevices2);
            }
        } else{
            Scanner scn5 = new Scanner(System.in);
            int temp5 = 0;
            while(temp5>=0){
                System.out.println("Press -1 to Quit");
                System.out.println("Press 1 to Proceed");
                temp5 = scn5.nextInt();
                hopToHop.hopData(numberOfDevices1,numberOfDevices2);
            }
        }
    }
}