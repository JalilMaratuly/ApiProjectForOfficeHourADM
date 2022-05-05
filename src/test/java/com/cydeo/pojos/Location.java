package com.cydeo.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Location {

    private String city;
    @JsonProperty("country_id")
    private String countryId;

    private List<Link> links;
    @JsonProperty("location_id")
    private Long locationId;
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("state_province")
    private Object stateProvince;
    @JsonProperty("street_address")
    private String streetAddress;

}