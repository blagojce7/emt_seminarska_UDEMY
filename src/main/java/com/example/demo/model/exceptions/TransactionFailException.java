package com.example.demo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class TransactionFailException extends RuntimeException{
    public TransactionFailException(String userID,String message){
        super(String.format("Transaction failed!!! Message: %s",message));
    }
}
