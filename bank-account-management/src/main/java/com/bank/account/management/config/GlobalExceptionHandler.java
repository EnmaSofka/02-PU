package com.bank.account.management.config;

import com.bank.account.management.controller.exception.BankAccountException;
import com.bank.account.management.controller.exception.CustomerException;
import com.bank.account.management.controller.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerException.CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFound(CustomerException.CustomerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(CustomerException.CustomerAlreadyExistsException.class)
    public ResponseEntity<String> handleCustomerAlreadyExists(CustomerException.CustomerAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler({BankAccountException.BankAccountAlreadyExistsException.class})
    public ResponseEntity<String> handleCustomerAlreadyExists(BankAccountException.BankAccountAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(BankAccountException.BankAccountNotFoundException.class)
    public ResponseEntity<String> handleCustomerAlreadyExists(BankAccountException.BankAccountNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<String> handleInvalidDepositAmountException(InvalidAmountException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(AccountNotBelongsToCustomerException.class)
    public ResponseEntity<String> handleAccountNotBelongsToCustomerException(AccountNotBelongsToCustomerException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidDepositTypeException.class)
    public ResponseEntity<String> handleAccountNotBelongsToCustomerException(InvalidDepositTypeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<String> handleInsufficientFundsException(InsufficientFundsException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidPurchaseTypeException.class)
    public ResponseEntity<String> handleInvalidPurchaseTypeException(InvalidPurchaseTypeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


}
