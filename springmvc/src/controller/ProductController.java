package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Product;

@Controller
public class ProductController {
    @RequestMapping("/addProduct")
    public ModelAndView add(Product product) throws Exception{
        /*
        *   注： addProduct.jsp 提交的name和price会自动注入到参数 product里
            注： 参数product会默认被当做值加入到ModelAndView 中，相当于：
            mav.addObject("product",product);
        * */
        if(product.getName()==null || product.getPrice()==0.0){
            ModelAndView mav = new ModelAndView("addProduct");
            return mav;
        }else{
            ModelAndView mav = new ModelAndView("showProduct");
            return mav;
        }
    }
}
