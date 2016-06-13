package domain.company.simpleui.simpleui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    RadioGroup radioGroup;
    CheckBox checkBox;

    String drinkName = "Black Tea";
    ListView listView ;
    ArrayList<Order> orders = new ArrayList<>();

    Spinner storeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        listView = (ListView) findViewById(R.id.listView);
        storeSpinner = (Spinner) findViewById(R.id.spinner);

        setupListView();
        setupSpinner();

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN)
                {
                    click(view);
                    return true;
                }
                return false;
            }
        });

        Log.d("Debug","Main Activity OnCreate");
      }

    public void setupListView()
    {
        OrderAdapter adapter = new OrderAdapter(this, orders);
        listView.setAdapter(adapter);
    }

    public void click(View view)
    {
       String note = editText.getText().toString();

        Order order = new Order();
        order.note = note;
        order.drinkName = drinkName;
        order.storeInfo = (String) storeSpinner.getSelectedItem();
        orders.add(order);

        textView.setText(drinkName);
        editText.setText("");
        setupListView();
    }

    public void setupSpinner()
    {
        String[] data = getResources().getStringArray(R.array.storeInfo);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        storeSpinner.setAdapter(adapter);
    }

    public void goToMenu(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this, DrinkMenuActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("Deubg","Main Activity OnStart");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("Deubg","Main Activity OnPause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("Deubg","Main Activity OnResume");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("Deubg","Main Activity OnStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("Deubg","Main Activity OnDestroy");
    }

}
