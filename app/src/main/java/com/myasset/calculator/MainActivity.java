package com.myasset.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/* 계산기 앱 작성 : 김운용
   작성일 : 2017.06.15
   이슈사항 : NONE
  */

public class MainActivity extends AppCompatActivity {
    /* 변수명 설정 */
    TextView text;
    Button div, plus, equal, multi, sub;
    Button cancel;
    String number; //첫번째 값 -> 연산자 -> 두번째 값 순서로 진행될 때, 첫번째 값을 담아두는 곳
    int value; //어떤 연삭자가 선택되었는지 구분값.

    int DIVISION = 0;
    int PLUS = 1;
    int MULTI = 2;
    int SUB = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);
        number = "";

        div = (Button)findViewById(R.id.btn_division);
        plus = (Button)findViewById(R.id.btn_plus);
        equal = (Button)findViewById(R.id.btn_result);
        multi = (Button)findViewById(R.id.btn_multi);
        sub = (Button)findViewById(R.id.btn_sub);

        div.setOnClickListener(mListener);
        plus.setOnClickListener(mListener);
        equal.setOnClickListener(mListener);
        sub.setOnClickListener(mListener);
        multi.setOnClickListener(mListener);

        cancel = (Button) findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "";
                text.setText("");
            }
        });
    }

    Button.OnClickListener mListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_division :
                    number = text.getText().toString();
                    text.setText(""); //내용물 비워두기
                    value = DIVISION;
                    Toast.makeText(MainActivity.this, "/", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_plus :
                    number = text.getText().toString();
                    text.setText(""); //내용물 비워두기
                    value = PLUS;
                    Toast.makeText(MainActivity.this, "+", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_sub :
                    number = text.getText().toString();
                    text.setText(""); //내용물 비워두기
                    value = SUB;
                    Toast.makeText(MainActivity.this, "-", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_multi :
                    number = text.getText().toString();
                    text.setText(""); //내용물 비워두기
                    value = MULTI;
                    Toast.makeText(MainActivity.this, "*", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_result :
                    if(value == MULTI) {
                        text.setText( "" + ( Double.parseDouble(number) * Double.parseDouble(text.getText().toString()) ) );
                    } else if(value == SUB) {
                        text.setText( "" + ( Double.parseDouble(number) - Double.parseDouble(text.getText().toString()) ) );
                    } else if(value == PLUS) {
                        text.setText( "" + ( Double.parseDouble(number) + Double.parseDouble(text.getText().toString()) ) );
                    } else if(value == DIVISION) {
                        text.setText( "" + ( Double.parseDouble(number) / Double.parseDouble(text.getText().toString()) ) );
                    }
                    number = text.getText().toString(); //최종 결과값을 가지고, 바로 다음 연산을 가능하게 하도록 number 들어가 있는 값을 교체해줌

                    break;
            }
        }
    };

    //xml에서  onClick 이벤트를 연동해놓았던 숫자들.
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0 : text.setText(text.getText().toString() + 0); break;
            case R.id.btn_1 : text.setText(text.getText().toString() + 1); break;
            case R.id.btn_2 : text.setText(text.getText().toString() + 2); break;
            case R.id.btn_3 : text.setText(text.getText().toString() + 3); break;
            case R.id.btn_4 : text.setText(text.getText().toString() + 4); break;
            case R.id.btn_5 : text.setText(text.getText().toString() + 5); break;
            case R.id.btn_6 : text.setText(text.getText().toString() + 6); break;
            case R.id.btn_7 : text.setText(text.getText().toString() + 7); break;
            case R.id.btn_8 : text.setText(text.getText().toString() + 8); break;
            case R.id.btn_9 : text.setText(text.getText().toString() + 9); break;
        }
    }
}
