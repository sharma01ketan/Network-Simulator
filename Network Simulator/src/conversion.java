import java.util.Scanner;

public class conversion {
    public static StringBuilder decodeNRZL(StringBuilder sb) {
        return sb;
    }
    public static StringBuilder encodeNRZL(StringBuilder sb) {
        return sb;
    }
    public static StringBuilder asciiToBinary(StringBuilder asciiStringBuilder) {
        StringBuilder binaryStringBuilder = new StringBuilder();

        for (int i = 0; i < asciiStringBuilder.length(); i++) {
            char c = asciiStringBuilder.charAt(i);
            String binaryString = Integer.toBinaryString(c);
            // pad the binary string with leading zeroes if necessary
            while (binaryString.length() < 8) {
                binaryString = "0" + binaryString;
            }
            binaryStringBuilder.append(binaryString);
        }

        return binaryStringBuilder;
    }
    public static StringBuilder binaryToAscii(StringBuilder binaryStringBuilder) {
        StringBuilder asciiStringBuilder = new StringBuilder();

        // loop through the binary string 8 bits at a time
        for (int i = 0; i < binaryStringBuilder.length(); i += 8) {
            String binaryString = binaryStringBuilder.substring(i, i + 8);
            int asciiValue = Integer.parseInt(binaryString, 2);
            char c = (char) asciiValue;
            asciiStringBuilder.append(c);
        }

        return asciiStringBuilder;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.println("Enter text (type 'exit' to quit):");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
            }
            sb.append(input);

        System.out.println("StringBuilder content: " + sb.toString());
        StringBuilder binarySB = asciiToBinary(sb);System.out.println("binarySB "+ binarySB);
//        StringBuilder asciiSB = binaryToAscii(binarySB);System.out.println("asciiSB "+asciiSB);
//        StringBuilder encoded = encodeNRZL(binarySB);System.out.println("encoded "+encoded);
//        StringBuilder decoded = decodeNRZL(encoded);System.out.println("decoded "+decoded);
//        System.out.println(decoded.equals(binarySB));
//        StringBuilder asciiAns = binaryToAscii(decoded);System.out.println("asciiAns "+asciiAns);
    }
}