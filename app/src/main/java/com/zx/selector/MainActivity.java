package com.zx.selector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.rb_1)
    RadioButton rb1;
    @Bind(R.id.rb_2)
    RadioButton rb2;
    @Bind(R.id.rb_3)
    RadioButton rb3;
    @Bind(R.id.rb_4)
    RadioButton rb4;
    @Bind(R.id.rg_list)
    RadioGroup rgList;
    private TimePickerView timePickerView;
    private  SimpleDateFormat sdf;
    String all = "yyyy-MM-dd hh:mm:ss";
    String ymd = "yyyy-MM-dd";
    String hm = "hh:mm";
    String mdhm = "MM-dd hh:mm";
    String ym = "yyyy-MM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        timePickerView =  new TimePickerView(MainActivity.this, TimePickerView.Type.ALL);

        //ALL, YEAR_MONTH_DAY, HOURS_MINS, MONTH_DAY_HOUR_MIN , YEAR_MONTH


        rgList.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_1 :
                        timePickerView =  new TimePickerView(MainActivity.this, TimePickerView.Type.YEAR_MONTH_DAY);
                         sdf = new SimpleDateFormat(ymd);
                        break;
                    case R.id.rb_2 :
                        timePickerView =  new TimePickerView(MainActivity.this, TimePickerView.Type.HOURS_MINS);
                        sdf = new SimpleDateFormat(hm);
                        break;
                    case R.id.rb_3 :
                        timePickerView =  new TimePickerView(MainActivity.this, TimePickerView.Type.MONTH_DAY_HOUR_MIN);
                        sdf = new SimpleDateFormat(mdhm);
                        break;
                    case R.id.rb_4 :
                        timePickerView =  new TimePickerView(MainActivity.this, TimePickerView.Type.YEAR_MONTH);
                        sdf = new SimpleDateFormat(ym);
                        break;
                }
                timePickerView.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date) {

                        String str = sdf.format(date);
                        tvTime.setText(str);
                    }
                });
                timePickerView.setTime(new Date());
                timePickerView.setCyclic(true);
                timePickerView.show();
            }
        });
    }
}
