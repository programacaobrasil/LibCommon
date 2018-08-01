package com.programacaobrasil.lib.common.Configs

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.programacaobrasil.lib.common.Interfaces.IRequestResult

class FirebaseConfig {
    companion object {
        private var databaseReference: DatabaseReference? = null
        private var firebaseAuth: FirebaseAuth? = null
        private var firebaseStorage: FirebaseStorage? = null

        fun getDatabaseReference(): DatabaseReference {
            if (databaseReference == null) {
                val firebaseDatabase = FirebaseDatabase.getInstance()
                firebaseDatabase.setPersistenceEnabled(true)

                databaseReference = firebaseDatabase.reference
            }

            return databaseReference!!
        }

        fun getFirebaseAuth(): FirebaseAuth {
            if (firebaseAuth == null) {
                firebaseAuth = FirebaseAuth.getInstance()
            }

            return firebaseAuth!!
        }

        fun getFirebaseStorage(): FirebaseStorage {
            if (firebaseStorage == null) {
                firebaseStorage = FirebaseStorage.getInstance()
            }

            return firebaseStorage!!
        }

        fun signOutAll(iRequestResult: IRequestResult) {
            firebaseAuth!!.signOut()
            iRequestResult.onComplete(null)
        }
    }
}