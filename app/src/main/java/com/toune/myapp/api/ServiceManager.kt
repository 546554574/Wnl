package com.toune.myapp.api

import com.google.gson.reflect.TypeToken
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.HttpParams
import com.lzy.okrx2.adapter.ObservableBody
import com.toune.myapp.base.AppConstant
import com.toune.myapp.helper.JsonConvert
import com.toune.myapp.helper.ResponseData
import com.toune.myapp.ui.model.TestVo
import com.toune.myapp.ui.model.TodayOfHis
import com.toune.myapp.ui.model.UpdateAppVo
import com.toune.myapp.ui.model.WnlVo
import io.reactivex.Observable
import java.lang.reflect.Type

object ServiceManager {
    var Token = ""
    const val BaseUrl = "http://pay-forum.zydl-tec.cn"
    const val UpdateApp = "$BaseUrl/v1/app/my/check_version" //更新APP
    const val TestUrl = "$BaseUrl/v1/app/videos/list"
    const val TodayOfHistoryUrl = "http://api.juheapi.com/japi/toh"  //历史上的今天
    const val WnlUrl = "http://v.juhe.cn/calendar/day" //万年历

    fun getVideo(): Observable<ResponseData<TestVo>> {
        return OkGo.get<ResponseData<TestVo>>(TestUrl)
            .converter(
                object : JsonConvert<ResponseData<TestVo>>() {

                })
            .adapt(ObservableBody())
    }

    fun updateApp(): Observable<ResponseData<UpdateAppVo>> {
        return OkGo.get<ResponseData<UpdateAppVo>>(UpdateApp)
            .params("client", "android")
            .converter(object : JsonConvert<ResponseData<UpdateAppVo>>() {})
            .adapt(ObservableBody())
    }

    fun todayOfHistory(month: Int, day: Int): Observable<ResponseData<List<TodayOfHis>>> {
        var httpParams = HttpParams()
        httpParams.put("key", AppConstant.JUHE_TODAY_OF_HIS_KEY)
        httpParams.put("v", "1.0")
        httpParams.put("month", month)
        httpParams.put("day", day)
        return OkGo.get<ResponseData<List<TodayOfHis>>>(TodayOfHistoryUrl)
            .params(httpParams)
            .converter(object : JsonConvert<ResponseData<List<TodayOfHis>>>() {})
            .adapt(ObservableBody())
    }

    fun wnl(date: String): Observable<ResponseData<WnlVo>> {
        var httpParams = HttpParams()
        httpParams.put("key", AppConstant.JUHE_WNL_KEY)
        httpParams.put("date", date)
        return OkGo.get<ResponseData<WnlVo>>(WnlUrl)
            .params(httpParams)
            .converter(object : JsonConvert<ResponseData<WnlVo>>() {})
            .adapt(ObservableBody())
    }
}
