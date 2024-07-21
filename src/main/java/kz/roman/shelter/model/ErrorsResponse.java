package kz.roman.shelter.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ErrorsResponse {

    private UUID id;
    private int status;
    private String message;
    private String description;
}
