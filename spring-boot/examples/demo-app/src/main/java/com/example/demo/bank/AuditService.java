package com.example.demo.bank;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditService {
    private final AuditLogRepository repo;
    public AuditService(AuditLogRepository repo) { this.repo = repo; }

    /** Runs in its own independent transaction: commits even if the caller later rolls back. */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void recordInNewTransaction(String msg) { repo.save(new AuditLog(msg)); }

    /** Default REQUIRED: joins the caller's transaction, so it rolls back with it. */
    @Transactional
    public void recordJoiningCaller(String msg) { repo.save(new AuditLog(msg)); }
}
