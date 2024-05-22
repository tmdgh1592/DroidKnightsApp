package com.droidknights.app.feature.session.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.droidknights.app.core.model.Session
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Stable
sealed interface SessionUiState {

    @Immutable
    data object Loading : SessionUiState

    @Immutable
    data class Sessions(
        val sessions: ImmutableList<Session> = persistentListOf(),
    ) : SessionUiState
}
