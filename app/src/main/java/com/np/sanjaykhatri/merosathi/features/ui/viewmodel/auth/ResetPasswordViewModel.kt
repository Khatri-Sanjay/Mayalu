package com.np.sanjaykhatri.merosathi.features.ui.viewmodel.auth

import androidx.lifecycle.ViewModel
import com.np.sanjaykhatri.merosathi.features.shared.repository.auth.ResetPasswordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(
    private val resetPasswordRepository: ResetPasswordRepository
) : ViewModel() {
    fun checkIfUserExists(email: String) = resetPasswordRepository.checkIfUserExists(email)

    fun sendPasswordResetLink(email: String) = resetPasswordRepository.sendPasswordResetLink(email)
}