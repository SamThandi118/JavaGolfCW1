package co1105.cw1.st500;

public class Course {
    private String name;
    private int[] holes;
    private int coursePar;

    Course(String name, int[] holes) {
        this.name = name;
        this.holes = holes;
    }

    String getCourseName() {
        return name;
    }

    int getHolePar(int h) {
        return holes[h];
    }

    int getCoursePar() {
        coursePar = 0;
        for (int i = 0; i < holes.length; i++) {
            coursePar = coursePar + holes[i]; // Adds all the par scores together to give it as a total
        }
        return coursePar;
    }

    public String toString() {
        String results;
        results = "";
        for (int i = 0; i < holes.length; i++) {  //Outputs the par score of each hole with %3s spacing
           results = results + String.format("%3s", holes[i]);
        }
        results = String.format("%10s", getCourseName()) + String.format("%8s", "") + results + "   Par: "
                + getCoursePar(); // Adds the name, and the total par score on either side of par for each hole.
        return results;
    }
}
