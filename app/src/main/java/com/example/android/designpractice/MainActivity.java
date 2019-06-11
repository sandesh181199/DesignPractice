package com.example.android.designpractice;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Development development_frag;
    Design design_frag;
    Marketing marketing_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        development_frag= new Development();
        design_frag = new Design();
        marketing_frag = new Marketing();

        BottomNavigationView nav=findViewById(R.id.nav);
        final FrameLayout content=findViewById(R.id.content_layout);

        change_fragment(development_frag) ;
       nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               switch (menuItem.getItemId())
               {
                   case R.id.developmet:
                       change_fragment(development_frag);
                       Animation a = AnimationUtils.loadAnimation(MainActivity.this,R.anim.coustom_animation);
                       content.startAnimation(a);
                       return true;

                   case R.id.marking:
                       change_fragment(marketing_frag);
                       Animation b= AnimationUtils.loadAnimation(MainActivity.this,R.anim.coustom_animation);
                       content.startAnimation(b);
                       return true;

                   case R.id.design:
                       change_fragment(design_frag);
                       Animation c= AnimationUtils.loadAnimation(MainActivity.this,R.anim.coustom_animation);
                       content.startAnimation(c);
                       return true;


               }
               return false;
           }
       });
    }

    private void change_fragment(Fragment fragment) {
        FragmentTransaction freagmenttrasaction =getSupportFragmentManager().beginTransaction();
        freagmenttrasaction.replace(R.id.content_layout,fragment);
        freagmenttrasaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.design:
            Toast.makeText(this,"Design",Toast.LENGTH_SHORT);
            return true;

            case R.id.developmet:
                Toast.makeText(this,"Development",Toast.LENGTH_SHORT);
                return true;

            case R.id.marking:
                Toast.makeText(this,"Marking",Toast.LENGTH_SHORT);
                return true;

                default:return false;





        }

    }

}
