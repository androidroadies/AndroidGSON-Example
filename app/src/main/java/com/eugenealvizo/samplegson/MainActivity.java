package com.eugenealvizo.samplegson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private final static String JSON_FILE_ANDROID_WEAR = "androidwear.json";
    private final static String TAG = "MainActivity";

    private WatchAdapter watchAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        listView = (ListView) findViewById(R.id.listView);
        watchAdapter = new WatchAdapter(MainActivity.this, getWatchesData());
        listView.setAdapter(watchAdapter);
    }

    /* Convert JSON String to BaseWatch Model via GSON */
    public List<Watch> getWatchesData() {
        String jsonString = getAssetsJSON(JSON_FILE_ANDROID_WEAR);
        Log.d(TAG, "Json: " + jsonString);
        Gson gson = new Gson();
        BaseWatch baseWatch = gson.fromJson(jsonString, BaseWatch.class);
        return  baseWatch.getWatches();
    }

    /* Get File in Assets Folder */
    public String getAssetsJSON(String fileName) {
        String json = null;
        try {
            InputStream inputStream = this.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}
