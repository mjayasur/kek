package ml.vernie.kek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MessengerActivity extends AppCompatActivity {
    String displayName;
    EditText messageText;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Message> messageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        Intent intent = getIntent();
        displayName = intent.getStringExtra("displayName");
        int duration;
        Context context = getApplicationContext();
        duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, "Welcome, " + displayName, duration);
        toast.show();
        messageText = findViewById(R.id.edit_message);
        messageList = new ArrayList<Message>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(mAdapter);

    }
    public void sendMessage(View view) {
        String text = messageText.getText().toString();
        if (!text.equals("")) {
            messageList.add(new Message(text, displayName, ""));
            messageText.setText("");
            mAdapter.notifyItemInserted(messageList.size() - 1);
            System.out.println(messageList.size());
        }
    }

}
