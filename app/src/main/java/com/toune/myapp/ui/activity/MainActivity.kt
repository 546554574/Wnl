package com.toune.myapp.ui.activity

import android.os.Bundle
import com.blankj.rxbus.RxBus
import com.bumptech.glide.Glide
import com.necer.calendar.NCalendar
import com.necer.entity.NDate
import com.necer.listener.OnCalendarChangedListener
import com.toune.myapp.R
import com.toune.myapp.base.BaseActivity
import com.toune.myapp.ui.model.TestVo
import com.toune.myapp.ui.model.TodayOfHis
import com.toune.myapp.ui.presenter.MainActivityPresenter
import com.toune.myapp.ui.view.MainView
import com.zhy.changeskin.SkinManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity<MainView, MainActivityPresenter>(), MainView {
    override fun setTodayOfHis(todayOfHisList: List<TodayOfHis>) {
        if (todayOfHisList.isNotEmpty()) {
            var todayOfHis: TodayOfHis = todayOfHisList[todayOfHisList.size - 1]
            today_of_history_tv.text = todayOfHis.title + "\n" + todayOfHis.des
            Glide.with(this).load(todayOfHis.pic).into(today_of_history_iv)
        }
    }

    override fun initPresenter(): MainActivityPresenter {
        return MainActivityPresenter()
    }

    override fun loadMore() {

    }

    override fun refreData() {
        mPresenter!!.getVideoList()
    }

    override fun init(savedInstanceState: Bundle?) {
//        mPresenter!!.getVideoList()
        var calendar: Calendar = Calendar.getInstance()
        var month = calendar!!.get(Calendar.MONTH)
        var day = calendar!!.get(Calendar.DAY_OF_MONTH)
        mPresenter!!.getTodayOfHis(month, day)
        var nCalendar: NCalendar = miuiCalendar
        nCalendar.setOnCalendarChangedListener(object : OnCalendarChangedListener {
            override fun onCalendarStateChanged(isMonthSate: Boolean) {
                //日历回调 NDate包含公历、农历、节气、节假日、闰年等信息
            }

            override fun onCalendarDateChanged(date: NDate?, isClick: Boolean) {
                //日历状态回调， 月->周 isMonthSate返回false ，反之返回true
                mPresenter!!.getTodayOfHis(date!!.localDate.monthOfYear, date!!.localDate.dayOfMonth)
            }

        })
        RxBus.getDefault().subscribe(this, object : RxBus.Callback<String>() {
            override fun onEvent(s: String) {
                SkinManager.getInstance().changeSkin("night")
            }
        })

        fab.setOnClickListener { onViewClicked() }
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun getTitleStr(): String {
        return "万年历"
    }

    override fun initEventAndData() {}

    override fun onDestroy() {
        super.onDestroy()
        RxBus.getDefault().unregister(this)
    }

    override fun getVideoList(testVo: TestVo) {
        //        Glide.with(context).load(testVo.getData().get(0).getVideos().getCover()).into(imgIv);
    }

    fun onViewClicked() {
//        RxActivityTool.skipActivity(context, WebActivity::class.java)
//        SkinManager.getInstance().changeSkin("night")
    }
}
