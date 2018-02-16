package com.example.android.quizanbd;


import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkResults(View v) {
       checkQuestionOne();
       checkQuestionTwo();
       checkQuestionThree();
    }

    public void resetScore(View v) {
       score = 0;
    }


    private void checkQuestionOne() {
        EditText editText = (EditText)findViewById(R.id.questionOneAnswer);
        String answer = editText.getText().toString().toLowerCase().trim();
        if (TextUtils.equals(answer, "green")) {
            score++;
        }
    }

    private void checkQuestionTwo() {
        CheckBox checkboxOne = (CheckBox) findViewById(R.id.checkboxOne);
        CheckBox checkboxTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        CheckBox checkboxThree = (CheckBox) findViewById(R.id.checkboxThree);
        CheckBox checkboxFour = (CheckBox) findViewById(R.id.checkboxFour);
        CheckBox checkboxFive = (CheckBox) findViewById(R.id.checkboxFive);

        if (checkboxOne.isChecked()&&checkboxTwo.isChecked()&&!checkboxThree.isChecked()
               &&!checkboxFour.isChecked()&&!checkboxFive.isChecked()) {
            score++;
        }

    }

    private void checkQuestionThree() {
        RadioButton radioButtonYes = (RadioButton)findViewById(R.id.radioButtonYes);
        if (radioButtonYes.isChecked()){
            score++;
            Toast.makeText(this, "Right! score: " + score, Toast.LENGTH_SHORT).show();
        }
    }


}
