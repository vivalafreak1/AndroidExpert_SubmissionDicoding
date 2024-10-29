package com.arieftaufikrahman.wibuapp.domain.usecases.app_entry

import com.arieftaufikrahman.wibuapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

    operator fun invoke(): Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}