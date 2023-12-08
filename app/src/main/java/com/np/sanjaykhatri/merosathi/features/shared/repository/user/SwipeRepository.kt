package com.np.sanjaykhatri.merosathi.features.shared.repository.user

import com.np.sanjaykhatri.merosathi.features.shared.model.request.NotificationRequest
import com.np.sanjaykhatri.merosathi.features.shared.repository.base.BaseRepository
import com.np.sanjaykhatri.merosathi.network.ApiService
import javax.inject.Inject

class SwipeRepository @Inject constructor(
    private val apiService: ApiService,
) : BaseRepository() {
    suspend fun sendMatchedNotification(notificationRequest: NotificationRequest) =
        apiService.sendNotification(getGlobalUtils(notificationRequest))
}