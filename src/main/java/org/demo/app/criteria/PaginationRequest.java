package org.demo.app.criteria;


import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class PaginationRequest {

    @PositiveOrZero(message = "INVALID_PAGE_INDEX")
    private Integer index;

    @Positive(message = "SIZE_SHOULD_BE_POSITIVE")
    private Integer size;

}
