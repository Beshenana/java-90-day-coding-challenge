
package edu.haramaya.cosc3053.Day10;

// TODO 10.1: Custom checked exception
class InvalidScoreException extends Exception {

    public InvalidScoreException(String msg) {
        super(msg);
    }
}

public class ScoreValidator {

    // TODO 10.2: Validate student score
    public static double validate(double score)
            throws InvalidScoreException {

        if (!Double.isFinite(score) || score < 0.0 || score > 100.0) {

            throw new InvalidScoreException(
                    "Score out of bounds: " + score
            );
        }

        return score;
    }

    public static void main(String[] args) {

        try {

            double score = validate(105.0);

            System.out.println("Valid Score: " + score);

        } catch (InvalidScoreException e) {

            System.out.println(
                    "Caught Expected Exception: " + e.getMessage()
            );

        } finally {

            System.out.println("Score validation completed.");
        }
    }
}
