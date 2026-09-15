package lab9.repository;

import lab9.model.DepositTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<DepositTransaction, Long> {
}