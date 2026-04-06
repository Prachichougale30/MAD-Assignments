package com.example.bars;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    ProgressBar hProgress, cProgress;
    SeekBar seekBar;
    EditText comment;
    Button btnSend;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        hProgress = findViewById(R.id.hProgress);
        cProgress = findViewById(R.id.cProgress);
        seekBar = findViewById(R.id.seekBar);
        comment = findViewById(R.id.comment);
        btnSend = findViewById(R.id.btnSend);
        result = findViewById(R.id.result);

        // ⭐ Rating Event
        ratingBar.setOnRatingBarChangeListener(
                (ratingBar, rating, fromUser) ->
                        hProgress.setProgress((int) rating)
        );

        // 🎚 SeekBar Event
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                        result.setText("Seek Value : " + progress);
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                });

        // ✅ Button Event
        btnSend.setOnClickListener(v -> {

            float rating = ratingBar.getRating();
            String text = comment.getText().toString();

            // show circular loading
            cProgress.setVisibility(View.VISIBLE);

            new Handler().postDelayed(() -> {
                cProgress.setVisibility(View.GONE);

                result.setText(
                        "Rating : " + rating +
                                "\nComment : " + text);

            },2000);
        });
    }
}
