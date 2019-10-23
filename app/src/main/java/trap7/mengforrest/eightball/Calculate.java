package trap7.mengforrest.eightball;

public class Calculate {
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static double acceleration(double v1, double v2, double d) {
        return (Math.pow(v1, 2) - Math.pow(v2, 2)) / (2 * d);
    }

    public static double finalSpeed(double v1, double a, double d) {
        return Math.sqrt(2 * a * d + v1);
    }
}
