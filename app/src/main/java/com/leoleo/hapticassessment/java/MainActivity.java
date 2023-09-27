package com.leoleo.hapticassessment.java;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final long ONE_SHOT_TIMING = 20L;
    private static final int ONE_SHOT_AMPLITUDE = 255;
    private static final long[] WAVEFORM_TIMINGS = new long[]{500, 500};
    private static final int[] WAVEFORM_AMPLITUDES = new int[]{128, 255};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Vibrator vibrator = getSystemService(Vibrator.class);
        findViewById(R.id.click_effect_button).setOnClickListener(v -> vibrator.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK)));

        findViewById(R.id.oneshot_effect_button).setOnClickListener(v -> vibrator.vibrate(VibrationEffect.createOneShot(ONE_SHOT_TIMING, ONE_SHOT_AMPLITUDE)));

        final Button waveformEffectButton = findViewById(R.id.waveform_effect_button);
        waveformEffectButton.setOnClickListener(v -> {
            vibrator.vibrate(VibrationEffect.createWaveform(WAVEFORM_TIMINGS, WAVEFORM_AMPLITUDES, -1));

            if (vibrator.hasAmplitudeControl()) {
                waveformEffectButton.setText(getString(R.string.button_3_pass));
                waveformEffectButton.setBackgroundColor(Color.GREEN);
                waveformEffectButton.setTextColor(Color.BLACK);
            } else {
                waveformEffectButton.setText(getString(R.string.button_3_fail));
                waveformEffectButton.setBackgroundColor(Color.RED);
                waveformEffectButton.setTextColor(Color.WHITE);
            }
        });
    }
}