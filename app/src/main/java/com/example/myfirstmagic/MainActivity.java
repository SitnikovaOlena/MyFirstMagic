package com.example.myfirstmagic;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button imgBtn;
    Button button;
    EditText mEdit;
    EditText mEdit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_layout);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        button = (Button) findViewById(R.id.next_level_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                setContentView(R.layout.magic_pict);
                addListenerOnButton2();
            }
        });

    }


    public void addListenerOnButton2() {
        imgBtn = (Button)findViewById(R.id.n_btn);
        imgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                setContentView(R.layout.calculator);
                addListenerOnButtonCalc();
            }
        });

    }

    public void addListenerOnButtonCalc() {
        button = (Button) findViewById(R.id.button);
        mEdit   = (EditText)findViewById(R.id.editTextNumber3);
        mEdit2   = (EditText)findViewById(R.id.editTextNumber);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Log.v("EditText", String.valueOf(mEdit.getText()));
                Log.v("EditText", String.valueOf(mEdit2.getText()));
                String fValue = mEdit.getText().toString();
                String sValue = mEdit2.getText().toString();
                int firstValue = Integer.parseInt(fValue);
                int secondValue = Integer.parseInt(sValue);
                int result = firstValue + secondValue;
                final String resultText = String.valueOf(result);


//                Editable firstValue = mEdit.getText();
//                Editable secondValue = mEdit2.getText();
                final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
                progressBar.setVisibility(ProgressBar.VISIBLE);
                Runnable r = new Runnable() {
                    @Override
                    public void run(){
                        progressBar.setVisibility(ProgressBar.INVISIBLE);
                        TextView textView = (TextView) findViewById(R.id.textView2);
                        textView.setVisibility(View.VISIBLE);
                        TextView textViewN = (TextView) findViewById(R.id.textView3);
                        textViewN.setVisibility(View.VISIBLE);
                        textViewN.setText(resultText);

                    }
                };

                Handler h = new Handler();
                h.postDelayed(r, 1000);
            }

        });

}
}