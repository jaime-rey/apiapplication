package io.getarrays.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.api.model.Account;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);

}
