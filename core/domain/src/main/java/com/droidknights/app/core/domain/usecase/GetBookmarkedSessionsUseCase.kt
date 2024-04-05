package com.droidknights.app.core.domain.usecase

import com.droidknights.app.core.model.Session
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class GetBookmarkedSessionsUseCase @Inject constructor(
    private val getSessionsUseCase: GetSessionsUseCase,
    private val getBookmarkedSessionIdsUseCase: GetBookmarkedSessionIdsUseCase,
) {

    suspend operator fun invoke(): Flow<List<Session>> =
        combine(
            getSessionsUseCase(),
            getBookmarkedSessionIdsUseCase()
        ) { allSession, bookmarkedSessions ->
            allSession
                .filter { session -> bookmarkedSessions.contains(session.id) }
                .sortedBy { it.startTime }
        }
}