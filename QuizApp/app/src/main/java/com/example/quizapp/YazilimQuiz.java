package com.example.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YazilimQuiz extends AppCompatActivity {

    TextView quiztext,aans,bans,cans,dans;
    List<QuestionsItem>questionsItems;
    int currentQuestions=0;
    int correct=0, wronq=0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quiztext=findViewById(R.id.quizText);
        aans = findViewById(R.id.aanswer);
        bans = findViewById(R.id.banswer);
        cans = findViewById(R.id.canswer);
        dans = findViewById(R.id.danswer);

        loadAllQuestions();
        Collections.shuffle(questionsItems);
        setQuestionScreen(currentQuestions);

        aans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer1().equals(questionsItems.get(currentQuestions).getCorrect())){
                    correct++;
                    aans.setBackgroundResource(R.color.green);
                    aans.setTextColor(getResources().getColor(R.color.white));
                }else {
                    wronq++;
                    aans.setBackgroundResource(R.color.red);
                    aans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions<questionsItems.size()-1){
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            aans.setBackgroundResource(R.color.white);
                            aans.setTextColor(getResources().getColor(R.color.text_secondary_color));

                        }
                    }, 500);
                }else {
                    Intent intent= new Intent(YazilimQuiz.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wronq);
                    startActivity(intent);
                    finish();
                }
            }
        });

        bans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer2().equals(questionsItems.get(currentQuestions).getCorrect())){
                    correct++;
                    bans.setBackgroundResource(R.color.green);
                    bans.setTextColor(getResources().getColor(R.color.white));
                }else {
                    wronq++;
                    bans.setBackgroundResource(R.color.red);
                    bans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions<questionsItems.size()-1){
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            bans.setBackgroundResource(R.color.white);
                            bans.setTextColor(getResources().getColor(R.color.text_secondary_color));

                        }
                    }, 500);
                }else {
                    Intent intent= new Intent(YazilimQuiz.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wronq);
                    startActivity(intent);
                    finish();
                }
            }
        });

        cans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer3().equals(questionsItems.get(currentQuestions).getCorrect())){
                    correct++;
                    cans.setBackgroundResource(R.color.green);
                    cans.setTextColor(getResources().getColor(R.color.white));
                }else {
                    wronq++;
                    cans.setBackgroundResource(R.color.red);
                    cans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions<questionsItems.size()-1){
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            cans.setBackgroundResource(R.color.white);
                            cans.setTextColor(getResources().getColor(R.color.text_secondary_color));

                        }
                    }, 500);
                }else {
                    Intent intent= new Intent(YazilimQuiz.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wronq);
                    startActivity(intent);
                    finish();
                }
            }
        });

        dans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer4().equals(questionsItems.get(currentQuestions).getCorrect())){
                    correct++;
                    dans.setBackgroundResource(R.color.green);
                    dans.setTextColor(getResources().getColor(R.color.white));
                }else {
                    wronq++;
                    dans.setBackgroundResource(R.color.red);
                    dans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions<questionsItems.size()-1){
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            dans.setBackgroundResource(R.color.white);
                            dans.setTextColor(getResources().getColor(R.color.text_secondary_color));

                        }
                    }, 500);
                }else {
                    Intent intent= new Intent(YazilimQuiz.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wronq);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionScreen(int currentQuestions) {
        quiztext.setText(questionsItems.get(currentQuestions).getQuestions());
        aans.setText(questionsItems.get(currentQuestions).getAnswer1());
        bans.setText(questionsItems.get(currentQuestions).getAnswer2());
        cans.setText(questionsItems.get(currentQuestions).getAnswer3());
        dans.setText(questionsItems.get(currentQuestions).getAnswer4());


    }
    private void loadAllQuestions(){
        questionsItems=new ArrayList<>();
        String jsonquiz=loadJsonFromAsset("yazilimquestions.json");
        try{
            JSONObject jsonObject=new JSONObject(jsonquiz);
            JSONArray questions= jsonObject.getJSONArray("yazilimquestions");
            for(int i=0;i<questions.length();i++){
                JSONObject question=questions.getJSONObject(i);
                String questionString=question.getString("question");
                String answer1String=question.getString("answer1");
                String answer2String=question.getString("answer2");
                String answer3String=question.getString("answer3");
                String answer4String=question.getString("answer4");
                String correctString=question.getString("correct");

                questionsItems.add(new QuestionsItem(questionString,answer1String,answer2String,answer3String,answer4String,correctString));
            }
        }catch(JSONException e){
            e.printStackTrace();
        }

    }

    private String loadJsonFromAsset(String s) {
        String json="";
        try {
            InputStream inputStream=getAssets().open(s);
            int size=inputStream.available();
            byte[]buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json=new String(buffer, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }
    @Override
    public void onBackPressed() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder= new MaterialAlertDialogBuilder(YazilimQuiz.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Sınavdan çıkmak istediğinize emin misiniz");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface,int i) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface,int i) {
                startActivity(new Intent(YazilimQuiz.this,MainActivity.class));
                finish();
            }
        });
        materialAlertDialogBuilder.show();
    }
}