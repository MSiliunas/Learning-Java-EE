package Handlers;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.TransactionSynchronizationRegistry;

public abstract class CRUD {
    @Resource
    private TransactionSynchronizationRegistry tx;

    @PostConstruct
    private void init() {
        System.err.println(this.tx.getTransactionKey());
    }
}
