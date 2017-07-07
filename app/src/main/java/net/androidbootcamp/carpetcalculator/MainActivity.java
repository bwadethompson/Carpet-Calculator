package net.androidbootcamp.carpetcalculator;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double RoomWidth;
    double RoomLength;
    double TotalSqFt;
    String CarpetPick;
    int PickedCarpet;


    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageButton carpetbutton = (ImageButton) findViewById(R.id.imgButtonCarpet);
        carpetbutton.setVisibility(View.INVISIBLE);
        final EditText Rwidth=(EditText)findViewById(R.id.txtWidth);
        final EditText Rlength=(EditText)findViewById(R.id.txtLength);
        final Spinner carpet = (Spinner) findViewById(R.id.spinnerCarpet);
        Button calculate = (Button) findViewById(R.id.btnCalc);



        calculate.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView) findViewById(R.id.txtResults));
            @Override
            public void onClick(View view) {
                RoomWidth = Double.parseDouble(Rwidth.getText().toString());
                RoomLength = Double.parseDouble(Rlength.getText().toString());
                TotalSqFt = (RoomLength * RoomWidth)/9;
                java.text.DecimalFormat outputCarpet = new java.text.DecimalFormat("##,###.##");
                CarpetPick = carpet.getSelectedItem().toString();
                PickedCarpet = carpet.getSelectedItemPosition();

                if (PickedCarpet == 0){
                    //goToUrl("https://www.lowes.com/pd/STAINMASTER-Trusoft-Clearman-Estates-Classico-Shag-Frieze-Interior-Carpet/50157578");
                    carpetbutton.setVisibility(View.VISIBLE);
                    carpetbutton.setImageResource(R.drawable.classico);
                }else if(PickedCarpet == 1){
                    carpetbutton.setVisibility(View.VISIBLE);
                    carpetbutton.setImageResource(R.drawable.houdini);
                }else if(PickedCarpet == 2){
                    carpetbutton.setVisibility(View.VISIBLE);
                    carpetbutton.setImageResource(R.drawable.powerpoint);
                }else if(PickedCarpet == 3){
                    carpetbutton.setVisibility(View.VISIBLE);
                    carpetbutton.setImageResource(R.drawable.toffee);
                }

                result.setText("You picked " +CarpetPick+ " and require "+
                        outputCarpet.format(TotalSqFt)+ " square yards of Carpet. Click your carpet sample below to buy now.");

            }


        });

        carpetbutton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                if (PickedCarpet == 0){
                    goToUrl("http://www.lowes.com/pd/STAINMASTER-Trusoft-Clearman-Estates-Classico-Shag-Frieze-Interior-Carpet/50157578");

                }else if(PickedCarpet == 1){
                   goToUrl("http://www.lowes.com/pd/STAINMASTER-Trusoft-Clearman-Estates-Houdini-Shag-Frieze-Interior-Carpet/50157582");
                }else if(PickedCarpet == 2){
                    goToUrl("http://www.lowes.com/pd/STAINMASTER-Trusoft-Clearman-Estates-Power-Point-Shag-Frieze-Interior-Carpet/50157572");
                }else if(PickedCarpet == 3){
                    goToUrl("http://www.lowes.com/pd/Toffee-Berber-Loop-Interior-Exterior-Carpet/3089941");
                }

            }
        });
    }

}
