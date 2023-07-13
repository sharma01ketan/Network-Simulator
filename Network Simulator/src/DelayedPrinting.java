public class DelayedPrinting {
    public static void main(String[] args) throws InterruptedException {
        String text = "Hello, World!";
        int delay = 1000; // 2 seconds
        
        System.out.println("Printing will be delayed by " + delay + " milliseconds...");
        Thread.sleep(delay);
        
        System.out.println(text);
    }
}
