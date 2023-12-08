package com.np.sanjaykhatri.merosathi.features.shared.repository.auth

import com.google.firebase.auth.FirebaseAuth
import com.np.sanjaykhatri.merosathi.network.FirebaseService
import javax.inject.Inject

class SharedRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
){
    fun getUserId() = firebaseAuth.currentUser?.uid ?: ""

    fun signOut() = firebaseAuth.signOut()
}