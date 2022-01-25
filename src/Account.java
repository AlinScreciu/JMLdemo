public class Account {
    public /*@ pure @*/ String getUserName() {
        return userName;
    }

    public /*@ pure @*/ int getWrongPasswordCounter() {
        return wrongPasswordCounter;
    }
    /*@
    public normal_behavior
    requires auth;
    ensures \result.equals(this.somePrivateInfo);

    also

    public normal_behavior
    requires !auth;
    ensures \result == null;
    @*/
    public /*@ pure nullable @*/ String getSomePrivateInfo() {
        if (!auth) return null;
        return somePrivateInfo;
    }

    public /*@ pure @*/ boolean isAuth() {
        return auth;
    }

    public /*@ pure @*/ boolean isLocked() {
        return locked;
    }

    private final /*@ spec_public @*/ String userName;
    private final /*@ spec_public @*/ String password;
    private /*@ spec_public @*/ int wrongPasswordCounter;
    private /*@ spec_public @*/ String somePrivateInfo;
    private /*@ spec_public @*/ boolean auth, locked;
    /*@
    requires userName != null;
    requires password != null;
    ensures auth == false;
    ensures locked == false;
    @*/
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
        somePrivateInfo = "Secret";
        auth = false;
        locked = false;
    }
    /*@
        public normal_behavior
        requires !auth && !locked;
        requires password.equals(this.password);
        ensures auth;
        ensures !locked;
        ensures wrongPasswordCounter == \old(wrongPasswordCounter);

        also

        public normal_behavior
        requires !auth && !locked;
        requires !password.equals(this.password);
        requires wrongPasswordCounter < 2;
        ensures !auth;
        ensures !locked;
        ensures wrongPasswordCounter == \old(wrongPasswordCounter) + 1;

        also

        public normal_behavior
        requires !auth && !locked;
        requires !password.equals(this.password);
        requires wrongPasswordCounter == 2;
        ensures !auth;
        ensures locked;
        ensures wrongPasswordCounter == \old(wrongPasswordCounter) + 1;

        @*/
    public void login(String password)
    {
        if (locked || auth) return;
        if (!this.password.equals(password)) {
            wrongPasswordCounter++;
            if (wrongPasswordCounter == 3)
            {
                locked = true;
            }
            return;
        }
        auth = true;
    }
    /*@
    requires auth;
    ensures !auth;
    ensures wrongPasswordCounter == 0;
    @*/
    public void logout()
    {
        if (!auth) return;
        auth = false;
        wrongPasswordCounter = 0;
    }

}
