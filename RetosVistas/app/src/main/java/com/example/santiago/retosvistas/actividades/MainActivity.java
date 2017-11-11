package com.example.santiago.retosvistas.actividades;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.santiago.retosvistas.R;
import com.example.santiago.retosvistas.fragmentos.BlueFragment;
import com.example.santiago.retosvistas.fragmentos.GreenFragment;
import com.example.santiago.retosvistas.fragmentos.RedFragment;
import com.example.santiago.retosvistas.fragmentos.YellowFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_manual);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final NavigationView navigationView = (NavigationView)findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction tx;
                Fragment fragment = null;

                int[] ids = {R.id.azul,R.id.rojo,R.id.amarillo,R.id.verde};
                for (int id:ids){
                    navigationView.getMenu().findItem(id).setChecked(false);
                }
                navigationView.getMenu().findItem(item.getItemId()).setChecked(true);
                switch(item.getItemId()){
                    case R.id.rojo:
                        fragment = new RedFragment();
                        break;
                    case R.id.azul:
                        fragment = new BlueFragment();
                        break;
                    case R.id.verde:
                        fragment = new GreenFragment();
                        break;
                    case R.id.amarillo:
                        fragment = new YellowFragment();
                        break;
                    default:
                        break;
                }
                if(null != fragment){
                    tx = fm.beginTransaction();
                    tx.replace(R.id.contenedor,fragment);
                    tx.commit();
                    drawer.closeDrawers();
                }
                return true;
            }
        });

        /*Button teQuiero = (Button) findViewById(R.id.button1);
        teQuiero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                if(fm.findFragmentByTag("fragment1") == null){
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.contenedor,new LetterMotherFragment(),"fragment1");
                    ft.commit();
                }
            }
        });

        ImageButton campeonato = (ImageButton) findViewById(R.id.copaAmerica);
        campeonato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, DrawerLayoutActivity.class);
                startActivity(intento);
            }
        });

        ImageButton borrar = (ImageButton) findViewById(R.id.button3);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                if(fm.findFragmentByTag("fragment1") != null){
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment fragmentBorrar = fm.findFragmentByTag("fragment1");
                    ft.remove(fragmentBorrar);
                    ft.commit();
                }
            }
        });

        Button decir = (Button) findViewById(R.id.button2);
        decir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.contenedor, new PoemFragment(),"fragment1");
                ft.commit();
            }
        });*/

    }

}
