package domain.company.simpleui.simpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DrinkMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu);

        Log.d("Deubg","Drink Activity OnCreate");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("Deubg","Drink Activity OnStart");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("Deubg","Drink Activity OnPause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("Deubg","Drink Activity OnResume");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("Deubg","Drink Activity OnStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("Deubg","Drink Activity OnDestroy");
    }
}
