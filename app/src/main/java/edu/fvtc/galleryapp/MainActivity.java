package edu.fvtc.galleryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    //Controls
    TextView birdDescription;
    ImageView birdPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set toolbar
        Toolbar toolbarBirds = (Toolbar)findViewById(R.id.toolbar_birds);
        setSupportActionBar(toolbarBirds);
        //Initialize/set text
        birdDescription = (TextView)findViewById(R.id.txtDescription);
        birdDescription.setText(readTxt(R.raw.duck));
        //Initialize/set image
        birdPicture = (ImageView)findViewById(R.id.imgViewBird);
        birdPicture.setImageResource(R.drawable.duck);
    }

    private String readTxt(int id){
        InputStream inputStream = getResources().openRawResource(id);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try{
            i = inputStream.read();
            while(i!=-1){
                byteArrayOutputStream.write(i);
                i=inputStream.read();
            }
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.selectionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.mItem_Duck:
                birdDescription.setText(readTxt(R.raw.duck));
                birdPicture.setImageResource(R.drawable.duck);
                return true;
            case R.id.mItem_Turkey:
                birdDescription.setText(readTxt(R.raw.turkey));
                birdPicture.setImageResource(R.drawable.turkey);
                return true;
            case R.id.mItem_Chicken:
                birdDescription.setText(readTxt(R.raw.chicken));
                birdPicture.setImageResource(R.drawable.chicken);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
