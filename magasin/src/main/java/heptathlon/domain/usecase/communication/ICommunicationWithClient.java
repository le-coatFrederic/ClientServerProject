package heptathlon.domain.usecase.communication;

import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.CategoryDTO;
import heptathlon.domain.dto.InvoiceDTO;

public interface ICommunicationWithClient {
    public List<ArticleAndCategoryDTO> getAllArticles();
    public List<ArticleAndCategoryDTO> getAllArticlesByEan(String ean);
    public List<ArticleAndCategoryDTO> getAllArticlesByCategories(List<CategoryDTO> categories);
    public List<ArticleAndCategoryDTO> getAllArticlesByIntitules(String intitule);
    public List<CategoryDTO> getAllCategories();
    public void sendInvoice(InvoiceDTO invoice);
    public List<InvoiceDTO> getAllInvoices();
}
