package com.toune.myapp.ui.view

import com.toune.myapp.base.BaseView
import com.toune.myapp.ui.model.TestVo
import com.toune.myapp.ui.model.TodayOfHis
import com.toune.myapp.ui.model.WnlVo

interface MainView : BaseView {
    fun getVideoList(testVo: TestVo)
    fun setTodayOfHis(todayOfHisList: List<TodayOfHis>)
    fun setWnl(wnl: WnlVo)
}
