import java.util.ArrayList;
import java.util.Scanner;

public class testCase1helper {
    static char[] sendingBufferLocal = new char[100];
    static ArrayList<Integer> tableTestCase1 = new ArrayList<>();
    public static void sendDataWithin(int numberOfDevices) throws InterruptedException {
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
        if(!tableTestCase1.contains(recieverId)) {
            tableTestCase1.add(recieverId);
            System.out.println("Device "+senderId+" sends to buffer:");
            sb.append(input);
            System.out.println("Data goes form Buffer to Switch");
//        System.out.println("Sending Data To Hub: ");
            StringBuilder binaryString = conversion.asciiToBinary(sb);
            delayedPrint(binaryString);
            System.out.println("Switch Broadcasts: ");
            for(int i=0;i<numberOfDevices;i++){
                if(i==recieverId){
                    System.out.println("Data Received By : "+recieverId+" ");
                    delayedPrint(conversion.asciiToBinary(sb));
                }else{
                    System.out.println("Data Rejected By: "+i);
                }
            }
        } else if(tableTestCase1.contains(recieverId)){
            System.out.println("Device "+senderId+" sends to buffer:");
            sb.append(input);
            System.out.println("Data goes form Buffer to Switch");
//        System.out.println("Sending Data To Hub: ");
            StringBuilder binaryString = conversion.asciiToBinary(sb);
            delayedPrint(binaryString);
            System.out.println("Switch Sends Data to "+recieverId);
            System.out.println("Data Received By : "+recieverId+" ");
            delayedPrint(conversion.asciiToBinary(sb));
        }

    }
    public static void delayedPrint(StringBuilder sb) throws InterruptedException {
        int delay = 100; // 100 milliseconds
        for (int i = 0; i < sb.length(); i++) {
            System.out.print(sb.charAt(i));
            Thread.sleep(delay);
        }
        System.out.println(); // print a newline at the end
    }

    public static void main(String[] args) throws InterruptedException {
        sendDataWithin(10);
//        StringBuilder sb = new StringBuilder("ketan");
//        delayedPrint(sb);
    }

}
