package com.anithcode.Banking_App.repository;

import com.anithcode.Banking_App.entity.Account;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

//Long ==> Primary Key (accountNumber)


public interface AccountRepository extends JpaRepository<Account,Long> {
}
