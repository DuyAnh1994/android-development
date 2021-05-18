package com.dev.anhnd.android_note_todos.domain.note

import com.dev.anhnd.android_note_todos.data.model.Note
import com.dev.anhnd.android_note_todos.data.repository.NoteRepository
import com.dev.anhnd.mybase.utils.clean_architecture.BaseResponse
import com.dev.anhnd.mybase.utils.clean_architecture.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListNoteUserCase @Inject constructor(
    private val noteRepository: NoteRepository
) : BaseUseCase<Unit, MutableList<Note>>() {

    override suspend fun execute(param: Unit): Flow<BaseResponse<MutableList<Note>>> = flow {
        val res = noteRepository.findAll()
        emit(BaseResponse.Success(res))
    }
}
