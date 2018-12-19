package my.com.edu.tarc.lab3_3inputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Currency;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale,radioButtonFemale;
    private CheckBox checkboxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find id
        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        checkboxSmoker =findViewById(R.id.checkBoxSmoker);
        textViewPremium = findViewById(R.id.textViewPremium);
        //Assign array to spinnerAge
        //create adapter to assign to spinnerAge
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this,
                        R.array.age_group, //Where the array come from
                        android.R.layout.simple_spinner_item);
        // display the dropdown item
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //set adapter to spinnerAge
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this); // request callback method
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Show message in ArrayAge
        Toast.makeText(this,"Position="+ position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int position;
        double premium = 0.0;
        position = spinnerAge.getSelectedItemPosition();
        switch(position){
            case 0:
                //TODO calculate the basic premium
                premium = 50;
                break;
            case 1:
                premium = 55;
                break;
            case 2:
                premium = 60;
                break;
            case 3:
                premium = 70;
                break;
            case 4:
                premium =120;
                break;
            case 5:
                premium = 160;
                break;
            case 6:
                premium = 200;
                break;
            case 7:
                premium = 250;
                break;
        }
        //return id
        int gender;
        gender = radioGroupGender.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale){
            //TODO calculate extra premium for male
            switch(position){
                case 2:
                    premium +=50;
                    break;
                case 3:
                    premium +=100;
                    break;
                case 4:
                    premium +=100;
                    break;
                case 5:
                    premium +=50;
                    break;
            }
        }
        //return true/false
        if(checkboxSmoker.isChecked()){
            //TODO calculate extra premium for smoker
            switch(position){
                case 3:
                    premium +=100;
                    break;
                case 4:
                    premium +=150;
                    break;
                case 5:
                    premium +=150;
                    break;
                case 6:
                    premium +=250;
                    break;
                case 7:
                    premium +=250;
                    break;
            }
        }

        textViewPremium.setText(getString(R.string.premium) + " " + premium);
    }
}
