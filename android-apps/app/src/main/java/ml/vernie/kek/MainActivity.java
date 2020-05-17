package ml.vernie.kek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText displayNameText;
    Button enterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayNameText = (EditText) findViewById(R.id.editDisplayText);
        enterButton = (Button) findViewById(R.id.enterButton);
    }
    public void enterRoom(View view) {

//        int duration;
//        Context context = getApplicationContext();
//        duration = Toast.LENGTH_SHORT;
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
        String text = displayNameText.getText().toString();

        if (!text.equals("")) {

            Intent intent = new Intent(this, MessengerActivity.class);
            intent.putExtra("displayName", text);
            startActivity(intent);
        }
    }
}
