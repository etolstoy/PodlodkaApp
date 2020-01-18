package ru.podlodka.backend.service

import ru.podlodka.backend.repositories.SelectionRepository
import org.springframework.stereotype.Service
import ru.podlodka.backend.models.Selection

@Service
class SelectionService(val selectionRepository: SelectionRepository){

    fun getAllSelections(): Collection<Selection> {
        return selectionRepository.findAll();
    }

    fun getSelectionById(id: String): Selection? {
        val selection = selectionRepository.findById(id);
        if(!selection.isPresent) {
            throw Exception("Selection id=$id not found")
        }
        return selection.get();
    }
}