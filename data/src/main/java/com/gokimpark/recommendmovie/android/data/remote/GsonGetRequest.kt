package com.gokimpark.recommendmovie.android.data.remote

import com.android.volley.NetworkResponse
import com.android.volley.ParseError
import com.android.volley.Response
import com.android.volley.toolbox.HttpHeaderParser
import com.android.volley.toolbox.JsonRequest
import com.google.gson.Gson
import java.nio.charset.Charset

internal class GsonGetRequest<T>(
    private val gson: Gson,
    private val cls: Class<T>,
    url: String,
    requestBody: String?,
    listener: Response.Listener<T>,
    errorListener: Response.ErrorListener
) : JsonRequest<T>(Method.GET, url, requestBody, listener, errorListener) {

    override fun parseNetworkResponse(response: NetworkResponse): Response<T> = try {
        val json = String(
            response.data ?: ByteArray(0),
            Charset.forName(HttpHeaderParser.parseCharset(response.headers))
        )
        Response.success(
            gson.fromJson(json, cls),
            HttpHeaderParser.parseCacheHeaders(response)
        )
    } catch (e: Exception) {
        Response.error(ParseError(e))
    }

    companion object{

        inline operator fun <reified T: Any> invoke(
            gson: Gson,
            url: String,
            requestBody: String?,
            listener: Response.Listener<T>,
            errorListener: Response.ErrorListener
        ) = GsonGetRequest(gson, T::class.java, url, requestBody, listener, errorListener)

    }

}