package heptathlon.application.communicationManager;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import heptathlon.domain.dao.IArticleDao;
import heptathlon.domain.dao.ICategoryDao;
import heptathlon.domain.dao.IInvoiceDao;
import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.CategoryDTO;
import heptathlon.domain.dto.InvoiceDTO;
import heptathlon.domain.entity.Article;
import heptathlon.domain.entity.Category;
import heptathlon.domain.entity.Invoice;
import heptathlon.domain.usecase.communication.ICommunicationWithClient;

public class CommunicationWithClientImpl implements ICommunicationWithClient {
    private IArticleDao articleDAO;
    private ICategoryDao categoryDAO;
    private IInvoiceDao invoiceDao;

    public CommunicationWithClientImpl(IArticleDao articleDAO, ICategoryDao categoryDAO, IInvoiceDao invoiceDao) {
        this.articleDAO = articleDAO;
        this.categoryDAO = categoryDAO;
        this.invoiceDao = invoiceDao;
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticles() {
        List<Article> articles = articleDAO.getAllArticles();
        return articles.stream().map(ArticleAndCategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryDAO.getAllCategory();
        return categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticlesByEan(String ean) {
        List<Article> articles = articleDAO.getAllArticlesByEAN(ean);
        return articles.stream().map(ArticleAndCategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticlesByCategories(List<CategoryDTO> categoriesDTO) {
        List<Category> categories = new ArrayList<Category>();
        categoriesDTO.forEach(categoryDTO -> {
            Category category = new Category(categoryDTO.getName());
            category.setId(categoryDTO.getId());
            categories.add(category);
        });

        List<Article> articles = articleDAO.getAllArticlesByCategories(categories);
        return articles.stream().map(ArticleAndCategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ArticleAndCategoryDTO> getAllArticlesByIntitules(String intitule) {
        List<Article> articles = articleDAO.getAllArticlesByIntitule(intitule);
        return articles.stream().map(ArticleAndCategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public void sendInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoiceToAdd = new Invoice();
        invoiceToAdd.setId(invoiceDTO.getId());
        invoiceToAdd.setamount(invoiceDTO.getAmount());
        invoiceToAdd.setFileLink(invoiceDTO.getFileLink());
        invoiceToAdd.setDate(invoiceDTO.getDate());

        this.invoiceDao.addInvoice(invoiceToAdd);
    }

    @Override
    public List<InvoiceDTO> getAllInvoices() {
        List<Invoice> invoices = invoiceDao.getAllInvoices();
        List<InvoiceDTO> invoicesDto = new ArrayList<>();
        invoices.forEach(invoice -> invoicesDto.add(new InvoiceDTO(invoice)));
        return invoicesDto;
    }

}
