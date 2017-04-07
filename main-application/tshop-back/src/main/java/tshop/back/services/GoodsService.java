package tshop.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Goods;
import tshop.back.repositories.CategoryRepository;
import tshop.back.repositories.GoodsRepository;
import tshop.back.transports.GoodsTransport;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Роднуля on 02.04.2017.
 */
@Service
@Transactional
public class GoodsService {

    private GoodsRepository goodsRepository;
    private CategoryRepository categoryRepository;


    @Autowired
    public GoodsService(GoodsRepository goodsRepository, CategoryRepository categoryRepository) {
        this.goodsRepository = goodsRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<GoodsTransport> getGoodsPage(String name, long priceFrom, long priceTo, int quantityFrom, int page, int size) {
        return goodsRepository.findPageWithFilter(name, priceFrom, priceTo, quantityFrom, new PageRequest(page, size)).stream().map(goods -> {
            GoodsTransport transport = this.goodsEntityToTransport(goods);
            return transport;
        }).collect(Collectors.toList());
    }


    public List<GoodsTransport> getAllGoodsPage(int page, int size) {
        return goodsRepository.findPage(new PageRequest(page,size)).stream().map(goods -> {
            GoodsTransport transport = this.goodsEntityToTransport(goods);
            return transport;
        }).collect(Collectors.toList());
    }


    public GoodsTransport createGoods(GoodsTransport transport) {
        Goods goods = new Goods();
        goods.setName(transport.getName());
        goods.setWeight(transport.getWeight());
        goods.setParameter1(transport.getParameter1());
        goods.setParameter2(transport.getParameter2());
        goods.setParameter3(transport.getParameter3());
        goods.setVolume(transport.getVolume());
        goods.setPrice(transport.getPrice());
        goods.setQuantity(transport.getQuantity());
        goods.setDeleted(transport.isDeleted() ? 1 : 0);
        goods.setCategoryes(categoryRepository.findAll(transport.getCategories()));
        goodsRepository.save(goods);
        return this.goodsEntityToTransport(goodsRepository.findOne(goods.getId()));
    }

    private GoodsTransport goodsEntityToTransport(Goods goods) {
        GoodsTransport transport = new GoodsTransport();
        transport.setId(goods.getId());
        transport.setName(goods.getName());
        transport.setParameter1(goods.getParameter1());
        transport.setParameter2(goods.getParameter2());
        transport.setParameter3(goods.getParameter3());
        transport.setPrice(goods.getPrice());
        transport.setQuantity(goods.getQuantity());
        transport.setVolume(goods.getVolume());
        transport.setWeight(goods.getWeight());
        transport.setCategories(getCategoriesIds(goods));
        transport.setDeleted(goods.getDeleted() == 1);
        return transport;
    }

    private List<Long> getCategoriesIds(Goods goods) {
        return goods.getCategoryes().stream().map(category -> {
            return category.getId();
        }).collect(Collectors.toList());
    }
}
