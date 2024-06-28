package heptathlon;

import heptathlon.application.dbManager.IDbConfig;
import heptathlon.application.dbManager.MySqlDbConfigHibernate;
import heptathlon.domain.entity.Article;

public class Main {
    public static void main(String[] args) {
        IDbConfig dbConfig = new MySqlDbConfigHibernate();
        
        dbConfig.updateArticle(1, new Article("12345", "Chaise voyante"));
    }
}