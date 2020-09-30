package com.lfj.selfstudydemo.map

import android.widget.Toast
import com.lfj.selfstudydemo.MapUtil
import com.lfj.selfstudydemo.R
import com.lfj.selfstudydemo.mvvm.BaseActivity
import com.lfj.selfstudydemo.mvvm.util.GlobalUtil
import kotlinx.android.synthetic.main.activity_third_map.*

class ThirdMapActivity : BaseActivity() {


    override fun layoutView() = R.layout.activity_third_map

    override fun initUI() {
    }


    //这里的经纬度是直接获取的，在实际开发中从应用的地图中获取经纬度;
    private val latx = 39.9037448095
    private val laty = 116.3980007172
    private val mAddress = "北京天安门"

    override fun initData() {

        GlobalUtil.setOnClickListener(gaode_map,baidu_map,tencent_map,google_map){
            when(this){
                google_map ->{

                    if (MapUtil.isGoogleMapInstalled()) {
                        MapUtil.openGoogleMap(activity, 0.0, 0.0, null, latx, laty, mAddress);
                    } else {
                        //这里必须要写逻辑，不然如果手机没安装该应用，程序会闪退，这里可以实现下载安装该地图应用
                        Toast.makeText(activity, "尚未安装谷歌", Toast.LENGTH_SHORT).show()
                    }
                }
                tencent_map ->{

                    if (MapUtil.isTencentMapInstalled()) {
                        MapUtil.openTencentMap(activity, 0.0, 0.0, null, latx, laty, mAddress);
                    } else {


                        //这里必须要写逻辑，不然如果手机没安装该应用，程序会闪退，这里可以实现下载安装该地图应用
                        Toast.makeText(activity, "尚未安装腾讯地图", Toast.LENGTH_SHORT).show()
                    }
                }
                baidu_map ->{

                    if (MapUtil.isBaiduMapInstalled()) {
                        MapUtil.openBaiDuNavi(activity, 0.0, 0.0, null, latx, laty, mAddress);
                    } else {
                        //这里必须要写逻辑，不然如果手机没安装该应用，程序会闪退，这里可以实现下载安装该地图应用
                        Toast.makeText(activity, "尚未安装百度地图", Toast.LENGTH_SHORT).show()
                    }
                }
                gaode_map ->{
                    if (MapUtil.isGdMapInstalled()) {
                        MapUtil.openGaoDeNavi(activity, 0.0, 0.0, null, latx, laty, mAddress);
                    } else {
                        //这里必须要写逻辑，不然如果手机没安装该应用，程序会闪退，这里可以实现下载安装该地图应用
                        Toast.makeText(activity, "尚未安装高德地图", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }
    }
}