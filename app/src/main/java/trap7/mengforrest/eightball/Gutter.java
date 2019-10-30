package trap7.mengforrest.eightball;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Gutter {
    int x, y;
    Bitmap image;

    int size = 60;

    public Gutter(Bitmap c, int x, int y) {
        this.x = x + size;
        this.y = y + size;
        image = c;
    }

    public void draw(final Canvas canvas) {
        image = Bitmap.createScaledBitmap(image, size * 2, size * 2, true);
        canvas.drawBitmap(image, (float) x - size * 2, (float) y - size * 2, null);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean ballisGutted(Ball b) {
        if (Calculate.distance(b.getX(), b.getY(), this.x - size, this.y - size) < size)
            return true;
        return false;
    }
}
