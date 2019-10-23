package trap7.mengforrest.eightball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import trap7.mengforrest.eightball.Ball;
import trap7.mengforrest.eightball.Calculate;
import trap7.mengforrest.eightball.R;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;

class DrawView extends View {
    Ball b8, b1, b2, b3, b4, b5, b6, b7, b9, b10, b11, b12, b13, b14, b15;
    Ball c;
    static final int BALL_RADIUS = 30;

    double speed8, angle8, speed1, angle1, speed2, angle2, speed3, angle3, speed4, angle4, speed5, angle5, speed6, angle6, speed7, angle7, speed9, angle9, speed10, angle10, speed11, angle11, speed12, angle12, speed13, angle13, speed14, angle14, speed15, angle15;
    double speedC, angleC;
    int ticks = 200;
    ArrayList<Ball> balls = new ArrayList<Ball>();
    Bitmap bitmapb1 = BitmapFactory.decodeResource(getResources(), R.drawable.oneball);
    Bitmap bitmapb2 = BitmapFactory.decodeResource(getResources(), R.drawable.twoball);
    Bitmap bitmapb3 = BitmapFactory.decodeResource(getResources(), R.drawable.threeball);
    Bitmap bitmapb4 = BitmapFactory.decodeResource(getResources(), R.drawable.fourball);
    Bitmap bitmapb5 = BitmapFactory.decodeResource(getResources(), R.drawable.fiveball);
    Bitmap bitmapb6 = BitmapFactory.decodeResource(getResources(), R.drawable.sixball);
    Bitmap bitmapb7 = BitmapFactory.decodeResource(getResources(), R.drawable.sevenball);
    Bitmap bitmapb8 = BitmapFactory.decodeResource(getResources(), R.drawable.eightball);
    Bitmap bitmapb9 = BitmapFactory.decodeResource(getResources(), R.drawable.nineball);
    Bitmap bitmapb10 = BitmapFactory.decodeResource(getResources(), R.drawable.tenball);
    Bitmap bitmapb11 = BitmapFactory.decodeResource(getResources(), R.drawable.elevenball);
    Bitmap bitmapb12 = BitmapFactory.decodeResource(getResources(), R.drawable.twelveball);
    Bitmap bitmapb13 = BitmapFactory.decodeResource(getResources(), R.drawable.thirteenball);
    Bitmap bitmapb14 = BitmapFactory.decodeResource(getResources(), R.drawable.fourteenball);
    Bitmap bitmapb15 = BitmapFactory.decodeResource(getResources(), R.drawable.fifteenball);
    Bitmap bitmapbCue = BitmapFactory.decodeResource(getResources(), R.drawable.cueball);
    int w, h;

