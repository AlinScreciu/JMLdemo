import java.util.Random;

public class Match {
    private final String team1;
    private final String team2;
    private int outs, corners, score1, score2;
    public Match(String team1, String team2) {
        this.team1 = team1;
        this.team2 = team2;
        outs = 0;
        corners = 0;
        score1 = 0;
        score2 = 0;
    }
    public String toString() {
        return String.format("%s %d\n%s %d\nCorners: %d\nOuts: %d\n", team1, score1, team2, score2, corners, outs);
    }
    public void play()
    {

        Minge minge = new Minge(50,25);

        Random gen = new Random();
        for (int i = 0 ; i < 90; i++)
        {
            int moves = gen.nextInt(5) + 1;
            for (int j = 0; j < moves; j++)
            {
                minge.makeX();
                minge.makeY();
                try {
                    minge.shoot();
                } catch (Out e) {
                    minge = new Minge(minge.getX(), minge.getY());
                    outs++;
                } catch (Corner e) {
                    corners++;
                    int x = minge.getX();
                    int y = minge.getY();
                    if (x == 0)
                    {
                        if (y < 20)
                            minge = new Minge(0,0);
                        if (y > 30)
                            minge = new Minge(0,50);
                    }
                    if ( x == 100)
                    {
                        if (y < 20)
                            minge = new Minge(100,0);
                        if (y > 30)
                            minge = new Minge(100,50);
                    }
                } catch (Gol e) {
                    if (minge.getX() == 0) {
                        score1++;
                    }
                    if (minge.getX() == 100) {
                        score2++;
                    }
                    minge= new Minge(50,25);
                }
            }

        }
    }

}
