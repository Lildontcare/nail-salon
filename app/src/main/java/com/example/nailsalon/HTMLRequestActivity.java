package com.example.nailsalon;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTMLRequestActivity extends AppCompatActivity {

    private TextView textView;
    private Button buttonRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmlrequest);

        textView = findViewById(R.id.texthtml);
        buttonRequest = findViewById(R.id.buttonhtml);

        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetHttpResponseTask().execute("https://github.com/judit0310/peopleJSONServer.git");
            }
        });
    }

    private class GetHttpResponseTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setConnectTimeout(5000);
                urlConnection.setReadTimeout(5000);

                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                reader.close();
                urlConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                result = "An error occurred!";
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            textView.setText(result);
        }
    }
}
