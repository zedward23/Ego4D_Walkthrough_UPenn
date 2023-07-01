package com.example.ego4d_walkthrough_upenn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Step1 extends AppCompatActivity {
    private Button back;
    private Button next;

    private TextView instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standard_instruction);

        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);

        instructions = (TextView) findViewById(R.id.instructions);
        instructions.setText("1. Remove GoPro Door \n 2. Insert SD Card \n 3. Insert Internal Battery \n 4. Remove Screw from each Box \n 5. Mount Each GoPro");

        next.setText("Next Step");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next_page();
            }
        });

        back.setText("Previous Step");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previous_page();
            }
        });

    }

    public void previous_page(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void next_page(){
        Intent intent = new Intent(this, Step2.class);
        startActivity(intent);
        finish();
    }
}