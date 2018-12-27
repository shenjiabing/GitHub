package com.tsutsuku.githubdemo;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.oushangfeng.pinnedsectionitemdecoration.utils.FullSpanUtil;


import java.util.List;


/**
 * Created by IT小蔡 on 2017-12-29.
 */

public class StickAdapter extends BaseMultiItemQuickAdapter<BillSectionBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public StickAdapter(List<BillSectionBean> data) {
        super(data);

        addItemType(BillSectionBean.TYPE_HEADER, R.layout.item_head);
        addItemType(BillSectionBean.TYPE_DATA,R.layout.item_content);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        FullSpanUtil.onAttachedToRecyclerView(recyclerView, this, BillSectionBean.TYPE_HEADER);
    }

    @Override
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        FullSpanUtil.onViewAttachedToWindow(holder, this, BillSectionBean.TYPE_HEADER);
    }


    @Override
    protected void convert(BaseViewHolder helper, BillSectionBean item) {
            switch (helper.getItemViewType()){
                case BillSectionBean.TYPE_HEADER:
                    helper.setText(R.id.tv_month,item.header).addOnClickListener(R.id.tv_allSelect);

                    break;
                case BillSectionBean.TYPE_DATA:

                    BillListItemBean bean = item.t;
                    helper.setImageResource(R.id.iv_select,bean.isCheckItem()?R.drawable.address_icon_select_press:R.drawable.address_icon_select_normal);
                    helper.setText(R.id.tv_time,bean.getName()+"===="+bean.getTime()).addOnClickListener(R.id.iv_select);

                    break;


            }
    }



}
