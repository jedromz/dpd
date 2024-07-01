package com.dpdgroup.api.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Valid
public class OrderRequest {

    @JsonProperty("shipmentNumber")
    private String shipmentNumber;

    @JsonProperty("receiverEmail")
    @Email(message = "Email should be valid")
    private String receiverEmail;

    @JsonProperty("receiverCountryCode")
    private String receiverCountryCode;

    @JsonProperty("senderCountryCode")
    private String senderCountryCode;

    @JsonProperty("statusCode")
    @Min(value = 0, message = "Status code must be between 0 and 100")
    @Max(value = 100, message = "Status code must be between 0 and 100")
    private int statusCode;
}