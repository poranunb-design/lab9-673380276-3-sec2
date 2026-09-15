package lab9.service;

import lab9.model.Account;
import lab9.model.DepositTransaction;
import lab9.repository.AccountRepository;
import lab9.repository.DepositRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepositService {

    private final AccountRepository accountRepository;
    private final DepositRepository depositRepository;

    public DepositService(
            AccountRepository accountRepository,
            DepositRepository depositRepository) {

        this.accountRepository = accountRepository;
        this.depositRepository = depositRepository;
    }

    public void deposit(Long accountId, Double amount) {

        // 1. ค้นหา Account
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        // 2. เพิ่มเงินเข้า balance
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        // 3. บันทึกประวัติการฝากเงิน
        DepositTransaction transaction =
                new DepositTransaction(amount, account);

        depositRepository.save(transaction);
        throw new RuntimeException("Test Rollback");
    }
}