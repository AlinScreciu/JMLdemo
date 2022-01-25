// openjml -rac RacTest.java
public class RacTest {

    public static void main(String... args) {
        TestRac a = new TestRac();
        a.checkArgs(args.length);
        System.out.println("END");
    }


}