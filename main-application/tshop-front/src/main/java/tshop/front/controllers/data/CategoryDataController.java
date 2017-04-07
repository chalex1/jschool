package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public CategoryTransport createCategory(@RequestBody CategoryTransport category){
        return categoryService.createCategory(category);
    }
}
