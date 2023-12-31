package com.np.sanjaykhatri.merosathi.features.ui.viewmodel.auth

import androidx.lifecycle.ViewModel
import com.np.sanjaykhatri.merosathi.features.shared.repository.auth.SignUpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpRepository: SignUpRepository
) : ViewModel() {
    fun createUser(email: String?, password: String?) = signUpRepository.createUser(email, password)
    fun createUserReferenceInRealtimeDatabase(userId: String) =
        signUpRepository.createUserReferenceInRealtimeDatabase(userId)
}