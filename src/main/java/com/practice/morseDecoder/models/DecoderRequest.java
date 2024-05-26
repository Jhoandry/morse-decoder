package com.practice.morseDecoder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class DecoderRequest {

    @NotNull(message = "input may not be null")
    @NotEmpty(message = "input may not be empty")
    @NotBlank(message = "input may have a value")
    private String input;

    private String output;

    public DecoderRequest(String input, String output) {
        this.input = input;
        this.output = output;
    }
}
