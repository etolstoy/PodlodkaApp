package ru.podlodka.backend.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import ru.podlodka.backend.service.SelectionService
import java.util.logging.Logger
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/error")
class ErrorController {
    val logger = Logger.getLogger("errorLogger");

    @RequestMapping("/ex")
    fun ex(request: HttpServletRequest): String? {
        val throwable = request.getAttribute("javax.servlet.error.exception") as Throwable
        throwable.printStackTrace() //print
        logger.info(throwable.message) // or log
        // or save to db
        return "error" //and redirect to some user-friendly page
    }
}