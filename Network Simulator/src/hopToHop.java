import com.sun.nio.sctp.SendFailedNotification;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hopToHop {
    static char[] sendingBuffer = new char[100];
    static char[] receivingBuffer = new char[100];
    static ArrayList<Integer> table = new ArrayList<>();
    static boolean flag = false;
    public static void hopData(int numberOfDevices1,int numberOfDevices2) throws InterruptedException {
        int senderIp=0, recieverIp = 0;
        Scanner scn1 = new Scanner(System.in);
        System.out.print("Enter IP Of Sender : ");
        System.out.println();
        senderIp = scn1.nextInt();

        Scanner scn2 = new Scanner(System.in);
        System.out.print("Enter IP Of Receiver : ");
        System.out.println();
        recieverIp = scn2.nextInt();
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
//        if(senderIp> numberOfDevices1 || recieverIp > numberOfDevices2
//        ){
//            System.out.println("ERROR: NOT ENOUGH DEVICES!");
//            return;
//        }
        System.out.println("Enter text (type 'exit' to quit):");
        String input = scanner.nextLine();
        if (input.equals("exit")) {
        }
        sb.append(input);
        if(flag && table.contains(recieverIp)){
            StringBuilder binaryString = conversion.asciiToBinary(sb);
            System.out.println("Device "+senderIp+" sends to buffer:");
            System.out.println("Data Sent: ");
            dataTransfer.delayedPrint(binaryString);
            sendingBufferControl(sb);
            int rand = randomNumber();
            if(rand<95) {
            System.out.println("Switch sends to "+recieverIp);
            System.out.println("Receivers Buffer ("+recieverIp +") Receives: ");
            receivingBufferControl(sb);
            System.out.println("Data Received By : "+recieverIp+" ");
            dataTransfer.delayedPrint(conversion.asciiToBinary(sb));
                System.out.println("ACK is sent to sender("+senderIp+")");
            } else if(rand>=95 && rand<98){
                System.out.println("Frame Got Lost Midway");
                System.out.println("Retry TransMission");
            } else{
                System.out.println("ACK Wasn't Received");
                System.out.println("Data is Retrieved from Sending Buffer");
                System.out.println("Switch sends to "+recieverIp);
                System.out.println("Receivers Buffer ("+recieverIp +") Receives: ");
                receivingBufferControl(sb);
                System.out.println("Data Received By : "+recieverIp+" ");
                dataTransfer.delayedPrint(conversion.asciiToBinary(sb));
                dataTransfer.delayedPrint(sb);
                System.out.println("ACK is sent to sender("+senderIp+")");
            }
        } else{
            flag = true;
            table.add(recieverIp);
            StringBuilder binaryString = conversion.asciiToBinary(sb);
            System.out.println("Device "+senderIp+" sends to buffer:");
            System.out.println("Data Sent: ");
            dataTransfer.delayedPrint(binaryString);
            sendingBufferControl(sb);
            System.out.println("Switch Broadcasts to all");
            for(int i=numberOfDevices1;i<numberOfDevices1+numberOfDevices2;i++){
                if(i==recieverIp){
                    System.out.println("Data Received By : "+recieverIp+" ");
                    dataTransfer.delayedPrint(conversion.asciiToBinary(sb));
                    dataTransfer.delayedPrint(sb);
                }else{
                    System.out.println("Data Rejected By: "+i);
                }
            }
            System.out.println("ACK is sent to sender("+senderIp+")");
            System.out.println("ACK is recived by the sender within the time frame.");
        }

        return;
    }
    public static void sendingBufferControl(StringBuilder sb){
        System.out.println("Sending Buffer: ");
        StringBuilder s = conversion.asciiToBinary(sb);
        int l = s.length();
        for(int i=0;i<l;i++){
            sendingBuffer[i] = s.charAt(i);
        }
        printSending(s);
    }
    public static void receivingBufferControl(StringBuilder sb){
        System.out.println("Receiving Buffer: ");
        StringBuilder s = conversion.asciiToBinary(sb);
        int l = s.length();
        for(int i=0;i<l;i++){
            sendingBuffer[i] = s.charAt(i);
            receivingBuffer[i]=s.charAt(i);
        }
        printReceiving(s);
    }
    public static void printSending(StringBuilder sb){
        for(int i=0;i<sb.length();i++){
            System.out.print(sendingBuffer[i]+" ");
        }
        System.out.println();
        return;
    }
    public static void printReceiving(StringBuilder sb){
        for(int i=0;i<sb.length();i++){
            System.out.print(receivingBuffer[i]+" ");
        }
        System.out.println();
        return;
    }
    public static void cleanBuffer(){
        for(int i=0;i<sendingBuffer.length;i++){
            sendingBuffer[i]=0;
            receivingBuffer[i]=0;
        }
    }
    public static int randomNumber() {
        Random random = new Random();
        // Generate a random integer between 0 and 9
        int randomNumber = random.nextInt(100);
        return randomNumber;
    }
}
