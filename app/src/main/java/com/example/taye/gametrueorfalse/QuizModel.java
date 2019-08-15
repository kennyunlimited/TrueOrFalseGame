package com.example.taye.gametrueorfalse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by TAYE on 09/03/2017.
 */

public class QuizModel extends AppCompatActivity {

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
                        Intent intent = new Intent(QuizModel.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", score);
                        intent.putExtras(bundle);
                        QuizModel.this.finish();
                        startActivity(intent);
                    }
                    else {
                        updateQuestion();
                    }
                }

                //If the user's answer is wrong

                else{
                    if (questionNo == QuizBook.questions.length) {
                        Intent intent = new Intent(QuizModel.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", score);
                        intent.putExtras(bundle);
                        QuizModel.this.finish();
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
                        Intent intent = new Intent(QuizModel.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", score);
                        intent.putExtras(bundle);
                        QuizModel.this.finish();
                        startActivity(intent);
                    }
                    else {
                        updateQuestion();
                    }
                }

                //If the answer is wrong

                else{
                    if (questionNo == QuizBook.questions.length) {
                        Intent intent = new Intent(QuizModel.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", score);
                        intent.putExtras(bundle);
                        QuizModel.this.finish();
                        startActivity(intent);
                    }
                    else {
                        updateQuestion();
                    }
                }

            }
        });


    }




    public void updateQuestion() {
        shuffle();
        imageView.setImageResource(quizArray[0].getmImage());
        questionView.setText(quizArray[0].getMquestion());
        answer = quizArray[0].getmAnswer();
        questionNo++;
    }

    private void updateScore(int point) {
        scoreView.setText("" + score);
    }




    QuizBook book1 = new QuizBook(QuizBook.questions[0], QuizBook.images[0], QuizBook.answers[0]);
    QuizBook book2 = new QuizBook(QuizBook.questions[1], QuizBook.images[1], QuizBook.answers[1]);
    QuizBook book3 = new QuizBook(QuizBook.questions[2], QuizBook.images[2], QuizBook.answers[2]);
    QuizBook book4 = new QuizBook(QuizBook.questions[3], QuizBook.images[3], QuizBook.answers[3]);
    QuizBook book5 = new QuizBook(QuizBook.questions[4], QuizBook.images[4], QuizBook.answers[4]);
    QuizBook book6 = new QuizBook(QuizBook.questions[5], QuizBook.images[5], QuizBook.answers[5]);
    QuizBook book7 = new QuizBook(QuizBook.questions[6], QuizBook.images[6], QuizBook.answers[6]);
    QuizBook book8 = new QuizBook(QuizBook.questions[7], QuizBook.images[7], QuizBook.answers[7]);
    QuizBook book9 = new QuizBook(QuizBook.questions[8], QuizBook.images[8], QuizBook.answers[8]);
    QuizBook book10 = new QuizBook(QuizBook.questions[9], QuizBook.images[9], QuizBook.answers[9]);

    QuizBook[] quizArray = new QuizBook[]{
            book1, book2, book3, book4, book5, book6, book7, book8, book9, book10
    };


    public void shuffle() {
        Collections.shuffle(Arrays.asList(quizArray));
    }

}

//    private String mquestion;
//    private int mImage;
//    private boolean mAnswer;
//
//
//    public QuizModel(String mquestion, int mImage, boolean mAnswer) {
//        this.mquestion = mquestion;
//        this.mImage = mImage;
//        this.mAnswer = mAnswer;
//    }
//
//    public String getMquestion() {
//        return mquestion;
//    }
//
//    public int getmImage() {
//        return mImage;
//    }
//
//    public boolean ismAnswer() {
//        return mAnswer;
//    }


