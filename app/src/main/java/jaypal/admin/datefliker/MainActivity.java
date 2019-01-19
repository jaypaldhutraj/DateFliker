package jaypal.admin.datefliker;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    EditText et1;
    Button submitbtn;
    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        et1=findViewById(R.id.et1);
        datePicker=findViewById(R.id.datepiker);
        submitbtn=findViewById(R.id.submit_btn);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                final Calendar c =Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day=c.get(Calendar.DAY_OF_MONTH);
                datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        et1.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }
                });
                String s=et1.getText().toString();
                Toast.makeText(MainActivity.this,"EditText ::"+s,Toast.LENGTH_LONG).show();
                et1.setEnabled(false);
                submitbtn.setEnabled(false);
            }
        });
    }
}
