// openjml -rac RacTest.java
public class RacTest {

    public static void main(String... args) {
        Test a = new Test();
        a.checkArgs(args.length);
        System.out.println("END");
    }


}