package com.example.word;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> wordlist = new ArrayList<>();
    private MyDatabaseHelper wordDatabase;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordDatabase = new MyDatabaseHelper(this,"WordDatabase.db", null, 4);


//        Button createDatabase = (Button) findViewById(R.id.create_database);//第一次点击时，会自动检测是否有WordDatabase.db这个数据库，没有则自动创建（表也被创建出来）
//        createDatabase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                wordDatabase.getWritableDatabase();
//            }
//        });
//        //数据库中插入数据
//        Button addword = (Button)findViewById(R.id.insertWord);
//        addword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SQLiteDatabase db = wordDatabase.getWritableDatabase();
//                ContentValues values = new ContentValues();
//                values.put("word","apple");
//                values.put("meaning","苹果");
//                db.insert("WordTable",null,values);
//                values.put("word","cat");
//                values.put("meaning","猫");
//                db.insert("WordTable",null,values);
//                values.put("word","banana");
//                values.put("meaning","香蕉");
//                db.insert("WordTable",null,values);
//                values.put("word","pig");
//                values.put("meaning","猪");
//                db.insert("WordTable",null,values);
//                Toast.makeText(MainActivity.this, "Create succeeded", Toast.LENGTH_SHORT).show();//提示创建成功
//            }
//        });
        //将数据库中的数据读取到Arraylist中并listView显示出来
        SQLiteDatabase sd = wordDatabase.getReadableDatabase();
        Cursor cursor = sd.rawQuery("select * from WordTable",null);
        while (cursor.moveToNext()){

            String strword = cursor.getString(cursor.getColumnIndex("word"));
            wordlist.add(strword);
//            String strwordmeaning= cursor.getString(cursor.getColumnIndex("wordmeaing"));
//            wordInfo st = new wordInfo(strword,strwordmeaning);
//            wordlist.add(wordInfo);

        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, wordlist);
        listView = (ListView) findViewById(R.id.list_view);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {//长按单词出现菜单



//                PopupMenu popupMenu = new PopupMenu();


//                new AlertDialog.Builder(MainActivity.this)
//                        .setIcon(android.R.drawable.sym_def_app_icon)
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//
//                            }
//                        }).setPositiveButton("修改", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                }).show();
//                                        String word = wordlist.get(position);
//                Toast.makeText(MainActivity.this,"succeed",Toast.LENGTH_SHORT).show();

            }
        });
        ItemOnLongClick1();
    }

    private void ItemOnLongClick1() {

        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

                contextMenu.add(0,0,0,"删除");
                contextMenu.add(0,1,0,"修改");
            }
        });

    }

    public  boolean onContextItemSelected(MenuItem item){//点击菜单选项实现相应操作

        SQLiteDatabase db = wordDatabase.getWritableDatabase();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        int wordid = (int) info.id;
        switch (item.getItemId()){
            case 0:
                String[] where = {wordlist.get(wordid)};
                db.delete("WordTable","word=?",where);
                wordlist.remove(wordid);
                Toast.makeText(this, "delete succeeded", Toast.LENGTH_SHORT).show();//提示删除成功
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,wordlist);
                ListView listView = (ListView) findViewById(R.id.list_view);
                listView.setAdapter(adapter);
                break;
            case 1:
                final String[] where1={wordlist.get(wordid)};
                final int c=wordid;
                final EditText edit = new EditText(this);
//                 final EditText et = new EditText(this);
                //final String[] where1={date.get(MID)};
                //final int c=MID;
                edit.setText("");
                new AlertDialog.Builder(this).setTitle("请输入修改单词：")
                        .setIcon(android.R.drawable.sym_def_app_icon)
                        .setView(edit)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String a=edit.getText().toString();
                                SQLiteDatabase db = wordDatabase.getWritableDatabase();
                                ContentValues values=new ContentValues();
                                values.put("word",a);
                                db.update("WordTable",values,"word=?",where1);
                                wordlist.set(c,a);
                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,wordlist);
                                ListView listView = (ListView) findViewById(R.id.list_view);
                                listView.setAdapter(adapter);
                            }
                        }).setNegativeButton("取消",null).show();
                break;
            default:
                break;

        }
        return super.onContextItemSelected(item);
    }
//    private void setWordListView(ArrayList<Map<String,String>>items){
//        SimpleAdapter adapter = new SimpleAdapter(this,items,R.layout.activity_main,
//                new String[]{}
//    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.check_item:
                final EditText et = new EditText(this);
//                 final EditText et = new EditText(this);
                //final String[] where1={date.get(MID)};
                //final int c=MID;
                et.setText("");
                new AlertDialog.Builder(this).setTitle("请输入查询单词：")
                        .setIcon(android.R.drawable.sym_def_app_icon)
                        .setView(et)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                String a=et.getText().toString();
                                String[] where={et.getText().toString()};

                                SQLiteDatabase db = wordDatabase.getWritableDatabase();
                                // Cursor cursor = db.query("WordTable",null,null,null,null,null,null);
                                Cursor cursor =  db.query("WordTable",new String[]{"word,meaning"},"word=?",where,null,null,null);
                                if(cursor.moveToFirst()){
                                    do {
                                        String word = cursor.getString(cursor.getColumnIndex("word"));
                                        String meaning = cursor.getString(cursor.getColumnIndex("meaning"));
                                        wordlist.clear();
                                        wordlist.add(word);
                                        wordlist.add(meaning);
                                    }while (cursor.moveToNext());
                                }
                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,wordlist);
                                ListView listView = (ListView) findViewById(R.id.list_view);
                                listView.setAdapter(adapter);
                            }
                        }).setNegativeButton("取消",null).show();
//                Intent intent = new Intent(MainActivity.this, CheckActivity.class);//实现点击菜单选项启动相应活动
//                startActivity(intent);
                //checkDialog();
//                Toast.makeText(this,"check",Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_item:
                final EditText edit = new EditText(this);
//                 final EditText et = new EditText(this);
                //final String[] where1={date.get(MID)};
                //final int c=MID;
                edit.setText("");
                new AlertDialog.Builder(this).setTitle("请输入添加                                                                                                                                                   单词：")
                        .setIcon(android.R.drawable.sym_def_app_icon)
                        .setView(edit)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String a=edit.getText().toString();
                                SQLiteDatabase db = wordDatabase.getWritableDatabase();
                                ContentValues values=new ContentValues();
                                values.put("word",a);
                                db.insert("WordTable",null,values);
                                wordlist.add(a);
                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,wordlist);
                                ListView listView = (ListView) findViewById(R.id.list_view);
                                listView.setAdapter(adapter);
                            }
                        }).setNegativeButton("取消",null).show();
                break;
            default:
        }
        return true;
    }
    //创建数据库的同时创建表

    public class MyDatabaseHelper extends SQLiteOpenHelper {
        final String CREATE_WORD = "create table WordTable ("//创建表并定义为字符串常量
                + "word String,"
                + "meaning String)";

        private Context mContext;
        public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

            super(context, name, factory, version);

            mContext = context;

        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_WORD);
            Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();//提示创建成功
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists WordTable");
            onCreate(db);

        }
    }


}