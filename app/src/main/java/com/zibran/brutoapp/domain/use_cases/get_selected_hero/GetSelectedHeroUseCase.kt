package com.zibran.brutoapp.domain.use_cases.get_selected_hero

import com.zibran.brutoapp.data.repository.Repository
import com.zibran.brutoapp.domain.model.Hero

class GetSelectedHeroUseCase(private val repository: Repository) {

    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}