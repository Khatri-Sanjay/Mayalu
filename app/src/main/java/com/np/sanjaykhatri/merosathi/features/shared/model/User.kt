package com.np.sanjaykhatri.merosathi.features.shared.model

data class User(
    var uid: String? = null,
    var name: String? = null,
    var age: Int? = null,
    var gender: String? = null,
    var lookingFor: String? = null,
    var about: String? = null,
    var profilePhotoUrl: String? = null,
    var token: String? = null,
    var verified: Boolean? = null,
    var latitude: Double? = null,
    var longitude: Double? = null
)
