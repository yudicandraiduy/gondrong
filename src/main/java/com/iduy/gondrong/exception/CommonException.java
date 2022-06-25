package com.iduy.gondrong.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iduy.gondrong.payload.ErrorSchema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonException extends RuntimeException {
    @JsonProperty(value = "error_schema")
    private ErrorSchema errorSchema;

    @JsonProperty(value = "output_schema")
    private Object outputSchema;
}