    public DrawView(Context context) {
        super(context);

        c = new Ball(bitmapbCue, 8, 500, h + 500);
        speedC = 0;
        angleC = 0;
        b1 = new Ball(bitmapb1, 8, w / 2, h);
        speed1 = 0;
        angle1 = 0;
        b2 = new Ball(bitmapb2, 8, w / 2 + 66, h);
        speed2 = 0;
        angle2 = 0;
        b3 = new Ball(bitmapb3, 8, w / 2 + 132, h);
        speed3 = 0;
        angle3 = 0;
        b4 = new Ball(bitmapb4, 8, w / 2 - 66, h);
        speed4 = 0;
        angle4 = 0;
        b5 = new Ball(bitmapb5, 8, w / 2 - 132, h);
        speed5 = 0;
        angle5 = 0;
        b6 = new Ball(bitmapb6, 8, w / 2 - 33, h + 66);
        speed6 = 0;
        angle6 = -0;
        b7 = new Ball(bitmapb7, 8, w / 2 + 33, h + 66);
        speed7 = 0;
        angle7 = 0;
        b8 = new Ball(bitmapb8, 8, w / 2 - 99, h + 66);
        speed8 = 0;
        angle8 = 0;
        b9 = new Ball(bitmapb9, 8, w / 2 + 99, h + 66);
        speed9 = 0;
        angle9 = 0;
        b10 = new Ball(bitmapb10, 8, w / 2, h + 132);
        speed10 = 0;
        angle10 = 0;
        b11 = new Ball(bitmapb11, 8, w / 2 - 66, h + 132);
        speed11 = 0;
        angle11 = 0;
        b12 = new Ball(bitmapb12, 8, w / 2 + 66, h + 132);
        speed12 = 0;
        angle12 = 0;
        b13 = new Ball(bitmapb13, 8, w / 2 - 33, h + 198);
        speed13 = 0;
        angle13 = 0;
        b14 = new Ball(bitmapb14, 8, w / 2 + 33, h + 198);
        speed14 = 0;
        angle14 = 0;
        b15 = new Ball(bitmapb15, 8, w / 2, h + 198 + 66);
        speed15 = 0;
        angle15 = 0;
        b1.setSpeed(speed1);
        b1.setAngle(angle1);
        b2.setSpeed(speed2);
        b2.setAngle(angle2);
        b3.setSpeed(speed3);
        b3.setAngle(angle3);
        b4.setSpeed(speed4);
        b4.setAngle(angle4);
        b5.setSpeed(speed5);
        b5.setAngle(angle5);
        b6.setSpeed(speed6);
        b6.setAngle(angle6);
        b7.setSpeed(speed7);
        b7.setAngle(angle7);
        b8.setSpeed(speed8);
        b8.setAngle(angle8);
        b9.setSpeed(speed9);
        b9.setAngle(angle9);
        b10.setSpeed(speed10);
        b10.setAngle(angle10);
        b11.setSpeed(speed11);
        b11.setAngle(angle11);
        b12.setSpeed(speed12);
        b12.setAngle(angle12);
        b13.setSpeed(speed13);
        b13.setAngle(angle13);
        b14.setSpeed(speed14);
        b14.setAngle(angle14);
        b15.setSpeed(speed15);
        b15.setAngle(angle15);
        c.setSpeed(speedC);
        c.setAngle(angleC);
        balls.add(b1);
        balls.add(b2);
        balls.add(b3);
        balls.add(b4);
        balls.add(b5);
        balls.add(b6);
        balls.add(b7);
        balls.add(b8);
        balls.add(b9);
        balls.add(b10);
        balls.add(b11);
        balls.add(b12);
        balls.add(b13);
        balls.add(b14);
        balls.add(b15);
    }

    public ArrayList<Ball> changeBalls(ArrayList<Ball> balls) {
        ArrayList<Ball> newBalls = new ArrayList<>();
        int numBalls = (int) (Math.random() * (balls.size() - 3) + 3);
        for (int i = 0; i < numBalls; i++) {
            balls.get(i).setX(w * Math.random());
            balls.get(i).setY(h * Math.random());
            for (int j = 0; j < i; j++) {
                while (!isNotOverlap(balls.get(i), balls.get(j))) {
                    balls.get(i).setX(w * Math.random());
                    balls.get(i).setY(h * Math.random());
                }
            }
            newBalls.add(balls.get(i));
        }
        newBalls.add(c);
        return newBalls;
    }

    public boolean isNotOverlap(Ball b1, Ball b2) {
        if (b1.isColBallCheck(b2))
            return false;
        return true;
    }

    public void drawLine(Canvas canvas, float x, float y) {
        Paint p = new Paint();
        p.setColor(BLUE);
        p.setStrokeWidth(5.0f);
        canvas.drawLine((float) c.getX() + BALL_RADIUS, (float) c.getY() + BALL_RADIUS, x, y, p);

    }

    boolean created = false;
    ArrayList<Ball> bArray = new ArrayList<>();
    float touchx, touchy;

    @Override
    protected void onDraw(Canvas canvas) {
        w = canvas.getWidth();
        h = canvas.getHeight();
        if (created == false) {
            bArray = changeBalls(balls);
            created = true;

        }
        super.onDraw(canvas);

        ticks--;
        if (ticks < 0) {
            for (Ball b : bArray)
                b.changeSpeed();
        }
        for (int i = 0; i < bArray.size() - 1; i++) {
            for (int i1 = i + 1; i1 < bArray.size(); i1++) {
                bArray.get(i).isCollideBall(bArray.get(i1));
            }
        }
        drawLine(canvas, touchx, touchy);
        for (Ball b : bArray) {
            b.draw(canvas);
            b.update();
        }

        invalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        double angle, speed;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchx = event.getX();
                touchy = event.getY();
                break;

            case MotionEvent.ACTION_UP:
                speed = Calculate.distance(c.getX(), c.getY(), touchx, touchy) / 7;
                angle = 180 + (float) Math.toDegrees(Math.atan2(c.getY() - touchy, c.getX() - touchx));
                c.setAngle(angle);
                c.setSpeed(speed);
                touchx = (float) c.getX();
                touchy = (float) c.getY();
                break;
            case MotionEvent.ACTION_CANCEL:

        }
        return true;

    }

}
