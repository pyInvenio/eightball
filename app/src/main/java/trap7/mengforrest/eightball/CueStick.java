package trap7.mengforrest.eightball;

import android.media.Image;

public class CueStick {
    int angle;
    double force;
    double x, y;
    double length, width;
    Image i;

    public CueStick(double x, double y, double length, double width, Image i) {
        this.angle = 0;
        this.force = 0;
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        this.i = i;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;

    }

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
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

    public void setY(double y) {
        this.y = y;
    }

    public void updatePosition(CueBall c) {
        angle = 90;
        force = 0;
        x = c.getX() + width / 2;
        y = c.getY();
    }
}
