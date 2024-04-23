package magasin.domain.entities.article;

public class Article {
    private int id;
    private IEAN ean;
    private String name;
    private String description;
    private float price;

    public Article(int id_param) {
        id = id_param;
        ean = null;
        name = "";
        description = "";
        price = 0;
    }
}
