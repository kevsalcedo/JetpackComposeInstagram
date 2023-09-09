package com.ketchup.jetpackcomposeinstagram.login.domain

import com.ketchup.jetpackcomposeinstagram.login.data.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(
        user: String,
        password: String
    ): Boolean {
        return repository.doLogin(user, password)
    }
}