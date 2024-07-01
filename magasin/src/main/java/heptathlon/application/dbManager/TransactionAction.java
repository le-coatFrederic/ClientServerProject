package heptathlon.application.dbManager;

import org.hibernate.Session;

public interface TransactionAction {
    void execute(Session session);
}
