package com.example.demo;

import com.example.demo.bank.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/** Not itself @Transactional: we want the service methods to own the transactions. */
@SpringBootTest
class TransactionBehaviourTest {
    @Autowired BankService bank;
    @Autowired AccountRepository accounts;
    @Autowired AuditLogRepository audits;

    @BeforeEach void clean() { accounts.deleteAll(); audits.deleteAll(); }

    @Test void checkedExceptionCommitsByDefault() {
        assertThatThrownBy(() -> bank.createThenThrowChecked("a")).hasMessage("checked");
        System.out.println("RESULT checked exception, default rules      -> accounts saved: " + accounts.count());
        assertThat(accounts.count()).isEqualTo(1);
    }

    @Test void checkedExceptionRollsBackWithRollbackFor() {
        assertThatThrownBy(() -> bank.createThenThrowCheckedWithRollbackFor("a"));
        System.out.println("RESULT checked exception, rollbackFor=Exception -> accounts saved: " + accounts.count());
        assertThat(accounts.count()).isZero();
    }

    @Test void runtimeExceptionRollsBackByDefault() {
        assertThatThrownBy(() -> bank.createThenThrowRuntime("a"));
        System.out.println("RESULT runtime exception, default rules      -> accounts saved: " + accounts.count());
        assertThat(accounts.count()).isZero();
    }

    @Test void throughTheProxyBothSavesRollBack() {
        assertThatThrownBy(() -> bank.createTwoThenFail("p"));
        System.out.println("RESULT external call through the proxy       -> accounts saved: " + accounts.count());
        assertThat(accounts.count()).isZero();
    }

    @Test void selfInvocationBypassesTheProxy() {
        assertThatThrownBy(() -> bank.callTransactionalMethodOnThis("s"));
        System.out.println("RESULT self-invocation (this.method())        -> accounts saved: " + accounts.count());
        assertThat(accounts.count()).isEqualTo(2);
    }

    @Test void requiresNewAuditSurvivesRollback() {
        assertThatThrownBy(() -> bank.placeOrderAuditNew("o"));
        System.out.println("RESULT REQUIRES_NEW audit                     -> accounts: " + accounts.count() + ", audit rows: " + audits.count());
        assertThat(accounts.count()).isZero();
        assertThat(audits.count()).isEqualTo(1);
    }

    @Test void requiredAuditRollsBackWithCaller() {
        assertThatThrownBy(() -> bank.placeOrderAuditJoin("o"));
        System.out.println("RESULT REQUIRED audit (joins caller)          -> accounts: " + accounts.count() + ", audit rows: " + audits.count());
        assertThat(accounts.count()).isZero();
        assertThat(audits.count()).isZero();
    }
}
