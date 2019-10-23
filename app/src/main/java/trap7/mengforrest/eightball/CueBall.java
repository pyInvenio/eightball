package trap7.mengforrest.eightball;

import android.graphics.Bitmap;
import android.media.Image;

public class CueBall extends Ball {

    float mass = 0.26f;

    CueBall(Bitmap c, int n, double x, double y) {
        super(c, n, x, y);
    }

    public void hit(double speed, double angle) {
        super.setSpeed(speed);
        super.setAngle(angle);
    }

    @Override
    public boolean isGutted() {
        return super.isGutted();
    }
}
