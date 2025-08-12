package com.ojtbank.api.autoconfigure;


import com.ojtbank.domain.dao.*;
import com.ojtbank.domain.mapper.*;
import com.ojtbank.domain.repository.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@org.springframework.boot.autoconfigure.AutoConfiguration
public class DaoAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "dao", name = "impl-type", havingValue = "jpa")
    public AccountDao AccountDaoJpa(AccountRepository accountRepository, TransferRepository transferRepository, DepositRepository depositRepository) {
        return new AccountJpaDaoImpl(accountRepository, transferRepository, depositRepository);
    }

    @Bean
    @ConditionalOnProperty(prefix = "dao", name = "impl-type", havingValue = "jpa")
    public CustomerDao CustomerDaoJpa(CustomerRepository customerRepository, AccountRepository accountRepository) {
        return new CustomerJpaDaoImpl(customerRepository, accountRepository);
    }

    @Bean
    @ConditionalOnProperty(prefix = "dao", name = "impl-type", havingValue = "jpa")
    public DepositDao DepositDaoJpa(DepositRepository depositRepository){
        return new DepositJpaDaoImpl(depositRepository);
    }

    @Bean
    @ConditionalOnProperty(prefix = "dao", name = "impl-type", havingValue = "jpa")
    public PaymentDao PaymentDaoJpa(PaymentRepository paymentRepository){
        return new PaymentJpaDaoImpl(paymentRepository);
    }

    @Bean
    @ConditionalOnProperty(prefix = "dao", name = "impl-type", havingValue = "jpa")
    public TransferDao TransferDaoJpa(TransferRepository transferRepository){
        return new TransferJpaDaoImpl(transferRepository);
    }

    @Bean
    @ConditionalOnProperty(prefix = "dao", name = "impl-type", havingValue = "mybatis")
    public AccountDao AccountDaoMybatis(AccountMapper accountMapper){
        return new AccountMyBatisDaoImpl(accountMapper);
    }

    @Bean
    @ConditionalOnProperty(prefix = "dao", name = "impl-type", havingValue = "mybatis")
    public CustomerDao CustomerDaoMybatis(CustomerMapper customerMapper){
        return new CustomerMyBatisDaoImpl(customerMapper);
    }

    @Bean
    @ConditionalOnProperty(prefix = "dao", name = "impl-type", havingValue = "mybatis")
    public DepositDao DepositDaoMybatis(DepositMapper depositMapper){
        return new DepositMyBatisDaoImpl(depositMapper);
    }

    @Bean
    @ConditionalOnProperty(prefix = "dao", name = "impl-type", havingValue = "mybatis")
    public PaymentDao PaymentDaoMybatis(PaymentMapper paymentMapper){
        return new PaymentMyBatisDaoImpl(paymentMapper);
    }

    @Bean
    @ConditionalOnProperty(prefix = "dao", name = "impl-type", havingValue = "mybatis")
    public TransferDao TransferDaoMybatis(TransferMapper transferMapper){
        return new TransferMyBatisDaoImpl(transferMapper);
    }
}
