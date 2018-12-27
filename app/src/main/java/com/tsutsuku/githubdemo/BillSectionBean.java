package com.tsutsuku.githubdemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by Administrator on 2018/12/27.
 */

public class BillSectionBean extends SectionEntity<BillListItemBean> implements MultiItemEntity {


    public static final int TYPE_HEADER = 1;
    public static final int TYPE_DATA = 2;

    private boolean check;

    public BillSectionBean(boolean isHeader, String header) {
        super(isHeader, header);
    }


    public BillSectionBean(BillListItemBean billListItemBean) {
        super(billListItemBean);
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    /**
     * 作为悬浮标题 才 implements MultiItemEntity，否则，不用复用
     * @return
     */
    @Override
    public int getItemType() {
        return isHeader ? TYPE_HEADER : TYPE_DATA;
    }
}
