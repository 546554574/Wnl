package com.toune.myapp.ui.view

import com.toune.myapp.base.BaseView
import com.toune.myapp.ui.model.TestVo
import com.toune.myapp.ui.model.TodayOfHis

interface MainView : BaseView {
    fun getVideoList(testVo: TestVo)
    fun setTodayOfHis(todayOfHisList: List<TodayOfHis>)
}
