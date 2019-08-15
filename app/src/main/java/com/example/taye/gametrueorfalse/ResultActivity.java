package com.example.taye.gametrueorfalse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class ResultActivity extends AppCompatActivity {

    TextView grade, finalScores;
    Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        grade = (TextView)findViewById(R.id.grade);
        finalScores = (TextView)findViewById(R.id.outOf);
        retryButton = (Button)findViewById(R.id.retry);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        finalScores.setText("You scored " + score + " out of " + QuizBook.questions.length);

if (score == 9) {
    grade.setText("Outstanding");
}
        else if (score == 8) {
            grade.setText("Good Work");
        }
        else if (score == 7) {
         grade.setText("Good Effort");
        }
        else {
            grade.setText("Go over your notes");
        }

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, QuizModel.class);
                startActivity(intent);
                ResultActivity.this.finish();
            }
        });

        Gson gSon = new Gson();

    }
}
