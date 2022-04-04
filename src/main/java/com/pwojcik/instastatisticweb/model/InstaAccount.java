package com.pwojcik.instastatisticweb.model;

import lombok.Data;

@Data
public class InstaAccount {

    private String accountName;
    private String userName;
    private String profilePhoto;
    private Long postCount;
    private Long followersCount;
    private Long followingCount;
    private String linkToAccount;

}
