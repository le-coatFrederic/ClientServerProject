package heptathlon;

import java.rmi.Naming;
import java.util.List;

import heptathlon.application.dbManager.IMySqlDbCommand;
import heptathlon.application.dbManager.MySqlDbCommandHibernate;
import heptathlon.application.rmiManager.IRmiSenderToClient;
import heptathlon.domain.dao.IArticleDao;
import heptathlon.domain.dao.ICategoryDao;
import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.usecase.db.ArticleDaoImpl;
import heptathlon.domain.usecase.db.CategoryDaoImpl;

public class Main {
    public static void main(String[] args) {
        try {
            IMySqlDbCommand dbCommand = new MySqlDbCommandHibernate();
            IArticleDao articleDao = new ArticleDaoImpl(dbCommand);
            ICategoryDao categoryDao = new CategoryDaoImpl(dbCommand);

            IRmiSenderToClient remote = (IRmiSenderToClient) Naming.lookup("rmi://localhost:1099/client_get");
            List<ArticleAndCategoryDTO> articles = remote.getAllArticles();

            System.out.println("Articles : ");
            for (ArticleAndCategoryDTO article: articles) {
                System.out.println(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}