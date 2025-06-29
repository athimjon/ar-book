package org.example.arbook.model.dto.response;

import org.example.arbook.model.enums.BookStatus;

public record BookRes(
        Long id,
        String title,
        String description,
        Integer totalPages,
        Integer totalLanguages,
        BookStatus status,
        Long attachmentId
        ) {

}