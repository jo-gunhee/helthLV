package com.example.helthlv;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Collections;


public class MainActivity extends AppCompatActivity {
    MaterialCalendarView materialCalendarView;
    OneDayDecorator oneDayDecorator = new OneDayDecorator();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission03);

        materialCalendarView = findViewById(R.id.calendarView);
        materialCalendarView.addDecorators(new SundayDecorator(), new SaturdayDecorator());
        materialCalendarView.addDecorators(oneDayDecorator);
        materialCalendarView.addDecorators(new EventDecorator(Color.RED, Collections.singleton(CalendarDay.today())));


        Button btn01 = findViewById(R.id.btn00);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MissionSucces.class);
                startActivity(intent);
            }
        });
    }
}
