// SNIPPET (not compiled here): the two pitfalls from the Spring @Transactional reference.
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalPitfalls {

    // 1. Checked exceptions do NOT roll back by default; RuntimeException and Error do.
    @Transactional
    public void checkedDoesNotRollBack() throws Exception {
        // insert ...
        throw new Exception("checked: the insert is still committed");
    }

    @Transactional(rollbackFor = Exception.class)
    public void checkedNowRollsBack() throws Exception {
        // insert ...
        throw new Exception("checked: rolled back because of rollbackFor");
    }

    // 2. Self-invocation bypasses the proxy, so the annotation on `inner` is ignored here.
    public void outer() {
        inner();            // plain call on `this`, not through the Spring proxy
    }

    @Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRES_NEW)
    public void inner() { /* not run in a new transaction when called from outer() */ }
}
