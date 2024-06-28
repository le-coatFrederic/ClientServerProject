package heptathlon.application.dbManager;

import java.util.List;

import heptathlon.domain.entity.Shop;

public interface IShopDbConfig {
    public void addShop(Shop shop);
    public void updateShop(long oldShopId, Shop newShop);
    public void removeShop(long shopId);
    public Shop detailShop(long shopId);
    public List<Shop> getAllShop();
}
