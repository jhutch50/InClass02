/*
* Assignment 2
* Main Activity
* Joshua Hutcheson
* Ormelia Robinson
* Hailey Brown
* */

package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_shape;
    private TextView tv_result;
    private TextView tv_length2;
    private Button button_calculate;
    private Button button_clear;
    private ImageView triangle;
    private ImageView square;
    private ImageView circle;
    private EditText et_length1;
    private EditText et_length2;
    private String selectedShape;
    Float length1;
    Float length2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Area Calculator");

        et_length1 = findViewById(R.id.editLength1);
        et_length2 = findViewById(R.id.editLength2);
        tv_length2 = findViewById(R.id.tv_Length2Lable);
        tv_result = findViewById(R.id.tv_result);
        tv_shape = findViewById(R.id.tv_shape);
        button_calculate = findViewById(R.id.button_calculate);
        button_clear = findViewById(R.id.button_clear);
        triangle = findViewById(R.id.triangle);
        square = findViewById(R.id.square);
        circle = findViewById(R.id.circle);
        selectedShape = "";
        length1=0.0f;
        length2=0.0f;
        clearButton();




        button_clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clearButton();
            }
        });

        triangle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                selectedShape = "triangle";
                tv_shape.setText("Triangle");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.VISIBLE);
                tv_length2.setVisibility(View.VISIBLE);

            }
        });

//          TODO: On Click for Square.....
        circle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                selectedShape = "circle";
                tv_shape.setText("Circle");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.GONE);
                tv_length2.setVisibility(View.GONE);

            }
        });
//          TODO: On Click for Cicrcle.....
        square.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                selectedShape = "square";
                tv_shape.setText("Square");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.GONE);
                tv_length2.setVisibility(View.GONE);
            }
        });

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String tempLength1 = et_length1.getText().toString();
                String tempLength2 = et_length2.getText().toString();
                if(tempLength1!=null && !tempLength1.equals(""))
                    length1 = Float.parseFloat(et_length1.getText().toString());
                if(tempLength2!=null && !tempLength2.equals(""))
                    length2 = Float.parseFloat(et_length2.getText().toString());
                if(et_length1.getText().toString().equals("")){
                    et_length1.setError("Hey, I need a value!");
                }
                if(et_length2.getText().toString().equals("")){
                    et_length2.setError("Hey, I need a value!");
                }
                switch(selectedShape) {
                    case "triangle":
                        tv_result.setText(String.valueOf(0.5f * length1 * length2));
                        break;
                    case "circle":
                        tv_result.setText(String.valueOf(3.14f * length1 * length1));
                        break;
                    case "square":
                        tv_result.setText(String.valueOf(length1 * length1));
                        break;
                }
            }
        });


    }

    public void clearButton(){
        et_length1.setVisibility(View.VISIBLE);
        et_length2.setVisibility(View.VISIBLE);
        tv_result.setVisibility(View.VISIBLE);
        et_length1.setText("");
        et_length2.setText("");
        tv_result.setText("");
//        tv_shape.setText("Select a shape");
//        triangle.setVisibility(View.VISIBLE);
//        circle.setVisibility(View.VISIBLE);

    }
}
