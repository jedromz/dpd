package com.dpdgroup.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("shipmentNumber")
    private String shipmentNumber;

    @JsonProperty("receiverEmail")
    private String receiverEmail;

    @JsonProperty("receiverCountryCode")
    private String receiverCountryCode;

    @JsonProperty("senderCountryCode")
    private String senderCountryCode;

    @JsonProperty("statusCode")
    private int statusCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getShipmentNumber(), order.getShipmentNumber()) && Objects.equals(getReceiverEmail(), order.getReceiverEmail()) && Objects.equals(getReceiverCountryCode(), order.getReceiverCountryCode()) && Objects.equals(getSenderCountryCode(), order.getSenderCountryCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShipmentNumber(), getReceiverEmail(), getReceiverCountryCode(), getSenderCountryCode());
    }
}
