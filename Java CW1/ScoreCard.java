package co1105.cw1.st500;

public class ScoreCard {
    private String name;
    private Course course;
    private double time;
    private int[] holeScores;

    ScoreCard(String n, Course c, double t, int[] ss) {
        this.name = n;
        this.course = c;
        this.time = t;
        this.holeScores = ss;
    }

    String getName() {
        return name;
    }

    double getRawTime() {
        return time;
    }

    // Finds the correct score by taking player score away from predicted stroke, i is the same value in each section of data/list
    int[] getScores() {
        for (int i = 0; i < holeScores.length; i++) {
            holeScores[i] = holeScores[i] - course.getHolePar(i);
        }
        return holeScores;
    }

    double getAdjustedTime() {
        double adjustedTime = 0;
        for (int i = 0; i < holeScores.length; i++) {
            adjustedTime = adjustedTime + holeScores[i];
        } // Adds score, hole pars and time together to get adjustedTime that gets out put'ed on the right.
        adjustedTime = adjustedTime + course.getCoursePar() + time;
        return adjustedTime;
    }

    public String toString() {
        getScores();
        String results;
        /* %Xs refers to amount of space between each value. Format for printing out the results of the scorecard, prints name, raw time
         * the for loop adds the stroke score to the scorecard.
         */
        results = String.format("%10s", getName()) + " " + String.format("%1s", "(" + getRawTime() + ") ");
        for (int i = 0; i < holeScores.length; i++) {
            results = results + String.format("%3s", holeScores[i]);
        }
        results = results + "   " + "AdjustedTime:" + String.format("%5s", getAdjustedTime()); // Adds the adjusted time to the bottom
        return results;
    }
}
