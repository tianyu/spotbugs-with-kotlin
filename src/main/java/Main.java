import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(generateSecretToken());
    }

    public static String generateSecretToken() {
        Random r = new Random();
        return Long.toHexString(r.nextLong());
    }
}
