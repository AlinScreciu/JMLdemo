/*
    - E1 stands for first exam, E2 stands for second exam and L stands for laboratory
    - every exam gives a maximum of 10 points, the student must obtain at least 5 points in each one, if not, they must redo both exams
    - lab gives 4 point at max, the student must obtain at least 2 points, if not they must retake the course
    - in order to pass the exam E1+E2=12 and E1+E2+L=14, if not the student they must redo both exams
    - method returns the final result or 0 if the student must redo both exams or -1 if not the student must retake the course
*/

public class FinalCourseGrade {
    /*@
        requires L >= 0
        && E1 >= 0
        && E1 <= 10
        && E2 >= 0
        && E2 <= 10
        && L <= 4;
        ensures (\result == -1) <==> (L < 2)
        && (\result == 0) <==> (E1 < 5 || E2 < 5 || E1+E2 < 12) &&  (L >= 2)
        && (\result == E1+E2+L) <==> (E1 >= 5 && E2 >= 5 && L >= 2 && E1+E2 >= 12 && E1+E2+L >= 14);
    @ */
    public static int computeScore(int E1, int E2, int L) {
        if (E1 >= 5 && E2 >= 5 && L >= 2 && E1+E2 >= 12 && E1+E2+L >= 14)
            return E1+E2+L;
        if ((E1 < 5 || E2 < 5 || E1+E2 < 12) &&  (L >= 2))
            return 0;

        if (L < 2)
            return -1;
        return 0;
    }
}