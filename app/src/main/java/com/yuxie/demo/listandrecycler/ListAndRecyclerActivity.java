package com.yuxie.demo.listandrecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yuxie.demo.R;
import com.yuxie.demo.commonadapter.listview.CommonAdapter;
import com.yuxie.demo.commonadapter.listview.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAndRecyclerActivity extends AppCompatActivity
{
    private List<String> mDatas = new ArrayList<>(Arrays.asList("MultiItem ListView",
            "RecyclerView",
            "MultiItem RecyclerView"));
    private ListView mListView;

    private View mEmptyView ;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_and_recycler);

        mListView = ((ListView) findViewById(R.id.id_listview_list));
        mEmptyView = findViewById(R.id.id_empty_view);
        mListView.setAdapter(new CommonAdapter<String>(this, R.layout.item_list, mDatas)
        {
            @Override
            public void convert(ViewHolder holder, String o, int pos)
            {
                holder.setText(R.id.id_item_list_title, o);
            }

            @Override
            public void onViewHolderCreated(ViewHolder holder, View itemView)
            {
                super.onViewHolderCreated(holder, itemView);
            }
        });

        mListView.setEmptyView(mEmptyView);
//        TextView t1 = new TextView(this);
//        t1.setText("Header 1");
//        TextView t2 = new TextView(this);
//        t2.setText("Header 2");
//        mListView.addHeaderView(t1);
//        mListView.addHeaderView(t2);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = null;
                switch (position)
                {
                    case 0:
                    default:
                        intent = new Intent(ListAndRecyclerActivity.this, MultiItemListViewActivity.class);
                        break;
                    case 1:
                        intent = new Intent(ListAndRecyclerActivity.this, RecyclerViewActivity.class);
                        break;
                    case 2:
                        intent = new Intent(ListAndRecyclerActivity.this, MultiItemRvActivity.class);
                        break;

                }
                if (intent != null)
                    startActivity(intent);
            }
        });
    }


}
