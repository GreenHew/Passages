package com.example.matthew.mgreen_threepassages_s18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.matthew.mgreen_threepassages.passage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) throws IOException {
        Button button = (Button)view;
        String name = button.getText().toString();
        InputStream stream = null;
        switch(name) {
            case "Ancient Curious Famous Wills":
                stream = getAssets().open("ancientCuriousFamousWills.txt");
                break;
            case "Tetris Fan Fiction":
                stream = getAssets().open("tetrisFanFic.txt");
                break;
            case "Poems of the World War":
                stream = getAssets().open("poemsOfWorldWar.txt");
                break;
        }
        Scanner s = new Scanner(stream).useDelimiter("\\A");
        String text = s.hasNext() ? s.next() : "";
        Intent intent = new Intent(this, PassageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, text);
        startActivity(intent);
    }

}
