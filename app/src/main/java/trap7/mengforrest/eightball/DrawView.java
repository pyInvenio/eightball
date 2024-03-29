package trap7.mengforrest.eightball;

import android.bluetooth.BluetoothA2dp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

class DrawView extends View {
    Ball b8, b1, b2, b3, b4, b5, b6, b7, b9, b10, b11, b12, b13, b14, b15;
    Ball c;
    static final int BALL_RADIUS = 30;
    Gutter gutter1, gutter2, gutter3, gutter4, gutter5, gutter6;
    boolean drawLine;
    int score = 0;
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
    Bitmap bitmapGutter = BitmapFactory.decodeResource(getResources(), R.drawable.gutter);
    int w, h;
    SharedPreferences.Editor editor;
    SharedPreferences pref;
    ArrayList<Gutter> gutterArray = new ArrayList<>();

    public DrawView(Context context) {

        super(context);
        pref = PreferenceManager.getDefaultSharedPreferences(this.getContext());

        w = context.getResources().getDisplayMetrics().widthPixels;
        h = context.getResources().getDisplayMetrics().heightPixels;
        gutter1 = new Gutter(bitmapGutter, 0, 0);
        gutter2 = new Gutter(bitmapGutter, w, 0);
        gutter3 = new Gutter(bitmapGutter, 0, h);
        gutter4 = new Gutter(bitmapGutter, w, h);
        gutter5 = new Gutter(bitmapGutter, 0, h / 2);
        gutter6 = new Gutter(bitmapGutter, w, h / 2);
        c = new Ball(bitmapbCue, 0, 500, 500);
        speedC = 0;
        angleC = 0;
        b1 = new Ball(bitmapb1, 1, w / 2, h);
        speed1 = 0;
        angle1 = 0;
        b2 = new Ball(bitmapb2, 2, w / 2 + 66, h);
        speed2 = 0;
        angle2 = 0;
        b3 = new Ball(bitmapb3, 3, w / 2 + 132, h);
        speed3 = 0;
        angle3 = 0;
        b4 = new Ball(bitmapb4, 4, w / 2 - 66, h);
        speed4 = 0;
        angle4 = 0;
        b5 = new Ball(bitmapb5, 5, w / 2 - 132, h);
        speed5 = 0;
        angle5 = 0;
        b6 = new Ball(bitmapb6, 6, w / 2 - 33, h + 66);
        speed6 = 0;
        angle6 = -0;
        b7 = new Ball(bitmapb7, 7, w / 2 + 33, h + 66);
        speed7 = 0;
        angle7 = 0;
        b8 = new Ball(bitmapb8, 8, w / 2 - 99, h + 66);
        speed8 = 0;
        angle8 = 0;
        b9 = new Ball(bitmapb9, 9, w / 2 + 99, h + 66);
        speed9 = 0;
        angle9 = 0;
        b10 = new Ball(bitmapb10, 10, w / 2, h + 132);
        speed10 = 0;
        angle10 = 0;
        b11 = new Ball(bitmapb11, 11, w / 2 - 66, h + 132);
        speed11 = 0;
        angle11 = 0;
        b12 = new Ball(bitmapb12, 12, w / 2 + 66, h + 132);
        speed12 = 0;
        angle12 = 0;
        b13 = new Ball(bitmapb13, 13, w / 2 - 33, h + 198);
        speed13 = 0;
        angle13 = 0;
        b14 = new Ball(bitmapb14, 14, w / 2 + 33, h + 198);
        speed14 = 0;
        angle14 = 0;
        b15 = new Ball(bitmapb15, 15, w / 2, h + 198 + 66);
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

        Ball.cWidth = context.getResources().getDisplayMetrics().widthPixels;
        // By default, the height of title bar is 72dp and the height for status bar is 24dp
        Ball.cHeight = context.getResources().getDisplayMetrics().heightPixels;
        gutterArray.add(gutter1);
        gutterArray.add(gutter2);
        gutterArray.add(gutter3);
        gutterArray.add(gutter4);
        gutterArray.add(gutter5);
        gutterArray.add(gutter6);
    }

