package com.acesif.graphQL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "create")
public class AgeRange {

    private Integer minAge;
    private Integer maxAge;
}
