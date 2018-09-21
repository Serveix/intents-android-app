package com.eliprojects.mapsapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText telEditText;
    EditText paginaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telEditText    = (EditText)findViewById(R.id.telEditText);
        paginaEditText = (EditText)findViewById(R.id.paginaEditText);

    }

    public void intentTelefono( View view ) {
        String numero = telEditText.getText().toString();
        if(TextUtils.isDigitsOnly(numero) && numero.length() == 10) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + numero));
            startActivity(intent);
        }
    }

    public void intentWeb(View view){
        String url = paginaEditText.getText().toString();
        if(URLUtil.isValidUrl(url)){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else {
            paginaEditText.setError("Debe ser una pagina valida");
        }
    }

    public void intentMaps(View view) {
        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
