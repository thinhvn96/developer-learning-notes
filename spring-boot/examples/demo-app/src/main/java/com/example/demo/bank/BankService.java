package com.example.demo.bank;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {
    private final AccountRepository accounts;
    private final AuditService audit;

    public BankService(AccountRepository accounts, AuditService audit) {
        this.accounts = accounts;
        this.audit = audit;
    }

    /** Checked exception: NOT rolled back by default. */
    @Transactional
    public void createThenThrowChecked(String owner) throws Exception {
        accounts.save(new Account(owner));
        throw new Exception("checked");
    }

    @Transactional(rollbackFor = Exception.class)
    public void createThenThrowCheckedWithRollbackFor(String owner) throws Exception {
        accounts.save(new Account(owner));
        throw new Exception("checked");
    }

    /** RuntimeException: rolled back by default. */
    @Transactional
    public void createThenThrowRuntime(String owner) {
        accounts.save(new Account(owner));
        throw new IllegalStateException("runtime");
    }

    /** Transactional method: both saves and the exception form one unit of work. */
    @Transactional
    public void createTwoThenFail(String prefix) {
        accounts.save(new Account(prefix + "-1"));
        accounts.save(new Account(prefix + "-2"));
        throw new IllegalStateException("fail after two saves");
    }

    /** Self-invocation: this call bypasses the proxy, so the @Transactional on createTwoThenFail is ignored. */
    public void callTransactionalMethodOnThis(String prefix) {
        createTwoThenFail(prefix);
    }

    /** Audit in a NEW transaction survives the rollback of this transaction. */
    @Transactional
    public void placeOrderAuditNew(String owner) {
        accounts.save(new Account(owner));
        audit.recordInNewTransaction("attempted " + owner);
        throw new IllegalStateException("order failed");
    }

    /** Audit that joins the caller's transaction is rolled back together with it. */
    @Transactional
    public void placeOrderAuditJoin(String owner) {
        accounts.save(new Account(owner));
        audit.recordJoiningCaller("attempted " + owner);
        throw new IllegalStateException("order failed");
    }
}
