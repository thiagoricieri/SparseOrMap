package pluto.sparseormap;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SparseArray<String> myChannels;
    ArrayMap<Integer, String> myChannelsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v) {
        long ct = System.currentTimeMillis();
        myChannelsMap = parseStringArray2(this, R.array.channels_and_logos);
        Log.d("PlutoArray", "Millis to create res ArrayMap " + (System.currentTimeMillis() - ct));
        ct = System.currentTimeMillis();
        myChannels = parseStringArray(this, R.array.channels_and_logos);
        Log.d("PlutoArray", "Millis to create res Sparse " + (System.currentTimeMillis() - ct));
        Log.d("PlutoArray", "----");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static SparseArray<String> parseStringArray(Context context, int stringArrayResourceId) {
        String[] stringArray = context.getResources().getStringArray(stringArrayResourceId);
        SparseArray<String> outputArray = new SparseArray<>();
        for (String entry : stringArray) {
            String[] splitResult = entry.split("\\|", 2);
            outputArray.put(Integer.valueOf(splitResult[0]), splitResult[1]);
        }
//        for (int i = 0; i < 100000; i++) {
//            outputArray.put(i, "Pluto Array");
//        }
        return outputArray;
    }

    public static ArrayMap<Integer, String> parseStringArray2(Context context, int stringArrayResourceId) {
        String[] stringArray = context.getResources().getStringArray(stringArrayResourceId);
        ArrayMap<Integer, String> outputArray = new ArrayMap<>();
        for (String entry : stringArray) {
            String[] splitResult = entry.split("\\|", 2);
            outputArray.put(Integer.valueOf(splitResult[0]), splitResult[1]);
        }
//        for (int i = 0; i < 100000; i++) {
//            outputArray.put(i, "Pluto Array");
//        }
        return outputArray;
    }
}
