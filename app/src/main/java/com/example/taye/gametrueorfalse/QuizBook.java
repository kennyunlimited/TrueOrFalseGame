package com.example.taye.gametrueorfalse;

/**
 * Created by TAYE on 05/03/2017.
 */

public class QuizBook {

    private String mquestion;
    private int mImage;
    private boolean mAnswer;

    public QuizBook(String mquestion, int mImage, boolean mAnswer) {
        this.mquestion = mquestion;
        this.mImage = mImage;
        this.mAnswer = mAnswer;
    }

    public String getMquestion() {
        return mquestion;
    }

    public int getmImage() {
        return mImage;
    }

    public boolean getmAnswer() {
        return mAnswer;
    }

    public static String[] questions = new String[] {
            "Fourth generation computer use integrated circuits.",
            "One megabyte is equivalent to 1024 B.",
            "When you delete an object, windows send it to the Recycle bin.",
            "Primary memory is usually referred to as RAM.",
            "Step by step instructions is called Software.",
            "A group of 8 bits is called a Nibble.",
            "DOS is an example of GUI.",
            "Internet is a network of computer networks.",
            "The bits can have only 2 values.",
            "ROM is a volatile memory."
    };

    public static int[] images = new int[] {
           R.mipmap.photo2, R.mipmap.photo1, R.mipmap.photo3, R.mipmap.photo4, R.mipmap.photo5, R.mipmap.photo6,
            R.mipmap.photo7, R.mipmap.photo8, R.mipmap.photo9, R.mipmap.photo10

    };

    public static boolean[] answers = new boolean[] {
            true,
            false,
            true,
            true,
            false,
            false,
            false,
            true,
            true,
            false
    };


}
