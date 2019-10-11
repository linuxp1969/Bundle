package org.altervista.linuxp.bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView tvNumero;
    private int i;
    private int variabileferlocca;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNumero = findViewById(R.id.tvNumero);
        if (savedInstanceState == null){
            i=0;
        }else {
            i=savedInstanceState.getInt("Key");
        }
        new Thread(new run()).start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Key",i);
    }

    public class run implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        i++;
                        tvNumero.setText(String.valueOf(i));
                    }
                });
            }
        }
    }

}

