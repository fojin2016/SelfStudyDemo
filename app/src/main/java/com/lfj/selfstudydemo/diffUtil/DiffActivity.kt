package com.lfj.selfstudydemo.diffUtil

import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.lfj.selfstudydemo.R
import com.lfj.selfstudydemo.Yr
import com.lfj.selfstudydemo.mvvm.BaseActivity
import kotlinx.android.synthetic.main.activity_diff.*
import java.util.*

class DiffActivity : BaseActivity() {


    private val adapter: DiffAdapter by lazy {
        DiffAdapter()
    }

    private val list = mutableListOf<UserBean>()
    private val newList = mutableListOf<UserBean>()
    override fun layoutView() = R.layout.activity_diff


    val callback = object : DiffUtil.Callback() {


        override fun getOldListSize() = list.size

        override fun getNewListSize() = newList.size

        //分别获取新老列表中对应位置的元素
        //定义什么情况下新老元素是同一个对象（通常是业务id）true ==>areContentsTheSame
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            Yr.d()
            return list[oldItemPosition].name == newList[newItemPosition].name
        }

        // 定义什么情况下同一对象内容是否相同 (由业务逻辑决定) false ==>getChangePayload
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

            Yr.d(list[oldItemPosition].age == newList[newItemPosition].age)
            return list[oldItemPosition].age == newList[newItemPosition].age
        }

        // 具体定义同一对象内容是如何地不同 (返回值会作为payloads传入onBindViewHoder())
        //需要变换的东西
        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            Yr.d()
            return newList[newItemPosition]
        }

    }

    override fun initUI() {
        btnSure.setOnClickListener {
            Yr.d()
            var position = edPosition.text.toString()
            var age = edValue.text.toString()

            newList[position.toInt()].age = age

            // 2.进行比对并输出结果
            val diffResult = DiffUtil.calculateDiff(callback)
            // 3. 将比对结果应用到 adapter
            diffResult.dispatchUpdatesTo(AdapterListUpdateCallback(adapter))
        }
    }


    override fun initData() {

        diffRecycler.layoutManager = LinearLayoutManager(this)
        diffRecycler.adapter = adapter

        for (index in 0..50) {
            var bean = UserBean("张三$index", (1..100).random().toString())
            list.add(bean)

            newList.add(bean.copy())
        }



        adapter.setNewInstance(list)

    }
}