package heptathlon.application.dbManager;

import org.hibernate.Session;

public interface QueryAction<T> {
    T execute(Session session);
}
