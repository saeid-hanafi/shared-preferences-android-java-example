package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private UserSharedInformation userInfo;
    private String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInfo = new UserSharedInformation(this);

        TextInputEditText fullNameEt = findViewById(R.id.et_fullName);
        fullNameEt.setText(userInfo.getFullName());

        TextInputEditText mailEt = findViewById(R.id.et_emailAddress);
        mailEt.setText(userInfo.getUserMail());

        RadioGroup radioGroup = findViewById(R.id.gender_rg_main);
        View saveBtn = findViewById(R.id.save_info_main);
        View removeBtn = findViewById(R.id.remove_all_shared_preferences);

        gender = userInfo.getUserGender();
        if (gender.equalsIgnoreCase("Male")) {
            radioGroup.check(R.id.gender_radio_male);
        }else if (gender.equalsIgnoreCase("Female")){
            radioGroup.check(R.id.gender_radio_female);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.gender_radio_male) {
                    gender = "Male";
                }else if (checkedId == R.id.gender_radio_female) {
                    gender = "Female";
                }else{
                    gender = "";
                }
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo.saveInfo(fullNameEt.getText().toString(),
                        mailEt.getText().toString(),
                        gender);
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo.clearAll();
                finish();
                startActivity(getIntent());
            }
        });
    }
}