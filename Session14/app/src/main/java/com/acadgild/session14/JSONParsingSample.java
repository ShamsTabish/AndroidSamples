package com.acadgild.session14;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class JSONParsingSample extends AppCompatActivity {
    TextView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonparsing_sample);
        dataView = (TextView) findViewById(R.id.dataFromSite);
        dataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo info = connectivityManager.getActiveNetworkInfo();
                if (info != null && info.isConnectedOrConnecting()) {

                    JsonLoadAndParseInBackground connectToServer = new JsonLoadAndParseInBackground();
                    connectToServer.execute();
                } else
                    Toast.makeText(JSONParsingSample.this, "Please connect to internet.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String connectAndLoad() {
        StringBuffer dataFromServer = new StringBuffer();
     /*   try {
            URL jsonAPI_URL = new URL("https://jsonplaceholder.typicode.com/todos");
            HttpURLConnection myConnection = (HttpURLConnection) jsonAPI_URL.openConnection();
            InputStream myJsonStream = myConnection.getInputStream();

            int oneByte = 0;
            while ((oneByte = myJsonStream.read()) > 0) {
                dataFromServer.append((char) oneByte);
            }
            myJsonStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */


        OkHttpClient okClient=new OkHttpClient();
        Request okRequest=new Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/todos")
                    .build();

        try {
            Response okResponse=okClient.newCall(okRequest).execute();


            ResponseBody body=okResponse.body();
            InputStream stream =body.byteStream();
            int data=0;
            while ((data=stream.read())>0){
                dataFromServer.append((char)data);
            }

//            dataFromServer.append(okResponse.body().toString());
            stream.close();
            body.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFromServer.toString();
    }

    class JsonLoadAndParseInBackground extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            String dataFromServer = connectAndLoad();
            return dataFromServer;
        }

        @Override
        protected void onPostExecute(String resultFromServer) {
            super.onPostExecute(resultFromServer);
            StringBuffer buffer = new StringBuffer();
            try {
                JSONArray userArray = new JSONArray(resultFromServer);

                int length = userArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jsonUserObject = userArray.getJSONObject(i);
                    buffer.append(parseSingleUserObject(jsonUserObject));
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            dataView.setText("OK HTTP Library \n\n-----------------\n\n"+buffer.toString());
//            dataView.setText("OK HTTP Library \n\n-----------------\n\n"+resultFromServer);
        }
    }


    String parseSingleUserObject(JSONObject userObject) throws JSONException {
        StringBuffer objectString = new StringBuffer();
        objectString.append("\n\n===" + userObject.get("id"));
        objectString.append("\n" + userObject.get("title"));
        return objectString.toString();
    }

}
