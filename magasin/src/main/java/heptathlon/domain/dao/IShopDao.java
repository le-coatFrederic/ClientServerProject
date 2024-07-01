package heptathlon.domain.dao;

import java.util.List;

import heptathlon.domain.entity.Shop;

public interface IShopDao {
    public void addShop(Shop shop);
    public void updateShop(long oldShopId, Shop newShop);
    public void removeShop(long shopId);
    public List<Shop> getAllShop();
}
