package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import tshop.back.services.CategoryService;
import tshop.back.transports.CategoryTransport;

import java.util.List;

/**
 * Created by Роднуля on 02.04.2017.
 */

@Component
@RestController
@RequestMapping(path = "data/categories")
public class CategoryDataController {

    CategoryService categoryService;

    @Autowired
    public CategoryDataController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<CategoryTransport> getCategories(){
        return categoryService.getAllCategories();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CategoryTransport getById(@PathVariable(value="id") Long id) {
        return categoryService.getOne(id);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, produces = "application/json", consumes = "application/json")
    public CategoryTransport saveCategory(@RequestBody CategoryTransport category){
        return categoryService.saveCategory(category);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public boolean deleteCategory(@RequestParam(name="id") long id){
        return categoryService.deleteCategory(id);
    }
}
