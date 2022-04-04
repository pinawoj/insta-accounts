package com.pwojcik.instastatisticweb.service;

import com.pwojcik.instastatisticweb.model.InstaAccount;
import com.pwojcik.instastatisticweb.repository.AccountsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountsRepositoryService {

    AccountsRepository accountsRepository;

    public AccountsRepositoryService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public void addAccount(InstaAccount instaAccount) {
        accountsRepository.getRepository().put(instaAccount.getAccountName(), instaAccount);
    }

    public void deleteAccount(String accountName) {
        accountsRepository.getRepository().remove(accountName);
    }

    public List<InstaAccount> getAccounts() {
        return new ArrayList<>(accountsRepository.getRepository().values());
    }

    public InstaAccount getAccount(String accountName) {
        if (accountsRepository.getRepository().containsKey(accountName)) {
            return accountsRepository.getRepository().get(accountName);
        }
        return new InstaAccount();
    }

}
