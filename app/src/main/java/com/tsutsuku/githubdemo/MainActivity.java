package com.tsutsuku.githubdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.oushangfeng.pinnedsectionitemdecoration.PinnedHeaderItemDecoration;
import com.oushangfeng.pinnedsectionitemdecoration.callback.OnHeaderClickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    StickAdapter mAdapter;
    RecyclerView mRecyclerView;

    private List<BillSectionBean> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRecyclerView = this.findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter =new StickAdapter(null);
        mRecyclerView.setAdapter(mAdapter);
        ((SimpleItemAnimator)mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        initData();
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                BillSectionBean item=mAdapter.getData().get(position);
                switch (view.getId()){
                    case R.id.tv_allSelect:
                        if (item.isHeader){
                            Toast.makeText(MainActivity.this,"您点击了"+item.header,Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.iv_select:
                        if (!item.isHeader){
                            item.t.setCheckItem(!item.t.isCheckItem());
                            mRecyclerView.getAdapter().notifyItemChanged(position);
                        }

                        break;
                }
            }
        });

        OnHeaderClickAdapter clickAdapter = new OnHeaderClickAdapter() {

            @Override
            public void onHeaderClick(View view, int id, int position) {
                switch (id) {
                    case R.id.tv_allSelect:
                        // case OnItemTouchListener.HEADER_ID:
                        Toast.makeText(MainActivity.this,"您点击了悬浮的标题",Toast.LENGTH_SHORT).show();
                        break;
                }
            }

        };
        PinnedHeaderItemDecoration mHeaderItemDecoration = new PinnedHeaderItemDecoration.Builder(BillSectionBean.TYPE_HEADER).
                setDividerId(R.drawable.divider).
                enableDivider(false) //开关分割线
                .setClickIds(R.id.tv_allSelect)
                .disableHeaderClick(false)
                .setHeaderClickListener(clickAdapter)
                .create();

        mRecyclerView.addItemDecoration(mHeaderItemDecoration);



    }


    private void initData(){
        for (int i = 5; i < 10; i++) {
            BillSectionBean billSectionBean1=new BillSectionBean(true,i+"月");
            data.add(billSectionBean1);


            for (int j = 1; j < 11; j++) {
                BillListItemBean itemBean=new BillListItemBean();
                itemBean.setMonth(billSectionBean1.header);
                itemBean.setTime("2012-10-20 10:10:10");
                itemBean.setName(billSectionBean1.header+""+j+"日");

                BillSectionBean billSectionBean2 = new BillSectionBean(itemBean);
                data.add(billSectionBean2);
            }
        }
        mAdapter.setNewData(data);
    }
}
