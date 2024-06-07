package ru.neoflex.calculator.util.swaggerCustomAnnotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(
        summary = "Метод получения всех выражений",
        description = "Возвращает массив всех выражений"
)
@ApiResponse(
        responseCode = "200",
        description =  "Запрос выполнен",
        content = {
                @Content(mediaType = "application/json", schema =
                @Schema(description = "пример", example = "{\"список выражений\" : [  "+"{\"выражение\" : \"80 - 20\", \"результат\" : 60}, " +
                        "{\"выражение\" : \"99 + 1\", \"результат\" : 100} ] }"))
        }
)

public @interface AllWithoutParams {
}