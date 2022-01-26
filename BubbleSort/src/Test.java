import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] test = {3,2,1,5,6,10};
        System.out.println(Arrays.toString(test));
        BubbleSort.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
