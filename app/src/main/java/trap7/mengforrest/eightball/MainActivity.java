package trap7.mengforrest.eightball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView cueStick;
    final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            //  | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            //  | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    Button startBtn, helpBtn;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    TextView highScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(flags);
        final View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                    decorView.setSystemUiVisibility(flags);
                }
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences(getString(R.string.shared_prefs), Context.MODE_PRIVATE);
        highScore = findViewById(R.id.highText);
        if (!pref.contains("highscore"))
            highScore.setText("Lowest Number of Moves: \n" + 0);
        else
            highScore.setText("Lowest Number of Moves: \n" + pref.getInt("highscore", -1));

        startBtn = findViewById(R.id.startBtn);
        helpBtn = findViewById(R.id.helpBtn);
        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(MainActivity.this, HelpActivity.class);
                MainActivity.this.startActivity(sendIntent);
            }
        });
    }

    public void start(View v) {
        setContentView(new DrawView(this));
    }

    protected void onPause() {
        super.onPause();
        editor = pref.edit();
        if (pref.contains("highscore") != true)
            editor.putInt("highscore", 0);
        editor.putBoolean("newhs", false);

        editor.apply();
    }

}
