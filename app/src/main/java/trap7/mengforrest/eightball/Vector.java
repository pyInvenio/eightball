package trap7.mengforrest.eightball;

public class Vector {
    double angle;
    double speed, speedx, speedy;

    public Vector(double a, double s) {
        this.angle = a;
        this.speed = s;
        this.speedx = s * Math.cos(Math.toRadians(a));
        this.speedy = s * Math.sin(Math.toRadians(a));
    }

    public Vector(double x1, double y1, double x2, double y2) {
        this.angle = Math.toDegrees(Math.atan2(y1 - y2, x1 - x2));
        this.speed = Calculate.distance(x1, y1, x2, y2);
        this.speedx = this.speed * Math.cos(Math.toRadians(this.angle));
        this.speedy = this.speed * Math.sin(Math.toRadians(this.angle));
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        if (angle < 0)
            angle = 360 + angle % 360;
        else if (angle > 360)
            angle = angle % 360;
        this.angle = angle;
        calculateComponentSpeeds();
    }

    public double getSpeed() {
        return speed;
    }

    public void calculateComponentSpeeds() {
        this.speedx = speed * Math.cos(Math.toRadians(this.angle));
        this.speedy = speed * Math.sin(Math.toRadians(this.angle));
    }

    public double getSpeedNew() {
        return Math.sqrt(speedx * speedx + speedy * speedy);
    }

    public double getSpeedx() {
        return speedx;
    }

    public double getSpeedy() {
        return speedy;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
        calculateComponentSpeeds();
    }

    public void setSpeedx(double speedx) {
        this.speedx = speedx;
        this.speed = Math.sqrt(this.speedx * this.speedx + this.speedy * this.speedy);
        //this.angle = 180 + Math.atan2(this.speedy, this.speedx);
        this.angle = (float) Math.toDegrees(Math.atan2(this.speedy, this.speedx));
    }

    public void setSpeedy(double speedy) {
        this.speedy = speedy;
        this.speed = Math.sqrt(this.speedx * this.speedx + this.speedy * this.speedy);
        //this.angle = 180 + Math.atan2(this.speedy, this.speedx);
        this.angle = (float) Math.toDegrees(Math.atan2(this.speedy, this.speedx));
    }

    public double angleBetween(Vector v) {
        double dot = dot(v);
        return Math.acos(dot / (speed * v.getSpeed()));
    }

    public double dot(Vector v) {
        return speedx * v.getSpeedx() + (speedy * v.getSpeedy());
    }

    public Vector createVector(double x, double y) {
        Vector retV = new Vector(Math.toDegrees(Math.atan((y / x))), Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
        return retV;
    }

    public Vector addVector(Vector v) {
        double x = speedx * Math.cos(Math.toRadians(angle)) + v.getSpeed() * Math.cos(Math.toRadians(v.getAngle()));
        double y = speedy * Math.sin(Math.toRadians(angle)) + v.getSpeed() * Math.sin(Math.toRadians(v.getAngle()));
        return createVector(x, y);
    }

    public Vector subVector(Vector v) {
        double x = speedx * Math.cos(Math.toRadians(angle)) - v.getSpeed() * Math.cos(Math.toRadians(v.getAngle()));
        double y = speedy * Math.sin(Math.toRadians(angle)) - v.getSpeed() * Math.sin(Math.toRadians(v.getAngle()));
        return createVector(x, y);
    }

    public void multVector(double m) {
        speed = speed * m;
    }
}
