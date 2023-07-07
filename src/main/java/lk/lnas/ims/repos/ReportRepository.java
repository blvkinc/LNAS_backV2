package lk.lnas.ims.repos;

import lk.lnas.ims.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReportRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {
}
