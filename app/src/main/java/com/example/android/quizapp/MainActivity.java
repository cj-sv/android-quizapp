package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int correctAnswers = 0;
    public int wrongAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Submit Quiz
    public void submitQuiz(View view) {

        isQuestionOneEmpty();
        editTextQuestionTwo();
        checkboxQuestionThree();
        isQuestionFourEmpty();

        Toast.makeText(this,
                "Quiz submitted!" +
                "\nCorrect Answers: " + correctAnswers +
                "\nWrong Answers: " + wrongAnswers,
                Toast.LENGTH_LONG).show();

        clearQuiz();
    }

    public void clearQuiz() {
        correctAnswers = 0;
        wrongAnswers = 0;

        RadioGroup radioQuestOne = findViewById(R.id.radio_group_quest_one);
        radioQuestOne.clearCheck();

        EditText editQuestTwo = findViewById(R.id.text_box_quest_two);
        editQuestTwo.setText("");

        CheckBox checkboxUbuntu = findViewById(R.id.checkbox_ubuntu);
        checkboxUbuntu.setChecked(false);
        CheckBox checkboxMint = findViewById(R.id.checkbox_mint);
        checkboxMint.setChecked(false);
        CheckBox checkboxAntergos = findViewById(R.id.checkbox_antergos);
        checkboxAntergos.setChecked(false);
        CheckBox checkboxSolus  = findViewById(R.id.checkbox_solus);
        checkboxAntergos.setChecked(false);
        CheckBox checkboxSteam = findViewById(R.id.checkbox_steam);
        checkboxSteam.setChecked(false);

        RadioGroup radioQuestFour = findViewById(R.id.radio_group_quest_four);
        radioQuestFour.clearCheck();
    }

    public void addCorrectPoint() {
        correctAnswers = correctAnswers + 1;
    }

    public void addWrongPoint() {
        wrongAnswers = wrongAnswers + 1;
    }

    public void onRadioQuestionOne (View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ken_thompson:
                if (checked)
                    addWrongPoint();
                break;

            case R.id.dennis_ritchie:
                if (checked)
                    addWrongPoint();
                break;

            case R.id.linus_torvalds:
                if (checked)
                    addCorrectPoint();
                break;
        }
    }

    public void isQuestionOneEmpty() {
        RadioGroup radioQuestOne = findViewById(R.id.radio_group_quest_one);
        if (radioQuestOne.getCheckedRadioButtonId() == -1) {
            addWrongPoint();
        }
    }

    public void isQuestionFourEmpty() {
        RadioGroup radioQuestFour = findViewById(R.id.radio_group_quest_four);
        if (radioQuestFour.getCheckedRadioButtonId() == -1) {
            addWrongPoint();
        }
    }

    public void editTextQuestionTwo() {
        EditText editQuestTwo = findViewById(R.id.text_box_quest_two);
        String questTwoAnswer = editQuestTwo.getText().toString();
        if (questTwoAnswer.equalsIgnoreCase("tux")) {
            addCorrectPoint();
        } else {
            addWrongPoint();
        }
    }

    public void checkboxQuestionThree() {
        CheckBox checkboxUbuntu = findViewById(R.id.checkbox_ubuntu);
        boolean isUbuntu = checkboxUbuntu.isChecked();

        CheckBox checkboxMint = findViewById(R.id.checkbox_mint);
        boolean isMint = checkboxMint.isChecked();

        CheckBox checkboxAntergos = findViewById(R.id.checkbox_antergos);
        boolean isAntergos = checkboxAntergos.isChecked();

        CheckBox checkboxSolus  = findViewById(R.id.checkbox_solus);
        boolean isSolus = checkboxSolus.isChecked();

        CheckBox checkboxSteam = findViewById(R.id.checkbox_steam);
        boolean isSteam = checkboxSteam.isChecked();

        if (isUbuntu && isMint && isSteam && !isSolus && !isAntergos){
            addCorrectPoint();
        } else {
            addWrongPoint();
        }
    }

    public void onRadioQuestionFour (View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.circle_of_friends:
                if (checked)
                    addCorrectPoint();
                break;

            case R.id.unity:
                if (checked)
                    addWrongPoint();
                break;
        }
    }
}
