package com.example.footballgame.testlongclick;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import com.example.footballgame.testlongclick.databinding.ActivityMainBinding;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    int count = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.testBtn.setOnTouchListener((view, motionEvent) -> {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        timer.start();
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        timer.cancel();
                    }

                    return false;
                }
        );

        binding.testBtn.setOnClickListener(view -> {
            updateCount();
        });
    }

    private final CountDownTimer timer = new CountDownTimer(100, 100) {
        @Override
        public void onTick(long l) {
            updateCount();
        }

        @Override
        public void onFinish() {
            this.start();
        }
    };

    private void updateCount() {
        count++;
        binding.textTest.setText(String.valueOf(count));
    }
}