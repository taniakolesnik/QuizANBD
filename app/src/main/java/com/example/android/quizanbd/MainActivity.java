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
    boolean alreadyAnswered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkResults(View v) {
        if (!alreadyAnswered) {
            checkQuestionOne();
            checkQuestionTwo();
            checkQuestionThree();
            checkQuestionFour();
            alreadyAnswered = true;
            switch (score){
                case 4:
                    Toast.makeText(this, "Well done! Score : " + score, Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(this, "Amost there! Score : " + score + ". Reset and try again!", Toast.LENGTH_SHORT).show();
                    break;
                default: Toast.makeText(this, "Score : " + score + ". Reset and try again!", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else {
            Toast.makeText(this, R.string.alreadyAnsweredMessage, Toast.LENGTH_LONG).show();
        }
    }

    public void resetScore(View v) {
        score = 0;
        alreadyAnswered = false;
    }

    private void checkQuestionOne() {
        EditText editText = (EditText) findViewById(R.id.questionOneAnswer);
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

        if (checkboxOne.isChecked() && checkboxTwo.isChecked() && !checkboxThree.isChecked()
                && !checkboxFour.isChecked() && !checkboxFive.isChecked()) {
            score++;
        }

    }

    private void checkQuestionThree() {
        RadioButton radioButtonYes = (RadioButton) findViewById(R.id.radioButtonYes);
        if (radioButtonYes.isChecked()) {
            score++;
        }
    }

    private void checkQuestionFour() {
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButtonOptionOne);
        if (radioButton.isChecked()) {
            score++;
        }
    }

}
