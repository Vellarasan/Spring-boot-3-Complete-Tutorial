package vels.io.spring.boot3.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        @NotBlank
        String title,
        @NotBlank
        String description,
        Status status,
        Type type,
        LocalDateTime createdDateTime,
        LocalDateTime updatedDateTime,
        String url

) {
}
