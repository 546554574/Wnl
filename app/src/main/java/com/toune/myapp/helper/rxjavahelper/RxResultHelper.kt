package com.toune.myapp.helper.rxjavahelper


import com.toune.myapp.helper.ResponseData
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.functions.Function

/**
 * user：lqm
 * desc：Rx处理服务器返回,
 * 服务器的返回的数据格式一般都是一致的，所有我们每个网络请求都可以使
 * 用compose(RxResultHelper.handleResult())来处理服务器返回，一般服务器返回成功码为200，
 * 相应改一下返回码的判断就行了
 */

object RxResultHelper {

    private const val RESPONSE_SUCCESS_CODE = 0 //大部分为200
    private const val RESPONSE_ERROR_CODE = -1


    fun <T> handleResult(): ObservableTransformer<ResponseData<T>, T> {
        return ObservableTransformer { tObservable ->
            tObservable.flatMap { tResponseData ->
                //可以相应更改
                if (tResponseData.error_code == RESPONSE_SUCCESS_CODE) {
                    Observable.just(tResponseData.result!!)
                } else if (tResponseData.error_code == RESPONSE_ERROR_CODE) {
                    Observable.error(Exception(tResponseData.reason))
                } else {
                    Observable.empty()
                }
            }
        }
    }

}
