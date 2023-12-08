package com.np.sanjaykhatri.merosathi.network

import com.np.sanjaykhatri.merosathi.features.shared.model.response.NotificationResponse
import com.np.sanjaykhatri.merosathi.utils.constants.APIConstants
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(APIConstants.SEND_NOTIFICATION)
    suspend fun sendNotification(
        @Body requestBody: RequestBody,
    ): Response<NotificationResponse>
}