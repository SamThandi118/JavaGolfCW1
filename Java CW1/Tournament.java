package co1105.cw1.st500;

public class Tournament{
    private Course course;
    private ScoreCard[] scores;

    public Tournament(Course course, ScoreCard[] scores) {
        this.course = course;
        this.scores = scores;
    }

    public String declareWinner() {
        String winner = "";
        double time = scores[0].getAdjustedTime(); //calls from scoreCard
        /* Saves the first time of 0 into time, then for the amount of results in scores, increments through checking each individual score
        checks score[0] then score[1] etc. and saves in checkTime. Reference comment on line 20 for next step
        */
        for (int i = 0; i < scores.length; i++) {
            double checkTime = scores[i].getAdjustedTime();
            // if loop checks to see if check time is smaller than time. if it is,
            // time is updated to a new value of checkTime when checkTime is smaller.
            if (checkTime < time) {
                time = checkTime;
                winner = "\n" + "Winner is: " + scores[i].getName();
            }
        }
        return winner;
    } 

    public String toString() {
        String results = course.toString() + "\n";
        for (int i = 0; i < scores.length; i++) {
            results = results + "\n" + scores[i].toString(); // adds new line for each new player
        }
        return results;
    }
}
