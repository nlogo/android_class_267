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
import android.widget.TextView;

import java.util.ArrayList;

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
    ArrayList<String> drinks = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        listView = (ListView) findViewById(R.id.listView);

        setupListView();

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
        String[] data = new String[]{"123", "456", "789", "Hello", "ListView", "Hi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drinks);
        listView.setAdapter(adapter);
    }

    public void click(View view)
    {
       String note = editText.getText().toString();

        //sex = selectedSex ;
        //changeTextView();
        drinks.add(drinkName);

        textView.setText(drinkName);
        editText.setText("");
        setupListView();
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
