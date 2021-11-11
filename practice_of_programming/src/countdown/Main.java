package smoother;

public class Main {
    static final int LEN = 100000000;
    static final int RANGE = 5000;
    static java.util.Random rand = new java.util.Random();

    // Assertion: the template array has odd length.
    static int[] template = 
        { 1, 2, 4, 8, 16, 32, 64, 16, 0, -32, 0, 16, 64, 32, 16, 8, 4, 2, 1 };
    static int templateRadius = template.length / 2;

    static int[] source = new int[LEN];
    static int[] target = new int[LEN - template.length];

    public static void main(String[] args) {

        long timer = 0;

        // initialise with random integers
        for (int i = 0; i < LEN; i++) {
            source[i] = rand.nextInt(2 * RANGE + 1) - RANGE;
        }

        for (int j = 0; j < 100; j++) {
            long startTime = System.currentTimeMillis();
            smoother(source, 0, source.length - template.length, target);
            timer += System.currentTimeMillis() - startTime;
            System.out.printf("Iteration %d complete.%n", j);
        }

        System.out.printf("Elapsed time: %d milli-secs%n", timer);
    }

    public static void smoother(int[] in, int start, int end, int[] out) {
        for (int i = start; i < end; i++) {
            int res = 0;
            for (int j = 0; j < template.length; j++) {
                res += in[i + j] * template[j];
            }
            out[i] = res; 
        }
    }
}