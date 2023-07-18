package com.zibran.brutoapp.domain.use_cases.save_onboarding

import com.zibran.brutoapp.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }

}