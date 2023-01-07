package ed.englishdiary.diary.service;

import ed.englishdiary.diary.domain.Account;
import ed.englishdiary.diary.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiaryService {

    private final AccountRepository accountRepository;

    public DiaryService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account saveDiary(final Account accountRequest) {
        Account account = accountRepository.findById(accountRequest.getId()).orElseGet(Account::new);
        account.setUsername("최상욱");
        account.setPassword("1234");

        if (account.getId() == null) {
            accountRepository.save(account);
        }

        return account;


    }



}
