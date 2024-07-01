package heptathlon.application.dbManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MySqlDbCommandHibernate implements IMySqlDbCommand {
    private SessionFactory sessionFactory;

    public MySqlDbCommandHibernate() {
        this.sessionFactory = this.buidSessionFactory();
    }

    private SessionFactory buidSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("SessionFactory creation failed " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public void executeTransaction(TransactionAction action) {
        Transaction transaction = null;
        try(Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            action.execute(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    @Override
    public <T> T executeQuery(QueryAction<T> action) {
        try (Session session = this.sessionFactory.openSession()) {
            return action.execute(session);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
