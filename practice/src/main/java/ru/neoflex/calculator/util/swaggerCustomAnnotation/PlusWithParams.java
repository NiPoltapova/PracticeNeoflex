package ru.neoflex.calculator.util.swaggerCustomAnnotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
        summary = "Метод получения суммы двух чисел",
        parameters = {
                @Parameter(name = "x", example = "80", required = true),
                @Parameter(name = "y", example = "20", required = true)
        }
)
@ApiResponse(
        responseCode = "200",
        description = "Запрос выполнен",
        content = {
                @Content( mediaType = "application/json", schema =
                @Schema(description = "пример", example = "{\"выражение\" : \"80 + 20\", \"результат\" : 100}"))
        }
)
@ApiResponse(
        responseCode = "400",
        description = "Запрос провален",
        content = {
                @Content( mediaType = "application/json", schema =
                @Schema(description = "пример", example = "{\"Сообщение:\" : \"Внимание! Выражение введено неверно.\"}"))
        }
)

public @interface PlusWithParams {
}
