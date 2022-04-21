package com.pwojcik.instastatisticweb.repository;

import com.pwojcik.instastatisticweb.model.InstaAccount;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountsRepository {

    private Map<String, InstaAccount> accounts = new HashMap<>();

    public Map<String, InstaAccount> getRepository() {
        if (accounts.isEmpty()) {
            fillAccountRepositoryWithDefaults();
        }
        return accounts;
    }

    private void fillAccountRepositoryWithDefaults() {
        //TODO read accounts from json file
        InstaAccount account1 = new InstaAccount();
        account1.setAccountName("ameliawoj_");
        account1.setUserName("Amelia Wójcik");
        account1.setProfilePhoto("/assets/img/profile_photo.jpg");
        account1.setPostCount(167L);
        account1.setFollowersCount(3186L);
        account1.setFollowingCount(751L);
        account1.setLinkToAccount("https://www.instagram.com/ameliawoj_/");
        accounts.put(account1.getAccountName(), account1);

        InstaAccount account2 = new InstaAccount();
        account2.setAccountName("pinawoj");
        account2.setUserName("Paulina Wójcik");
        account2.setProfilePhoto("/assets/img/profile_photo.jpg");
        account2.setPostCount(18L);
        account2.setFollowersCount(226L);
        account2.setFollowingCount(136L);
        account2.setLinkToAccount("https://www.instagram.com/pinawoj/");
        accounts.put(account2.getAccountName(), account2);

        InstaAccount account3 = new InstaAccount();
        account3.setAccountName("paula_jagodzinska");
        account3.setUserName("Paula Jagodzińska");
        account3.setProfilePhoto("/assets/img/profile_photo.jpg");
        account3.setPostCount(5995L);
        account3.setFollowersCount(366000L);
        account3.setFollowingCount(104L);
        account3.setLinkToAccount("https://www.instagram.com/paula_jagodzinska/");
        accounts.put(account3.getAccountName(), account3);
    }

}
