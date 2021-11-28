package com.example.openweatherapi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.openweatherapi.models.DataMethods;
import com.example.openweatherapi.models.DataModel;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    DataMethods methods = new DataMethods();
    Context context = this;
    ImageButton button;
    TextView nameText, descText, tempText, highText,lowText, feelsText, windText, humidText, pressureText;
    EditText cityEdit;
    ImageView image;
    String imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = findViewById(R.id.txtName);
        descText = findViewById(R.id.txtDescrip);
        tempText = findViewById(R.id.txtTemp);
        highText = findViewById(R.id.txtHigh);
        lowText = findViewById(R.id.txtLow);
        feelsText = findViewById(R.id.txtFeels);
        windText = findViewById(R.id.txtWind);
        humidText = findViewById(R.id.txtHumid);
        pressureText = findViewById(R.id.txtPressure);
        image = findViewById(R.id.imgView);
        cityEdit = findViewById(R.id.edtCity);

        button = findViewById(R.id.btnSearch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                methods.getWeatherInfo(context,cityEdit.getText().toString(),1);

            }
        });


    }

    @SuppressLint("SetTextI18n")
    public void passData(DataModel allData) {
        nameText.setText(allData.getName());
        descText.setText(allData.getDescription());
        tempText.setText(String.valueOf(Math.round(allData.getTemp())));
        highText.setText(String.valueOf(Math.round(allData.getMaxTemp())));
        lowText.setText(String.valueOf(Math.round(allData.getMinTemp())));
        feelsText.setText(String.valueOf(Math.round(allData.getFeelTemp())) /*+ Html.fromHtml("<sup><small>O</small></sup>")*/);
        windText.setText(String.valueOf(allData.getWind()) + "km/h");
        humidText.setText(String.valueOf(allData.getHumidity()) + "%");
        pressureText.setText(String.valueOf(allData.getPressure()) + "hPa");
        Picasso.get().load(allData.getIcon()).into(image);
        //imgUrl = allData.getIcon();
    }
}