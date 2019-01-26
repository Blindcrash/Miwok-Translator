package com.example.blind.miwok2;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // El contenido aparecera en la actividad principal
        setContentView(R.layout.activity_main);

        // Busca el view pager que permite que las vistas se deslicen a los lados
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // Crea un adaptador que sabe que fragmento se debe usar en cada pagina
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        //  Declara el adaptador en el view pager
        viewPager.setAdapter(adapter);

        // Encuentra en las vistas el tab layout que mostrara los nombres de cada vista
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Conecta el tab layout para que con ayuda del view pager pueda
        //   1. Actualizar el tab layout cada que se desplace de pantalla
        //   2. Actualiza el view pager para que muestre cual tab esta usando
        //   3. Declara el tab layout con el nombre para que el view pager adapte los nombres por
        //      la llamada de OnPageTitle()
        tabLayout.setupWithViewPager(viewPager);
    }
}