package com.odeene.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView menu = findViewById(R.id.buttonsNav);
        BlueFragment blueFragment = new BlueFragment();
        RedFragment redFragment = new RedFragment();
        GreenFragment greenFragment = new GreenFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.displayFragment, redFragment)
                    .commit();
        }

        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.blue){
                    if (savedInstanceState == null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.displayFragment, blueFragment)
                                .commit();
                    }
                    return true;
                } else if(item.getItemId() == R.id.red){
                    if (savedInstanceState == null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.displayFragment, redFragment)
                                .commit();
                    }
                    return true;
                } else if(item.getItemId() == R.id.green){
                    if (savedInstanceState == null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.displayFragment, greenFragment)
                                .commit();
                    }
                    return true;
                }
                return false;
            }
        });

//        boton.setOnClickListener(v -> {
//            String inputText = input.getText().toString();
//            // Llamar al método del Fragment para actualizar el texto
//            if (displayFragment != null) { Log.i("error" , "adsdsdawd");
//                displayFragment.updateText(inputText);
//            } else {
//                Log.i("error" , "adsd");
//            }
//        });
    }
}