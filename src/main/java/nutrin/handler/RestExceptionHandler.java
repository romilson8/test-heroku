package nutrin.handler;

import nutrin.exception.BadRequestExceptionDetails;
import nutrin.exception.ValidationExceptionDetails;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerObjectNotFoundException(ObjectNotFoundException ex) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .titulo("Objeto não encontrado")
                        .detalhes(ex.getMessage())
                        .mensagemDesenvolvedor(ex.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerNumberFormatException(NumberFormatException ex) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .titulo("Valor numérico esperado")
                        .detalhes(ex.getMessage())
                        .mensagemDesenvolvedor(ex.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerIllegalArgumentException(IllegalArgumentException ex){
        return new ResponseEntity<>(
                BadRequestExceptionDetails
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .titulo("Bad Request Exception")
                        .detalhes(ex.getMessage())
                        .mensagemDesenvolvedor(ex.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.toList());
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        return new ResponseEntity<>(
                ValidationExceptionDetails
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .campos(fields)
                        .mensagemCampos(fieldsMessage)
                        .titulo("Bad Request Exception")
                        .detalhes("Check the field(s) Error")
                        .mensagemDesenvolvedor(ex.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }

}