package cn.edu.bistu.se.android.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.edu.bistu.se.android.recyclerviewdemo.model.UserMessage;

public class UserMessageAdapter extends RecyclerView.Adapter<UserMessageAdapter.UserMessageViewHolder> {

    private final List<UserMessage> mUserWordMessageList;


    UserMessageAdapter(List<UserMessage> userWordMessageList) {
        mUserWordMessageList = userWordMessageList;
    }

    @Override
    public int getItemViewType(int position) {
        UserMessage msg = mUserWordMessageList.get(position);
        return msg.getType();
    }

    @NonNull
    @Override
    public UserMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == UserMessage.TYPE_RECEIVE) {
            //用户接收的消息，显示在左侧
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_left_layout, parent, false);
            //    Log.v(GameSystem.LOG_TAG, "left view.toString():" + view.toString());
            return new UserMessageViewHolder(view);
        } else {
            //用户发送的消息，显示在右侧
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_right_layout, parent, false);
            return new UserMessageViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull UserMessageViewHolder holder, int position) {
        UserMessage msg = mUserWordMessageList.get(position);
        // 根据消息的类型来选择不同的布局
        if (msg.getType() == UserMessage.TYPE_RECEIVE) holder.tvLeft.setText(msg.getContent());
        else
            holder.tvRight.setText(msg.getContent());
    }

    @Override
    public int getItemCount() {
        return mUserWordMessageList.size();
    }

    class UserMessageViewHolder extends RecyclerView.ViewHolder {
        TextView tvLeft, tvRight;

        UserMessageViewHolder(@NonNull View itemView) {
            super(itemView);

            tvLeft = itemView.findViewById(R.id.user_message_leftText);
            tvRight = itemView.findViewById(R.id.user_message_rightText);


        }


    }
}
