//public class DNSLookupExample {
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        String IP;
//
//        TreeNode(int x) {
//            val = x;
//        }
//
//        public void performDNSLookup(String hostname) {
//            try {
//                InetAddress[] addresses = InetAddress.getAllByName(hostname);
//
//                if (addresses.length > 0) {
//                    System.out.println("IP addresses for " + hostname + ":");
//                    for (InetAddress address : addresses) {
//                        System.out.println(address.getHostAddress());
//                    }
//                } else {
//                    System.out.println("No IP addresses found for " + hostname);
//                }
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        TreeNode node = new TreeNode(5);
//        node.performDNSLookup("google.com");
//    }
//}


import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSLookupExample {

    public static void performDNSLookup(String hostname) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName(hostname);

            if (addresses.length > 0) {
                System.out.println("IP addresses for " + hostname + ":");
                for (InetAddress address : addresses) {
                    System.out.println(address.getHostAddress());
                }
            } else {
                System.out.println("No IP addresses found for " + hostname);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionLayer.TreeNode node = new SessionLayer.TreeNode(5);
        performDNSLookup("google.com");
    }
}
