import java.lang.Math;
public class Square {
    public int side;

    /*@
     requires side > 0;
     ensures \result == side*side;
     @*/
    public /*@ pure @*/ int getArea() {
        //@ assume side*side < Integer.MAX_VALUE;
        return side*side;
    }
    /*@
     requires side > 0;
     ensures \result == Math.sqrt(2) * side;
     @*/
    public /*@ pure @*/ double getDiagonal() {
        //@ assume Math.sqrt(2)*side < Double.MAX_VALUE;
        return Math.sqrt(2)*side;
    }
}
