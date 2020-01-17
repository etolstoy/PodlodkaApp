package ru.podlodka.backend.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.podlodka.backend.models.Selection
import ru.podlodka.backend.service.SelectionService
import java.util.logging.Logger

@RestController
class SelectionController(val selectionService: SelectionService){

    val logger = Logger.getLogger(SelectionService::class.java.canonicalName);

    @GetMapping
    fun getAllSelections(): MutableMap<String, Collection<Selection>> {
        val selectionMap = mutableMapOf<String, Collection<Selection>>();
        selectionMap["selections"] = selectionService.getAllSelections();
        return selectionMap;
    }

    @GetMapping("/{id}")
    fun getSelectionDetail(@PathVariable("id") id: String): ResponseEntity<Selection> {

        val selection = selectionService.getSelectionById(id)
        logger.info("selection $selection");

        if(selection == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).body(selection);
        }

        return ResponseEntity.ok(selection);
    }
}