package com.lfj.selfstudydemo.diffUtil

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lfj.selfstudydemo.R


/**
 * @description
 * @author LFJ
 * @date   2020/10/28 10:23
 */
class DiffAdapter : BaseQuickAdapter<UserBean, BaseViewHolder>(R.layout.item_diff_recycler) {

    override fun convert(holder: BaseViewHolder, item: UserBean) {
        holder.setText(R.id.tvName, item.name)
            .setText(R.id.tvAge, item.age)
    }

    override fun setDiffNewData(list: MutableList<UserBean>?) {
        super.setDiffNewData(list)
    }

}