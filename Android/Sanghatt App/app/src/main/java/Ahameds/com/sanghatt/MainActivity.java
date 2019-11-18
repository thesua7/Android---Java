package Ahameds.com.sanghatt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton india;
    Dialog popup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popup = new Dialog(this);

        india = (ImageButton)findViewById(R.id.indiajar);

        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Showpopup(v);
            }
        });



    }


       public void Showpopup(View v){
           TextView exit;
        popup.setContentView(R.layout.custompopup);
        exit = (TextView) popup.findViewById(R.id.exitbtn);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });

        popup.show();

       }


}
