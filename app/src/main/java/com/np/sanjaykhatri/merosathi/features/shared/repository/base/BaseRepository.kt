package com.np.sanjaykhatri.merosathi.features.shared.repository.base

import com.np.sanjaykhatri.merosathi.utils.util.GlobalUtil
import okhttp3.RequestBody

abstract class BaseRepository {
    fun getGlobalUtils(any: Any): RequestBody =
        GlobalUtil.buildGson(any)
}