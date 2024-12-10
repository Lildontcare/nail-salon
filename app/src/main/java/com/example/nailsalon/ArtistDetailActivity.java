package com.example.nailsalon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ArtistDetailActivity extends AppCompatActivity {
    private String[][] artist_details1=
            {
                    {"Artist Name : Kis Anikó", "Address : Bp Harang 32", "Exp: 4yrs", "Mobile No:+36203344562", "6000"},
                    {"Artist Name : Harsányi Margit", "Address : Miskolc Fa 6", "Exp: 13yrs", "Mobile No:+36206482699", "9000"},
                    {"Artist Name : kovács Szilvia", "Address : Bp Mester 87", "Exp: 6yrs", "Mobile No:+36308864526", "4000"},
                    {"Artist Name : Sügér Mariann", "Address : Gyöngyös Petőfi Sándor 2", "Exp: 2yrs", "Mobile No:+36203115147", "3000"},
                    {"Artist Name : Nagy Fanni", "Address : Bp Váci 103", "Exp: 7yrs", "Mobile No:+36702344955", "7000"}
            };
    private String[][] artist_details2=
            {
                    {"Artist Name : Szabó Ildikó", "Address : Debrecen Kossuth 15", "Exp: 10yrs", "Mobile No:+36301234567", "8000"},
                    {"Artist Name : Fekete Dóra", "Address : Szeged Rózsa 23", "Exp: 3yrs", "Mobile No:+36204567891", "4500"},
                    {"Artist Name : Tóth Beáta", "Address : Pécs Király 12", "Exp: 8yrs", "Mobile No:+36701249876", "7500"},
                    {"Artist Name : Balogh Eszter", "Address : Budaörs Templom 5", "Exp: 5yrs", "Mobile No:+36402135789", "5000"},
                    {"Artist Name : Nagy László", "Address : Győr Baross 8", "Exp: 12yrs", "Mobile No:+36805567834", "9500"}
            };
    private String[][] artist_details3=
            {
                    {"Artist Name : Kerekes Anna", "Address : Pécs Hunyadi 14", "Exp: 9yrs", "Mobile No:+36201234567", "8700"},
                    {"Artist Name : Molnár Gábor", "Address : Sopron Erzsébet 3", "Exp: 6yrs", "Mobile No:+36203456789", "6500"},
                    {"Artist Name : Horváth Edit", "Address : Bp Andrássy 22", "Exp: 4yrs", "Mobile No:+36309876543", "4800"},
                    {"Artist Name : Varga István", "Address : Eger Széchenyi 7", "Exp: 7yrs", "Mobile No:+36701239876", "7000"},
                    {"Artist Name : Kiss Noémi", "Address : Székesfehérvár Budai 9", "Exp: 5yrs", "Mobile No:+36805543219", "6000"}
            };
    private String[][] artist_details4=
            {
                    {"Artist Name : Török Zsuzsanna", "Address : Miskolc Ady 11", "Exp: 8yrs", "Mobile No:+36305512111", "8000"},
                    {"Artist Name : Kovács Tamás", "Address : Nyíregyháza Rákóczi 10", "Exp: 3yrs", "Mobile No:+36407788866", "5000"},
                    {"Artist Name : Nagy Bence", "Address : Zalaegerszeg Kossuth 8", "Exp: 2yrs", "Mobile No:+36205541237", "4500"},
                    {"Artist Name : Papp Lilla", "Address : Szolnok Tiszapart 18", "Exp: 11yrs", "Mobile No:+36306678932", "8500"},
                    {"Artist Name : Fekete János", "Address : Debrecen Hatvan 6", "Exp: 9yrs", "Mobile No:+36704456789", "7500"}
            };
    private String[][] artist_details5=
            {
                    {"Artist Name : Bíró Márta", "Address : Kecskemét Bem 21", "Exp: 6yrs", "Mobile No:+36307754622", "6400"},
                    {"Artist Name : Szűcs Péter", "Address : Szeged Tisza 4", "Exp: 5yrs", "Mobile No:+36402276843", "5200"},
                    {"Artist Name : Hegedűs Ádám", "Address : Paks Duna 3", "Exp: 8yrs", "Mobile No:+36208899912", "7800"},
                    {"Artist Name : Szabó Erika", "Address : Veszprém Iskola 7", "Exp: 4yrs", "Mobile No:+36301238876", "4600"},
                    {"Artist Name : Major Klára", "Address : Tatabánya Béke 2", "Exp: 10yrs", "Mobile No:+36806667899", "9000"}
            };





    TextView tv;
    Button btn;
    String[][] artist_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);

        tv = findViewById(R.id.textViewADTitle);
        btn = findViewById(R.id.buttonBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Nail Technichian")==0)
            artist_details =artist_details1;
        else
        if(title.compareTo("Manicurist")==0)
            artist_details =artist_details2;
        else
        if(title.compareTo("Pedicurist")==0)
            artist_details =artist_details3;
        else
        if(title.compareTo("Masseuse")==0)
            artist_details =artist_details4;
        else
            artist_details =artist_details5;

            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArtistDetailActivity.this,FindArtistActivity.class));
            }
        });

        list = new ArrayList<>();
        for(int i=0;i< artist_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", artist_details[i][0]);
            item.put("line2", artist_details[i][1]);
            item.put("line3", artist_details[i][2]);
            item.put("line4", artist_details[i][3]);
            item.put("line5", "Cons Fees:"+artist_details[i][4]+"Ft");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewAD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(ArtistDetailActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",artist_details[i][0]);
                it.putExtra("text3",artist_details[i][1]);
                it.putExtra("text4",artist_details[i][3]);
                it.putExtra("text5",artist_details[i][4]);
                startActivity(it);
            }
        });
    }
}