package com.microservices.chapter03

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import com.fasterxml.jackson.core.JsonParseException

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(JsonParseException::class)
    fun JsonParseExceptionHandler(serveletRequest: HttpServletRequest,
                                  exception: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse("JSON Error", exception.message ?: "invalid json"), HttpStatus.BAD_REQUEST)
    }

}