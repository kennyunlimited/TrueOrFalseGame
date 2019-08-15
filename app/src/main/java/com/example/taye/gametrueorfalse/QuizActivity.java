package com.example.taye.gametrueorfalse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView scoreView, questionView;
    private ImageView imageView;
    private Button tButton, fButton;

    private boolean answer;
    private int score = 0;
    private int questionNo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        scoreView = (TextView) findViewById(R.id.pointsTextView);
        questionView = (TextView) findViewById(R.id.questionTextView);
        imageView = (ImageView) findViewById(R.id.imageView);
        tButton = (Button) findViewById(R.id.trueButton);
        fButton = (Button) findViewById(R.id.falseButton);

        updateQuestion();


        //Logic for True Button
        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer == true) {
                    score++;  //This updates the score int variable
                    updateScore(score); //Converts the int variable to String and adds it to ScoreView

                    //Perform this check before you update the question
                    if (questionNo == QuizBook.questions.length) {
                        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", score);
                        intent.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(intent);
                    }
                    else {
                        updateQuestion();
                    }
                }

                //If the user's answer is wrong

                else{
                    if (questionNo == QuizBook.questions.length) {
                        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", score);
                        intent.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(intent);
                    }
                    else {
                        updateQuestion();
                    }
                }

            }
        });

        //Logic for False Button

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer == false) {
                    score++;  //This updates the score int variable
                    updateScore(score); //Converts the int variable to String and adds it to ScoreView

                    //Perform this check before you update the question
                    if (questionNo == QuizBook.questions.length) {
                        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", score);
                        intent.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(intent);
                    }
                    else {
                        updateQuestion();
                    }
                }

                //If the answer is wrong

                else{
                    if (questionNo == QuizBook.questions.length) {
                        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", score);
                        intent.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(intent);
                    }
                    else {
                        updateQuestion();
                    }
                }

            }
        });


    }

    private void updateQuestion() {
        imageView.setImageResource(QuizBook.images[questionNo]);
        questionView.setText(QuizBook.questions[questionNo]);
        answer = QuizBook.answers[questionNo];
        questionNo++;
    }

    private void updateScore(int point) {
        scoreView.setText("" + score);
    }
}
