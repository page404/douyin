package com.yuxie.demo.listandrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.yuxie.demo.R;
import com.yuxie.demo.commonadapter.listview.CommonAdapter;
import com.yuxie.demo.listandrecycler.adapter.lv.ChatAdapter;
import com.yuxie.demo.listandrecycler.bean.ChatMessage;


public class MultiItemListViewActivity extends AppCompatActivity
{

    private ListView mListView;
    private CommonAdapter mAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_and_recycler);

        mListView = (ListView) findViewById(R.id.id_listview_list);
        mListView.setDivider(null);
        mListView.setAdapter(new ChatAdapter(this, ChatMessage.MOCK_DATAS));

    }

}
