package com.Solo.LibraryManagement.global.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member Not Found"),
    MEMBER_EXISTS(405, "Member Exists"),

    BOOK_NOT_FOUND(404, "Book Not Found"),
    BOOK_STATUS_NOT_FOUND(404, "Book Status Not Found");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
