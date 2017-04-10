package tshop.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Category;
import tshop.back.repositories.CategoryRepository;
import tshop.back.transports.CategoryTransport;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Роднуля on 02.04.2017.
 */
@Service
@Transactional
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Transactional
    public List<CategoryTransport> getAllCategories() {
        return categoryRepository.findAll().stream().map(category -> {
            return getCategoryTransport(category);
        }).collect(Collectors.toList());
    }

    private CategoryTransport getCategoryTransport(Category category) {
        CategoryTransport categoryTransport = new CategoryTransport();
        categoryTransport.setId(category.getId());
        categoryTransport.setName(category.getName());
        return categoryTransport;
    }

//    @Transactional
//    public CategoryTransport createCategory(CategoryTransport ctr) {
//        Category category = new Category();
//
//        category.setName(ctr.getName());
//        categoryRepository.save(category);
//        ctr.setId(category.getId());
//        ctr.setName(category.getName());
//        return ctr;
//
//    }

    @Transactional
    public CategoryTransport saveCategory(CategoryTransport ctr) {
        Category category = new Category();
        category.setId(ctr.getId());
        category.setName(ctr.getName());
        categoryRepository.save(category);
        ctr.setId(category.getId());
        ctr.setName(category.getName());
        return ctr;
    }

    @Transactional
    public boolean deleteCategory(long id){

        Category category = categoryRepository.getOne(id);
        if(category!=null){
            category.setDeleted(1);
            categoryRepository.save(category);
            return true;
        }

        return false;
    }

    @Transactional
    public CategoryTransport getOne(long id){
        Category category = categoryRepository.findOne(id);
        return getCategoryTransport(category);
    }
}
