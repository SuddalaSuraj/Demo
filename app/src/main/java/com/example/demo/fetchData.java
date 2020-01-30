package com.example.demo;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    String link = "https://api.github.com/search/users?q=user:";
    String search = MainActivity.key;
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("link+search");
            HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();
            InputStream inputstream = httpurlconnection.getInputStream();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
            String line="";
            while(line != null){
                line = bufferedreader.readLine();
                data = data + line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        MainActivity.button.setText("Search Again");
        if(data == "")
        {
            MainActivity.text.setText("User Not Found");
        }
        else
        {
            MainActivity.text.setText(this.data);
        }
    }
}
