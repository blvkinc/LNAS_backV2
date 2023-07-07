package lk.lnas.ims.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PurchaseDTO {

    private Long id;

    private PurchaseStatus status;

    @Size(max = 255)
    private String type;

    private Long subTotal;

    private Long discount;

    private Long tax;

    private Long shipping;

    private Long total;

    private Long transaction;

    private List<PurchaseItemDTO> items;

}
