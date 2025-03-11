package com.example.taller1movil

import android.content.Context
import java.io.IOException
import java.io.InputStream



class MIscelanius {
    companion object {
        fun loadJSONFromAsset(context: Context, fileName: String): String? {
            var json: String? = null
            try {
                val isStream: InputStream = context.assets.open(fileName)
                val size = isStream.available()
                val buffer = ByteArray(size)
                isStream.read(buffer)
                isStream.close()
                json = String(buffer, charset("UTF-8"))
            } catch (ex: IOException) {
                ex.printStackTrace()
                return null
            }
            return json
        }
    }
}