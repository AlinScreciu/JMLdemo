public class Test {
    public static String toString(Account a) {
        return "Account{" +
                "userName='" + a.getUserName() + '\'' +
                ", wrongPasswordCounter=" + a.getWrongPasswordCounter() +
                ", somePrivateInfo='" + a.getSomePrivateInfo() + '\'' +
                ", auth=" + a.isAuth() +
                ", locked=" + a.isLocked() +
                '}';
    }
    public static void main(String[] args) {
        Account a = new Account(null,"123");
        a.login("123");
        System.out.println(toString(a));
        a.login("123");

        a.login("12");
        System.out.println(toString(a));
        a.login("12");
        System.out.println(toString(a));
        a.login("12");
        System.out.println(toString(a));
        a.login("12");
        System.out.println(toString(a));
        a.login("123");
        System.out.println(toString(a));
        a.logout();
        System.out.println(toString(a));
    }

}
