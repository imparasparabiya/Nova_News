package com.example.novanews.Helper

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class AuthHelper {

        companion object {
            val authHelper = AuthHelper()
        }

        var auth = Firebase.auth

    fun singUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            Log.e(TAG, "singUp: Successfully....")
        }.addOnFailureListener {
            Log.e(TAG, "singUp: Failed....")
        }
    }
  suspend fun logIn(email: String, password: String) : String? {
            var msg: String? = null
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            Log.e(TAG, "Login: Successfully....", )
            msg = "Successfully"
        }.addOnFailureListener {
            Log.e(TAG, "Login: Failed....")
            msg = it.message
        }.await()

        return msg
    }

    fun logOut() {
        TODO("Log Out Butten Click")
        FirebaseAuth.getInstance().signOut()
    }

}