    public void drawScore(Canvas canvas) {
        Paint paint = new Paint();
        // canvas.drawPaint(paint);
        paint.setColor(getResources().getColor(R.color.darkerGreen));
        paint.setTextSize(100);
        canvas.drawText("Moves:\n" + score + "", w / 2 - 200, h / 2 - 50, paint);
    }
    public ArrayList<Ball> changeBalls(ArrayList<Ball> balls) {
        ArrayList<Ball> newBalls = new ArrayList<>();

        int numBalls = (int) (Math.random() * (balls.size() - 3) + 3);
        for (int i = 0; i < numBalls + 1; i++) {
            double x = w * Math.random();
            double y = h * Math.random();
            while (x < 40 || x > w - 40)
                x = w * Math.random();
            while (y < 40 || y > w - 40)
                y = w * Math.random();

            balls.get(i).setX(x);
            balls.get(i).setY(y);

            for (int j = 0; j < i; j++) {
                while (!isNotOverlap(balls.get(i), balls.get(j))) {
                    balls.get(i).setX(w * Math.random());
                    balls.get(i).setY(h * Math.random());
                    balls.get(i).setSpeed(0);
                    balls.get(i).setSpeedy(0);
                    balls.get(i).setSpeedy(0);
                }
            }
            newBalls.add(balls.get(i));
        }

        double x = w * Math.random();
        double y = h * Math.random();
        while (x < 40 || x > w - 40)
            x = w * Math.random();
        while (y < 40 || y > w - 40)
            y = w * Math.random();
        c.setSpeed(0);
        c.setX(x);
        c.setY(y);
        newBalls.add(c);
        return newBalls;
    }

    public boolean isNotOverlap(Ball b1, Ball b2) {
        if (b1.isColBallCheck(b2))
            return false;
        return true;
    }

    public void drawLine(Canvas canvas, float x, float y, int color) {
        Paint p = new Paint();
        p.setColor(color);
        p.setStrokeWidth(5.0f);
        canvas.drawLine((float) c.getX(), (float) c.getY(), x, y, p);

    }

    boolean created = false;
    ArrayList<Ball> bArray = new ArrayList<>();
    float touchx, touchy;

    @Override
    protected void onDraw(Canvas canvas) {
        boolean moving = false;
        canvas.drawColor(getResources().getColor(R.color.darkGreen));
        drawScore(canvas);

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
        ArrayList<Integer> ballsToRemove = new ArrayList<>();
        for (int i = 0; i < bArray.size(); i++) {
            for (Gutter g : gutterArray) {
                if (g.ballisGutted(bArray.get(i))) {
                    if (bArray.get(i).getNumber() != 0) {
                        if (bArray.size() - 1 == 1) {

                            editPrefs();
                            Intent sendIntent = new Intent(this.getContext(), MainActivity.class);
                            this.getContext().startActivity(sendIntent);
                            Toast.makeText(super.getContext(), "Ball " + bArray.get(i).getNumber() + " potted! You Win!", Toast.LENGTH_SHORT).show();

                            break;
                        } else
                            Toast.makeText(super.getContext(), "Ball " + bArray.get(i).getNumber() + " potted!", Toast.LENGTH_SHORT).show();
                    } else {

                        Intent sendIntent = new Intent(this.getContext(), MainActivity.class);
                        this.getContext().startActivity(sendIntent);
                        Toast.makeText(super.getContext(), "You potted the cue ball!", Toast.LENGTH_SHORT).show();
                        score = 0;
                        created = false;

                        break;
                    }
                    ballsToRemove.add(i);
                }
            }
        }
        for (int i : ballsToRemove) {
            bArray.get(i).setSpeed(0);
            bArray.remove(i);
        }

        for (Ball b : bArray)
            if (b.getSpeed() > 0.06)
                moving = true;
        if (drawLine) {
            drawLine(canvas, touchx, touchy, !moving ? getResources().getColor(R.color.blueLine) : RED);

        }
        for (Gutter g : gutterArray)
            g.draw(canvas);
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
                drawLine = true;
                touchx = event.getX();
                touchy = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                touchx = event.getX();
                touchy = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                drawLine = false;
                boolean moving = false;
                for (Ball b : bArray)
                    if (b.getSpeed() > 0.06)
                        moving = true;
                if (moving)
                    break;
                speed = Calculate.distance(c.getX(), c.getY(), touchx, touchy) / 20;
                //angle = 180 + (float) Math.toDegrees(Math.atan2(c.getY() - touchy, c.getX() - touchx));
                angle = (float) Math.toDegrees(Math.atan2(touchy - c.getY(), touchx - c.getX()));
                c.setAngle(angle);
                c.setSpeed(speed);
                touchx = (float) c.getX();
                touchy = (float) c.getY();
                score++;
                break;
            case MotionEvent.ACTION_CANCEL:

        }
        return true;

    }

    public void editPrefs() {

        editor = pref.edit();
        if (pref.getInt("highscore", -1) == 0)
            editor.putInt("highscore", score);
        else if (score < pref.getInt("highscore", -1))
            editor.putInt("highscore", score);
        editor.apply();
    }

}
