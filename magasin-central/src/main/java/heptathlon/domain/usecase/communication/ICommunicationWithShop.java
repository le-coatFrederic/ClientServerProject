package heptathlon.domain.usecase.communication;

import java.util.List;

import heptathlon.domain.dto.ArticleAndCategoryDTO;
import heptathlon.domain.dto.CategoryDTO;
import heptathlon.domain.dto.InvoiceDTO;

public interface ICommunicationWithShop {
    public List<ArticleAndCategoryDTO> getAllArticles();
    public List<CategoryDTO> getAllCategories();
    public void sendInvoices(List<InvoiceDTO> invoices);
}
