//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//
//public class BinaryTreeHttpExample {
//
//    public static void main(String[] args) {
//        TreeNode root = createBinaryTree();
//
//        // Get data from node 4 and send it to node 7
//        TreeNode node4 = getNode(root, 4);
//        TreeNode node7 = getNode(root, 7);
//
//        String data = fetchDataFromNode(node4);
//        sendToNode(data, node7);
//    }
//
//    public static TreeNode createBinaryTree() {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        return root;
//    }
//
//    public static TreeNode getNode(TreeNode root, int value) {
//        if (root == null || root.val == value) {
//            return root;
//        }
//
//        TreeNode left = getNode(root.left, value);
//        if (left != null) {
//            return left;
//        }
//
//        TreeNode right = getNode(root.right, value);
//        return right;
//    }
//
//    public static String fetchDataFromNode(TreeNode node) {
//        String url = "http://localhost:8080/node/" + node.val + "/data";
//
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet httpGet = new HttpGet(url);
//
//        try {
//            HttpResponse response = httpClient.execute(httpGet);
//            HttpEntity entity = response.getEntity();
//            if (entity != null) {
//                return EntityUtils.toString(entity);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "";
//    }
//
//    public static void sendToNode(String data, TreeNode node) {
//        String url = "http://localhost:8080/node/" + node.val + "/receive";
//
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet httpGet = new HttpGet(url);
//
//        try {
//            HttpResponse response = httpClient.execute(httpGet);
//            // Handle the response if needed
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//    }
//}
//
//
//
//
//
//
//
// class HTTPCommunicationExample {
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
//
//    public static void main(String[] args) {
//        // Create two TreeNode objects
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(10);
//
//        // Convert TreeNode objects to JSON strings
//        String jsonNode1 = convertToJson(node1);
//        String jsonNode2 = convertToJson(node2);
//
//        // Send JSON strings over HTTP
//        sendHttpRequest(jsonNode1);
//        sendHttpRequest(jsonNode2);
//    }
//
//    private static String convertToJson(TreeNode node) {
//        // Convert the TreeNode object to a JSON string
//        // You can use a library like Jackson or Gson for more complex conversions
//        return "{\"val\": " + node.val + "}";
//    }
//
//    private static void sendHttpRequest(String json) {
//        try {
//            URL url = new URL("http://example.com/api"); // Replace with your API endpoint
//
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-Type", "application/json");
//            connection.setDoOutput(true);
//
//            // Send the JSON string as the request body
//            OutputStream outputStream = connection.getOutputStream();
//            outputStream.write(json.getBytes());
//            outputStream.flush();
//            outputStream.close();
//
//            // Read the response
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line;
//            StringBuilder response = new StringBuilder();
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            reader.close();
//
//            // Process the response as needed
//            System.out.println("Response: " + response.toString());
//
//            connection.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
// class HTTPConnectionExample {
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
//        public void makeHttpRequest(String url) {
//            try {
//                URL apiUrl = new URL(url);
//                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
//                connection.setRequestMethod("GET");
//
//                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String line;
//                StringBuilder response = new StringBuilder();
//                while ((line = reader.readLine()) != null) {
//                    response.append(line);
//                }
//                reader.close();
//
//                System.out.println("Response: " + response.toString());
//
//                connection.disconnect();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        TreeNode node = new TreeNode(5);
//        node.makeHttpRequest("http://www.google.com");
//    }
//}
//
