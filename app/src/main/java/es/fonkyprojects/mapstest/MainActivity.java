package es.fonkyprojects.mapstest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText loc;
    EditText lon;
    EditText lat;

    public static final int MAP_ACTIVITY = 0;
    public static final String MAPLOC = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loc = (EditText) findViewById(R.id.locName);
        lon = (EditText) findViewById(R.id.longitud);
        lat = (EditText) findViewById(R.id.latitud);

        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivityForResult(intent, MAP_ACTIVITY);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MAP_ACTIVITY){ // If it was an ADD_ITEM, then add the new item and update the list
            if(resultCode == Activity.RESULT_OK){
                Bundle MBuddle = data.getExtras();
                MapLocation ml = (MapLocation) MBuddle .getSerializable(MAPLOC);
                Log.i("ENTRAMOS EN RESULT", ml.getAddress());
                if (ml != null) {
                    loc.setText(ml.getAddress());
                    lon.setText(String.valueOf(ml.getLongitude()));
                    lat.setText(String.valueOf(ml.getLatitude()));
                }

            }
        }
    }
}
