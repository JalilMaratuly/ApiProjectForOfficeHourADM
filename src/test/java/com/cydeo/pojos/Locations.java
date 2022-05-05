package com.cydeo.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Locations {

    private Long count;

    private Boolean hasMore;

    private List<Location> items;

    private Long limit;

    private List<Link> links;

    private Long offset;

}