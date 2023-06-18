package com.fastcampus.boardprojfc.repository;

import com.fastcampus.boardprojfc.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, String > {
}
