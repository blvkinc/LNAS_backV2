package lk.lnas.ims.domain;

import jakarta.persistence.*;
import lk.lnas.ims.model.PurchaseStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Purchase {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

    @Column
    private String type;

    @Column
    private Long subTotal;

    @Column
    private Long itemDiscount;

    @Column
    private Long tax;

    @Column
    private Long shipping;

    @Column
    private Long total;

    @OneToMany(mappedBy = "purchase")
    private Set<PurchaseItem> purchaseItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
