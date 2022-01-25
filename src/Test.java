public class Test {
    public Test()
    {

    }
    public void checkArgs(int len) {
        //@ assert len == 1;
        if (len == 1)
            System.out.println("Wow!");
    }
}
