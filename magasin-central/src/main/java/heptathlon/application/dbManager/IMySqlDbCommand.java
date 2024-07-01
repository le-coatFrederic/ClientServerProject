package heptathlon.application.dbManager;

public interface IMySqlDbCommand {
    public void executeTransaction(TransactionAction action);
    public <T> T executeQuery(QueryAction<T> action);
}
