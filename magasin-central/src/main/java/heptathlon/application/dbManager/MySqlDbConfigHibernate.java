package heptathlon.application.dbManager;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import heptathlon.domain.entity.Article;
import heptathlon.domain.entity.Category;
import heptathlon.domain.entity.Invoice;
import heptathlon.domain.entity.Shop;

public class MySqlDbConfigHibernate implements IDbConfig {
    private SessionFactory sessionFactory;

    public MySqlDbConfigHibernate() {
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
    public void addArticle(Article newArticle) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(newArticle);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateArticle(long oldArticleId, Article newArticle) {
        try(Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Article oldArticle = session.get(Article.class, oldArticleId);
            if (oldArticle == null) {
                transaction.commit();
                throw new IllegalArgumentException();
            }

            oldArticle.update(newArticle);

            session.update(oldArticle);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void removeArticle(long articleId) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Article articleToRemove = session.get(Article.class, articleId);
            if  (articleToRemove != null) {
                session.delete(articleToRemove);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Article> getAllArticles() {
        List<Article> articles = null;

        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            articles = session.createQuery("from Article", Article.class).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return articles;
    }

    @Override
    public List<Article> getAllArticlesByEAN(String ean) {
        List<Article> articles = null;
        
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            articles = session.createQuery("from Article where ean Like :ean", Article.class)
                .setParameter("ean", ean)
                .list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return articles;
    }

    @Override
    public List<Article> getAllArticlesByIntitule(String intitule) {
        List<Article> articles = null;
        
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            articles = session.createQuery("from Article where ean Like :intitule", Article.class)
                .setParameter("intitule", intitule)
                .list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return articles;
    }
    
    @Override
    public void addInvoice(Invoice newInvoice) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(newInvoice);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void updateInvoice(long oldInvoiceId, Invoice newInvoice) {
        try(Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Invoice oldInvoice = session.get(Invoice.class, oldInvoiceId);
            if (oldInvoice == null) {
                transaction.commit();
                throw new IllegalArgumentException();
            }

            oldInvoice.update(newInvoice);

            session.update(oldInvoice);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = null;

        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            invoices = session.createQuery("from Invoice", Invoice.class).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return invoices;
    }
    
    @Override
    public List<Invoice> getAllInvoicesByShop(Shop shop) {
        List<Invoice> invoices = null;

        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            invoices = session.createQuery("from Invoice where shop Like :shop", Invoice.class)
                .setParameter("shop", shop)
                .list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return invoices;
    }

    public List<Invoice> getAllInvoicesByDate(LocalDateTime date) {
        List<Invoice> invoices = null;

        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            invoices = session.createQuery("from Invoice where date = :date", Invoice.class)
                .setParameter("date", date)
                .list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return invoices;
    }

    public List<Invoice> getAllInvoicesBeforeDate(LocalDateTime date) {
        List<Invoice> invoices = null;

        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            invoices = session.createQuery("from Invoice where date < :date", Invoice.class)
                .setParameter("date", date)
                .list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return invoices;
    }

    public List<Invoice> getAllInvoicesAfterDate(LocalDateTime date) {
        List<Invoice> invoices = null;

        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            invoices = session.createQuery("from Invoice where date > :date", Invoice.class)
                .setParameter("date", date)
                .list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return invoices;
    }

    public List<Invoice> getAllInvoicesBetweenDate(LocalDateTime date1, LocalDateTime date2) {
        List<Invoice> invoices = null;

        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            invoices = session.createQuery("from Invoice where date BETWEEN date1 AND date2", Invoice.class)
                .setParameter("date1", date1)
                .setParameter("date2", date2)
                .list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return invoices;
    }

    
    @Override
    public Invoice getInvoiceById(long id) {
        Invoice invoice = null;
        return invoice;        
    }

    @Override
    public void addShop(Shop shop) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(shop);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateShop(long oldShopId, Shop newShop) {
        try(Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Shop oldShop = session.get(Shop.class, oldShopId);
            if (oldShop == null) {
                transaction.commit();
                throw new IllegalArgumentException();
            }

            oldShop.update(newShop);

            session.update(oldShop);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeShop(long shop) {
        try(Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Shop shopToRemove = session.get(Shop.class, shop);
            if (shopToRemove == null) {
                transaction.commit();
                throw new IllegalArgumentException();
            }

            session.remove(shopToRemove);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Shop detailShop(long shop) {
        Shop shopToShow = null;
        try(Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            shopToShow = session.get(Shop.class, shop);
            if (shopToShow == null) {
                transaction.commit();
                throw new IllegalArgumentException();
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return shopToShow;
    }

    @Override
    public List<Shop> getAllShop() {
        List<Shop> shops = null;

        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            shops = session.createQuery("from Shop", Shop.class).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return shops;
    }

    @Override
    public void addCategory(Category category) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategory(long oldCategoryId, Category newCategory) {
        try(Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Category oldCategory = session.get(Category.class, oldCategoryId);
            if (oldCategory == null) {
                transaction.commit();
                throw new IllegalArgumentException();
            }

            oldCategory.update(newCategory);

            session.update(oldCategory);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCategory(long categortId) {
        try(Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Category categoryToRemove = session.get(Category.class, categortId);
            if (categoryToRemove == null) {
                transaction.commit();
                throw new IllegalArgumentException();
            }

            session.remove(categoryToRemove);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category detailCategory(long categortId) {
        Category categoryToShow = null;
        try(Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            categoryToShow = session.get(Category.class, categortId);
            if (categoryToShow == null) {
                transaction.commit();
                throw new IllegalArgumentException();
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoryToShow;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = null;

        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            categories = session.createQuery("from Category", Category.class).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }
}
