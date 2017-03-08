package com.hanbit.helloapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.hanbit.helloapp.R;
import com.hanbit.helloapp.domain.CalcBean;
import com.hanbit.helloapp.service.CalcService;
import com.hanbit.helloapp.serviceImpl.CalcServiceImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etFirstNum,etSencondNum;
    Button btPlus,btMinus,btMulti,btDivide,btMod,btEqual;
    TextView tvResult;
    int result;
    CalcService service;
    CalcBean bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service =  new CalcServiceImpl();
        bean = new CalcBean();
        etFirstNum = (EditText) findViewById(R.id.etFirstNum);
        etSencondNum = (EditText) findViewById(R.id.etSencondNum);
        btPlus = (Button) findViewById(R.id.btPlus);
        btMinus = (Button) findViewById(R.id.btMinus);
        btDivide = (Button) findViewById(R.id.btDivide);
        btMulti = (Button) findViewById(R.id.btMulti);
        btMod = (Button) findViewById(R.id.btMod);
        btEqual = (Button) findViewById(R.id.btEqual);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btPlus.setOnClickListener(this);
        btMinus.setOnClickListener(this);
        btDivide.setOnClickListener(this);
        btMulti.setOnClickListener(this);
        btMod.setOnClickListener(this);
        btEqual.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        bean.setFirstNum(Integer.parseInt(etFirstNum.getText().toString()));
        bean.setSecondNum(Integer.parseInt(etSencondNum.getText().toString()));
        int firstNum=Integer.parseInt(etFirstNum.getText().toString());
        int secondNum=Integer.parseInt(etSencondNum.getText().toString());
        Log.d("firstNum=", String.valueOf(firstNum));
        Log.d("secondNum=", String.valueOf(secondNum));
        switch (v.getId()){
            case R.id.btPlus:
                result = service.plus(bean);
                break;
            case R.id.btMinus:
                result = service.minus(bean);
                break;
            case R.id.btDivide:
                result = service.divide(bean);
                break;
            case R.id.btMulti:
                result = service.multi(bean);
                break;
            case R.id.btMod:
                result = service.mod(bean);
                break;
            case R.id.btEqual:
                Log.d("RESULT=", String.valueOf(result));
                tvResult.setText("RESULT :"+result);
                break;
        }
    }
}