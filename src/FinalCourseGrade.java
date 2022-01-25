/*
    - E1 stands for first exam, E2 stands for second exam and L stands for laboratory
    - every exam gives a maximum of 10 points, the student must obtain at least 5 points in each one, if not, they must redo both exams
    - lab gives 4 point at max, the student must obtain at least 2 points, if not they must retake the course
    - in order to pass the exam E1+E2=12 and E1+E2+L=14, if not the student they must redo both exams
    - method returns the final result or 0 if the student must redo both exams or -1 if not the student must retake the course
*/

public class FinalCourseGrade {
    //@ public invariant (E1 >= 0 && E1 <= 10 && E2 >= 0 && E2 <= 10 && 0 <= L <= 4);
    private /*@ spec_public @*/ final int E1, E2, L;
    /*@
    requires (E1 >= 0 && E1 <= 10 && E2 >= 0 && E2 <= 10 && 0 <= L <= 4);
    @*/
    public FinalCourseGrade(int E1, int E2, int L)
    {
        this.E1 = E1;
        this.E2 = E2;
        this.L = L;
    }
    /*@
        requires L < 2;
        ensures \result == -1;
        also
        requires (E1 < 5 || E2 < 5 || E1 + E2 < 12) && L >=2;
        ensures \result == 0;
        also
        requires (!(E1 < 5 || E2 < 5 || E1 + E2 < 12) && L >=2 )&& (E1 + E2 >= 12 && E1 + E2 + L >= 14);
        ensures \result == E1+E2+L;
    @ */
    public int computeScore() {
        if (L < 2)
            return -1;
        if (E1 < 5 || E2 < 5 || E1 + E2 < 12)
            return 0;
        if (E1 + E2 >= 12 && E1 + E2 + L >= 14)
            return E1+E2+L;

        return 0;
    }
}