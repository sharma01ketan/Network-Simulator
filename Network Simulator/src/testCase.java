import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.Scanner;

public class testCase {
    static int mac = 0;
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
            this.identityNumber = mac++;
            this.ipNumber = mac++;
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
        System.out.println("Press 1 for Local Using Switch");
        Scanner scn3 = new Scanner(System.in);
        int temp = scn3.nextInt();
        if(temp==1){
            System.out.println("Press 1 for first Region");
            Scanner scn4 = new Scanner(System.in);
            int temp4 = scn4.nextInt();
            if(temp4==1){
//                testCase1helper.sendDataWithin(numberOfDevices1);
                Scanner scn5 = new Scanner(System.in);
                int temp5 = 0;
                while(temp5>=0){
                    System.out.println("Press -1 to Quit");
                    System.out.println("Press 1 to Proceed");
                    temp5 = scn5.nextInt();
                    if(temp5==-1)break;
                    System.out.println("Collision Domains: 0 ");
                    System.out.println("Broadcast Domains "+numberOfDevices1);
                    testCase1helper.sendDataWithin(numberOfDevices1);
                }
            }
        }
//        else{
//            Scanner scn5 = new Scanner(System.in);
//            int temp5 = 0;
//            while(temp5>=0){
//                System.out.println("Press -1 to Quit");
//                System.out.println("Press 1 to Proceed");
//                temp5 = scn5.nextInt();
//                testCase1helper.hopData(numberOfDevices1);
//            }
//        }
    }
}