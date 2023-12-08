package com.np.sanjaykhatri.merosathi.features.ui.viewmodel.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.np.sanjaykhatri.merosathi.features.application.MyApplication
import com.np.sanjaykhatri.merosathi.features.shared.model.User
import com.np.sanjaykhatri.merosathi.features.ui.viewmodel.base.BaseViewModel
import com.np.sanjaykhatri.merosathi.utils.coroutines.Resource
import com.np.sanjaykhatri.merosathi.utils.extensions.hasInternetConnection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    @Named("userDatabase")
    private val userDatabase: DatabaseReference,
    application: MyApplication,
) : BaseViewModel(application) {

    private val _userState = MutableStateFlow<Resource<User>>(Resource.Empty())
    val isUploading = MutableLiveData(false)
    val userState = _userState

    fun updateProfileDetails(name: String, about: String, lookingFor: String) =
        viewModelScope.launch {
            val userId = firebaseAuth.uid
            userId?.let {
                if (context.hasInternetConnection()) {
                    isUploading.value = true
                    userDatabase.child("$userId/about").setValue(about)
                    userDatabase.child("$userId/name").setValue(name)
                    userDatabase.child("$userId/lookingFor").setValue(lookingFor)
                        .addOnCompleteListener { event ->
                            if (event.isSuccessful) {
                                isUploading.value = false
                                _userState.value = Resource.Success(
                                    data = User()
                                )
                            }
                        }
                        .addOnFailureListener {
                            isUploading.value = false
                            _userState.value = Resource.Error(
                                it.message ?: "Some Error Occurred"
                            )
                        }
                } else {
                    isUploading.value = false
                    _userState.value = Resource.Error("No internet connection")
                }
            }
        }
}