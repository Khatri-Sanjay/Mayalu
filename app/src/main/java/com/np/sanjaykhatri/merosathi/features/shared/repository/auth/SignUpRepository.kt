package com.np.sanjaykhatri.merosathi.features.shared.repository.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.np.sanjaykhatri.merosathi.utils.constants.FirebaseConstant
import javax.inject.Inject
import javax.inject.Named

class SignUpRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    @Named("userDatabase")
    private val userDatabase: DatabaseReference
) {
    fun createUser(email: String?, password: String?) =
        email?.let { emailNotNull ->
            password?.let { passwordNotNull ->
                firebaseAuth.createUserWithEmailAndPassword(emailNotNull, passwordNotNull)
            }
        }

    fun createUserReferenceInRealtimeDatabase(userId: String) = userDatabase
        .child(userId)
        .child(FirebaseConstant.IS_VERIFIED)
        .setValue(false)
}