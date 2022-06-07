package com.project.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mainValue = 0, backValue = 0;
    TextView mainText, backText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = findViewById(R.id.mainvalue);
        backText = findViewById(R.id.backvalue);

        BackRunnable runnable = new BackRunnable();
        Thread thread = new Thread(runnable);

        //BackThread thread = new BackThread();  // 작업스레드 생성
        thread.setDaemon(true);
        thread.start();
    }

    public void mOnClick(View v) {
        mainValue++;
        mainText.setText("메인스레드 값: " + mainValue);
        backText.setText("작업스레드 값: " + backValue);
    }

    class BackThread extends Thread {
        @Override
        public void run() {
            while (true) {
                backValue++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class BackRunnable implements Runnable {
        @Override
        public void run() {
            while(true) {
                backValue++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}