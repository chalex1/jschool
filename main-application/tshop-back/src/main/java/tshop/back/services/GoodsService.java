package tshop.back.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(GoodsService.class.getName());


    @Autowired
    public GoodsService(GoodsRepository goodsRepository, CategoryRepository categoryRepository) {
        this.goodsRepository = goodsRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<GoodsTransport> getGoodsPage(String name, Long priceFrom, Long priceTo,  Long quantityFrom, Integer page, Integer size) {
       logger.info("Getting goods");
        return goodsRepository.findPageWithFilter(
                defaultName(name),
                defaultPriceFrom(priceFrom),
                defaultPriceTo(priceTo),
                defaultQuantity(quantityFrom),
                new PageRequest(page-1, size)
        ).stream().map(goods -> {
            GoodsTransport transport = this.goodsEntityToTransport(goods);
            return transport;
        }).collect(Collectors.toList());
    }

    public List<GoodsTransport> getGoodsPage(String name,  Long quantityFrom, Integer page, Integer size) {
        logger.info("Getting goods");
        return goodsRepository.findPageWithFilter(
                defaultName(name),
                defaultQuantity(quantityFrom),
                new PageRequest(page-1, size)
        ).stream().map(goods -> {
            GoodsTransport transport = this.goodsEntityToTransport(goods);
            return transport;
        }).collect(Collectors.toList());
    }


    public List<GoodsTransport> getAllGoodsPage(int page, int size) {
        logger.info("Getting all goods");
        return goodsRepository.findPage(
                new PageRequest(page-1,size)
        ).stream().map(goods -> {
            GoodsTransport transport = this.goodsEntityToTransport(goods);
            return transport;
        }).collect(Collectors.toList());
    }

    public GoodsTransport getOne(Long id){
        return this.goodsEntityToTransport(goodsRepository.findOne(id));
    }


    public GoodsTransport saveGoods(GoodsTransport transport) {

        Goods goods = new Goods();
        if(transport.getId()!=0){
            goods.setId(transport.getId());
        }
        goods.setModel(transport.getModel());
        goods.setPrice(transport.getPrice());
        goods.setEnginetype(transport.getEnginetype());
        goods.setColor(transport.getColor());
        goods.setWeight(transport.getWeight());       
        goods.setVolume(transport.getVolume());
        goods.setQuantity(transport.getQuantity());
        goods.setDeleted(transport.isDeleted() ? 1 : 0);
        goods.setBrakefront(transport.getBrakefront());
        goods.setBrakerear(transport.getBrakerear());
        goods.setSuspensionfront(transport.getSuspensionfront());
        goods.setSuspensionrear(transport.getSuspensionrear());
        goods.setTiresfront(transport.getTiresfront());
        goods.setTiresrear(transport.getTiresrear());
        goods.setDimensions(transport.getDimensions());
        goods.setSeatheight(transport.getSeatheight());
        goods.setTransmission(transport.getTransmission());
        goods.setWarranty(transport.getWarranty());
        goods.setPromodescription(transport.getPromodescription());
        
        goods.setCategories(categoryRepository.findAll(transport.getCategories()));
        goodsRepository.save(goods);

        logger.info("Goods 's saved successfuly ", transport);
        return getOne(goods.getId());
    }

    private GoodsTransport goodsEntityToTransport(Goods goods) {
        GoodsTransport transport = new GoodsTransport();
        transport.setId(goods.getId());
        transport.setModel(goods.getModel());
        transport.setPrice(goods.getPrice());
        transport.setEnginetype(goods.getEnginetype());
        transport.setColor(goods.getColor());
        transport.setWeight(goods.getWeight());
        transport.setVolume(goods.getVolume());
        transport.setQuantity(goods.getQuantity());
        transport.setBrakefront(goods.getBrakefront());
        transport.setBrakerear(goods.getBrakerear());
        transport.setSuspensionfront(goods.getSuspensionfront());
        transport.setSuspensionrear(goods.getSuspensionrear());
        transport.setTiresfront(goods.getTiresfront());
        transport.setTiresrear(goods.getTiresrear());
        transport.setDimensions(goods.getDimensions());
        transport.setSeatheight(goods.getSeatheight());
        transport.setTransmission(goods.getTransmission());
        transport.setWarranty(goods.getWarranty());
        transport.setPromodescription(goods.getPromodescription());
        transport.setDeleted(goods.getDeleted() == 1);
        transport.setCategories(getCategoriesIds(goods));
        return transport;
    }

    private List<Long> getCategoriesIds(Goods goods) {
        return goods.getCategories().stream().map(category -> {
            return category.getId();
        }).collect(Collectors.toList());
    }

    private String defaultName(String name){
        return name==null||name.isEmpty()?"%":"%"+name+"%";
    }

    private Long defaultPriceFrom(Long priceFrom){
        return priceFrom==null||priceFrom<0?0L:priceFrom;
    }

    private Long defaultPriceTo(Long priceTo){
        return priceTo==null||priceTo<0?Long.MAX_VALUE:priceTo;
    }
    private Long defaultQuantity(Long q){
        return q==null||q<0? 0L:q;
    }
}
