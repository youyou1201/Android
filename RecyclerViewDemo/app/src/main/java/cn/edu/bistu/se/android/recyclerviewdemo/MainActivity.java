package cn.edu.bistu.se.android.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.edu.bistu.se.android.recyclerviewdemo.model.UserMessage;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private UserMessageAdapter mUserWordMessageAdapter;
    private EditText mEditTextUserWordMessage;
    private List<UserMessage> mUserWordMessageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextUserWordMessage = findViewById(R.id.edittextUserMessage);
        mUserWordMessageList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.recyclerview);
        mUserWordMessageAdapter = new UserMessageAdapter(mUserWordMessageList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mUserWordMessageAdapter);
    }

    /**
     * 用户按下消息发送按钮时发送消息
     * @param view
     */
    public void onButtonSendMessageClick(View view) {
        String content = mEditTextUserWordMessage.getText().toString();
        content = content.trim();
        if (content.length() == 0) {
            Toast.makeText(this, "文本内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        addSendMessage(content);

        /**
         * 这里模拟接收对方发送的消息，在实际程序中，应该定时从网络获得相关数据
         */

        addReceiveMessage("我接收到"+content);
    }

    /**
     * 增加接收消息
     * @param content
     */
    private void addReceiveMessage(String content) {
        UserMessage userWordMessage = new UserMessage(content, UserMessage.TYPE_RECEIVE);
        mUserWordMessageList.add(userWordMessage);

        // 表示在消息的末尾插入内容
        mUserWordMessageAdapter.notifyItemInserted(mUserWordMessageList.size() - 1);

        // 让 RecyclerView 自动滚动到最底部
        mRecyclerView.scrollToPosition(mUserWordMessageList.size() - 1);


        mEditTextUserWordMessage.setText("");
    }

    /**
     * 增加发送消息
     * @param content
     */
    private void addSendMessage(String content) {
        UserMessage userWordMessage = new UserMessage(content, UserMessage.TYPE_SEND);
        mUserWordMessageList.add(userWordMessage);

        // 表示在消息的末尾插入内容
        mUserWordMessageAdapter.notifyItemInserted(mUserWordMessageList.size() - 1);

        // 让 RecyclerView 自动滚动到最底部
        mRecyclerView.scrollToPosition(mUserWordMessageList.size() - 1);


        mEditTextUserWordMessage.setText("");
    }
}