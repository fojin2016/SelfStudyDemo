package com.lfj.selfstudydemo.scroll

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lfj.selfstudydemo.R

/**
 * @author
 * @date
 */
class ScrollAdapter : BaseQuickAdapter<String, BaseViewHolder> {


    constructor(data: MutableList<String>?) : super(R.layout.item_recycler, data)


    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.itemName, item)

    }
}