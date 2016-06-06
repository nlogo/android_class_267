package domain.company.simpleui.simpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    //String selectedSex = "Male";
    //String name = "";
    //String sex = "";

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

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //if(i == R.id.Rmale)
                //{
                    //selectedSex = "Male";

                //}else if(i == R.id.Rfemale){
                    //selectedSex = "Female";
                //}

                //sex = selectedSex;
                RadioButton radioButton = (RadioButton) findViewById(i);
                drinkName = radioButton.getText().toString();
            }
        });

//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
//                changeTextView();
//            }
//        });
      }

    public void setupListView()
    {
//        String[] data = new String[]{"123", "456", "789", "Hello", "ListView", "Hi"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drinks);

//        List<Map<String, String>> data = new ArrayList<>();
//
//        for(int i = 0; i < orders.size(); i++)
//        {
//            Order order = orders.get(i);
//            Map<String, String> item = new HashMap<>();
//
//            item.put("note", order.note);
//            item.put("drinkName", order.drinkName);
//
//            data.add(item);
//        }
//
//        String[] from = {"note", "drinkName"};
//        int[] to = {R.id.noteTextView, R.id.drinkNameTextView};
//
//        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.listview_order_item, from, to);

        OrderAdapter adapter = new OrderAdapter(this, orders);
        listView.setAdapter(adapter);
    }

    public void click(View view)
    {
       String note = editText.getText().toString();

        //sex = selectedSex ;
        //changeTextView();

        Order order = new Order();
        order.note = note;
        order.drinkName = drinkName;
        orders.add(order);

        //drinks.add(drinkName);

        textView.setText(drinkName);
        editText.setText("");
        setupListView();
    }

    public void setupSpinner()
    {
        String[] data = getResources().getStringArray(R.array.storeInfo);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        storeSpinner.setAdapter(adapter);
    }

//    public void changeTextView()
//    {
//        if ( name.equals(""))
//            return ;
//        if(checkBox.isChecked()){
//            textView.setText(name);
//        }
//        else{
//            String content = name + " sex:" + sex;
//            textView.setText(content);
//        }
//    }
}
