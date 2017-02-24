package com.uqtr.nguyeale.asynctaskexercice;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button launchButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchButton = (Button) findViewById(R.id.buttonLaunch);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.textView);
        launchButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ShowTextTask task = new ShowTextTask();
                task.execute();
            }
        });
    }

    private class ShowTextTask extends AsyncTask<Void, Void, Void> {

        protected Void doInBackground(Void...arg){
            try {
                Thread.currentThread();
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onProgressUpdate(Integer... progress) {
            progressBar.setProgress(progress[0]);
        }

        protected void onPostExecute(Void... arg) {
            textView.setText("Finished AsyncTask");
        }
    }

}
