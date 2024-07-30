package be.kyanvde.backend.assetusage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AssetUsageNotFoundAdvice {

    @ExceptionHandler(AssetUsageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(AssetUsageNotFoundException ex) {
        return ex.getMessage();
    }
}
