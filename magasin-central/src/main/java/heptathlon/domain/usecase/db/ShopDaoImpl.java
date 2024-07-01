package heptathlon.domain.usecase.db;

import java.util.List;

import org.hibernate.Hibernate;

import heptathlon.application.dbManager.IMySqlDbCommand;
import heptathlon.domain.dao.IShopDao;
import heptathlon.domain.entity.Shop;

public class ShopDaoImpl implements IShopDao {
    private IMySqlDbCommand dbCommand;

    public ShopDaoImpl(final IMySqlDbCommand dbCommand) {
        this.dbCommand = dbCommand;
    }

    @Override
    public void addShop(Shop shop) {
        this.dbCommand.executeTransaction(session -> session.save((shop)));
    }

    @Override
    public void updateShop(long oldShopId, Shop newShop) {
        this.dbCommand.executeTransaction(session -> {
            Shop shop = session.get(Shop.class, oldShopId);
            if (shop != null) {
                shop.update(newShop);
                session.update(shop);
            }
        });
    }

    @Override
    public void removeShop(long shopId) {
        this.dbCommand.executeTransaction(session -> {
            Shop shop = session.get(Shop.class, shopId);
            if (shop != null) {
                session.delete(shop);
            }
        });
    }

    @Override
    public List<Shop> getAllShop() {
        return this.dbCommand.executeQuery(session -> {
            List<Shop> shops = session.createQuery("from Shop", Shop.class)
                .list();
            for (Shop shop: shops) {
                Hibernate.initialize(shop.getInvoices());
            }
            return shops;
        });
    }

}
