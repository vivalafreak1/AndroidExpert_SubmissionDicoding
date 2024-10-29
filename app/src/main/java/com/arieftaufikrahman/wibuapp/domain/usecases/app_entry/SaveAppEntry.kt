package com.arieftaufikrahman.wibuapp.domain.usecases.app_entry

import com.arieftaufikrahman.wibuapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }

}