package com.lfj.selfstudydemo.secondList

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lfj.selfstudydemo.R
import kotlinx.android.synthetic.main.activity_second_recyclwe.*


class SecondRecyclerActivity : AppCompatActivity() {

    private val mRecyclerAdapter by lazy {
        var dataBeanList = arrayListOf<DataBean>()
        for (i in 1..50) {
            var dataBean = DataBean()
            dataBean.id = i.toString() + ""
            dataBean.type = 0
            dataBean.parentLeftTxt = "父--$i"
            dataBean.parentRightTxt = "父内容--$i"
            dataBean.childLeftTxt = "子--$i"
            dataBean.childRightTxt = "子内容--$i"
            dataBean.childBean = dataBean
            dataBeanList.add(dataBean)
        }

        RecyclerAdapter(this,dataBeanList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_recyclwe)
        setData()
    }


    private fun setData() {
        secondRecycler.layoutManager = LinearLayoutManager(this)
        secondRecycler.adapter = mRecyclerAdapter

        mRecyclerAdapter.setOnScrollListener {
            secondRecycler.scrollToPosition(it)
        }

        mRecyclerAdapter.setOnItemClick {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}