package com.toune.myapp.helper

import java.io.Serializable

class ResponseData<T> : Serializable {

    var error_code: Int = 0
    var reason: String? = null
    var result: T? = null

    companion object {

        private const val serialVersionUID = 5213230387175987834L
    }
}