package heptathlon.application.communicationManager;

import java.util.List;
import java.util.stream.Collectors;

import heptathlon.domain.dao.IArticleDao;
import heptathlon.domain.dao.ICategoryDao;
import heptathlon.domain.dao.IInvoiceDao;
import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.CategoryDTO;
import heptathlon.domain.dto.InvoiceDTO;
import heptathlon.domain.dto.InvoiceToHQDTO;
import heptathlon.domain.entity.Article;
import heptathlon.domain.entity.Category;
import heptathlon.domain.entity.Invoice;
import heptathlon.domain.usecase.communication.ICommunicationWithShop;

public class CommunicationWithShopImpl implements ICommunicationWithShop {
    private IArticleDao articleDao;
    private ICategoryDao categoryDao;
    private IInvoiceDao invoiceDao;

    public CommunicationWithShopImpl(IArticleDao articleDao, ICategoryDao categoryDao, IInvoiceDao invoiceDao) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.invoiceDao = invoiceDao;
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticles() {
        List<Article> articles = articleDao.getAllArticles();
        return articles.stream().map(ArticleAndCategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryDao.getAllCategory();
        return categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public void sendInvoices(List<InvoiceToHQDTO> invoicesDTO) {
        invoicesDTO.forEach(invoiceDto -> {
            Invoice invoice = invoiceDto.toInvoice();
            this.invoiceDao.addInvoice(invoice);
        });
    }

}
