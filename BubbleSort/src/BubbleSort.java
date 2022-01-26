public class BubbleSort {

    /*@
         requires vector != null;
         ensures \forall int k;0 <= k < vector.length-1; vector[k] <= vector[k+1];
     @*/
    public static void sort(int [] vector) {
        //@ final ghost int len = vector.length;
        // bounds
        //@ loop_invariant 0 <= i <= len;
        // loop is sorted until i
        //@ loop_invariant \forall int k;0 <= k < i; \forall int l; k < l < len; vector[k] <= vector[l];
        for (int i = 0; i < vector.length; i++) {


            // bounds
            //@ loop_invariant i <= j <= len - 1;
            // j-th element is always the smallest
            //@ loop_invariant \forall int k; j <= k < len; vector[j] <= vector[k];
            // ensure loop keeps sortedness
            //@ loop_invariant \forall int k; 0 <= k < i; \forall int l; k < l < len; vector[k] <= vector[l];
            for (int j = vector.length-1; j > i; j--) {
                if (vector[j-1] > vector[j]) {
                    int tmp = vector[j];
                    vector[j] = vector[j-1];
                    vector[j-1] = tmp;
                }
            }
        }

    }
}