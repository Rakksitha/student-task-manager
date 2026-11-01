public class MainTest {
    public static void main(String[] args) {
        if (Main.add(10, 20) == 30) {
            System.out.println("Test Passed!");
        } else {
            throw new RuntimeException("Test Failed!");
        }
    }
}
