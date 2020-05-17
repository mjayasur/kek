package ml.vernie.kek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Message> messageList;


    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_box, parent, false);
        return new MessageViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MessageViewHolder) holder).bodyTextView.setText(messageList.get(position).getBody());
        ((MessageViewHolder) holder).senderTextView.setText(messageList.get(position).getSender());
    }


    @Override
    public int getItemCount() {
        return messageList.size();
    }
    public class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView bodyTextView, senderTextView;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            bodyTextView = itemView.findViewById(R.id.body);
            senderTextView = itemView.findViewById(R.id.sender);
        }
    }
}
