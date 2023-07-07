package lk.lnas.ims.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductionDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String description;

    @NotNull
    private String productId;

    @NotNull
    private Long qty;

    private ProductStatus status;

    private Long plant;

    private Long farm;

}
