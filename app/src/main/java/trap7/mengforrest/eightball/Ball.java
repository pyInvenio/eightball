package trap7.mengforrest.eightball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;

public class Ball {
    static final int BALL_RADIUS = 30;

    //kg
    float mass = 0.15f;
    int cHeight;
    int cWidth;
    Bitmap color;
    int number;
    boolean hit;
    Paint p = new Paint();

    boolean gutted;
    Vector ballV;
    double x, y;

    Ball(Bitmap c, int n, double x, double y) {
        color = c;
        number = n;
        this.x = x + BALL_RADIUS;
        this.y = y + BALL_RADIUS;
        ballV = new Vector(0, 0);
        p.setColor(Color.GREEN);
        p.setStrokeWidth(5.0f);

    }

    public void draw(final Canvas canvas) {
        color = Bitmap.createScaledBitmap(color, BALL_RADIUS * 2, BALL_RADIUS * 2, true);
        canvas.drawBitmap(color, (float) x - BALL_RADIUS, (float) y - BALL_RADIUS, null);
        cWidth = canvas.getWidth();
        cHeight = canvas.getHeight();
        canvas.drawLine((float) x, (float) y, (float) (x - ballV.getSpeedx() * 10), (float) (y + ballV.getSpeedy() * 10), p);

    }

//    public Image getColor() {
//        return color;
//    }

    public int getNumber() {
        return number;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public boolean isGutted() {
        return gutted;
    }

    public void setGutted(boolean gutted) {
        this.gutted = gutted;
    }

    public double getSpeed() {
        return ballV.getSpeed();
    }

    public void setSpeed(double speed) {
        ballV.setSpeed(speed);
    }

    public void setSpeedx(double speed) {
        ballV.setSpeedx(speed);
    }

    public void setSpeedy(double speed) {
        ballV.setSpeedy(speed);
    }

    public double getAngle() {
        return ballV.getAngle();
    }

    public void setAngle(double angle) {
        ballV.setAngle(angle);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return BALL_RADIUS;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector getVector() {
        return ballV;
    }

    public void seperate(Ball b) {
        this.setX(x - (ballV.getSpeedx()));
        this.setY(y - (ballV.getSpeedy()));
        b.setX(b.x - (b.getVector().getSpeedx()));
        b.setY(b.y - (b.getVector().getSpeedy()));
    }

    public boolean isColBallCheck(Ball b) {
        return Calculate.distance(x, y, b.x, b.y) < 2 * BALL_RADIUS + 3;
    }

    public boolean isCollideBall(Ball b) {
        if (Calculate.distance(x + ballV.getSpeedx(), y + ballV.getSpeedy(), b.x, b.y) < 2 * BALL_RADIUS + 3) {

            while (isColBallCheck(b))
                seperate(b);

            this.gotCollided(b);
            return true;
        }
        return false;
    }

    public void gotCollided(Ball b) {

        double velx1 = b.getVector().getSpeedx();
        double vely1 = b.getVector().getSpeedy();
        double speed1 = b.getVector().getSpeed();
        double velx2 = this.getVector().getSpeedx();
        double vely2 = this.getVector().getSpeedy();
        double speed2 = Math.sqrt(velx2 * velx2 + vely2 * vely2);

        double diffx = this.x - b.getX();
        double diffy = this.y - b.getY();
        double abtwn = 180 + Math.toDegrees(Math.atan2(diffy, diffx));
        //double abtwn = Math.toDegrees(ballV.angleBetween(b.getVector()));
        double reflectionAngle2 = 180 + Math.toDegrees(Math.atan2(y - b.y, x - b.x));
        double reflectionAngle1 = 180 + Math.toDegrees(Math.atan2(b.y - y, b.x - x));
        double newAngle1 = 2 * reflectionAngle1 - abtwn;
        double newAngle2 = 2 * reflectionAngle2 - abtwn;
        b.setAngle(newAngle1);
        this.setAngle(newAngle2);
        if (speed1 < 0.01) {
            b.setSpeed(speed2 * .5);
            this.setSpeed(speed2 * .7);
        } else if (speed2 < 0.01) {
            this.setSpeed(speed1 * .5);
            b.setSpeed(speed1 * .7);
        } else {
            this.setSpeed(speed2 * .6);
            b.setSpeed(speed1 * .6);
        }
        System.out.println(abtwn + " " + newAngle1 + " " + newAngle2);
    }

    public boolean isCollideWallX() {
        if (this.y - BALL_RADIUS <= 0 || this.y + BALL_RADIUS >= cHeight)
            return true;
        return false;
    }

    public boolean isCollideWallY() {
        if (this.x - BALL_RADIUS <= 0 || this.x + BALL_RADIUS >= cWidth)
            return true;
        return false;
    }

    public void lessSpeed(double r) {
        ballV.setSpeed(ballV.getSpeed() * r);
        ballV.setSpeedx(ballV.getSpeedx() * r);
        ballV.setSpeedy(ballV.getSpeedy() * r);
    }

    public void changeSpeed() {
        this.lessSpeed(0.99);

    }

    public void update() {
        if (isCollideWallY()) {
            ballV.setSpeedx(-ballV.getSpeedx());
        }
        if (isCollideWallX()) {
            ballV.setSpeedy(-ballV.getSpeedy());
        }

        x += ballV.getSpeedx();
        y += ballV.getSpeedy();
    }

}
