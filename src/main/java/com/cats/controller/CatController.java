package com.cats.controller;

import com.cats.model.Cat;
import com.cats.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CatController {

    private CatService catService;

    @Autowired(required = true)
    @Qualifier(value = "catService")
    public void setCatService(CatService catService) {
        this.catService = catService;
    }

    @RequestMapping(value = "cats", method = RequestMethod.GET)
    public String listCats(Model model){
        model.addAttribute("cat", new Cat());
        model.addAttribute("listCats", this.catService.listCats());

        return "cats";
    }

    @RequestMapping(value = "/cats/add", method = RequestMethod.POST)
    public String addCat(@ModelAttribute("cat") Cat cat) {
        if(cat.getId() == 0){
            this.catService.addCat(cat);
        } else {
            this.catService.updateCat(cat);
        }
        return "redirect:/cats";
    }

    @RequestMapping("/remove/{id}")
    public String removeCat(@PathVariable("id") int id) {
        this.catService.removeCat(id);
        return "redirect:/cats";
    }

    @RequestMapping("edit/{id}")
    public String editCat(@PathVariable("id") int id, Model model) {
        model.addAttribute("cat",this.catService.getCatById(id));
        model.addAttribute("listCats", this.catService.listCats());

        return "cats";
    }

    @RequestMapping("catdata/{id}")
    public String catData(@PathVariable("id") int id, Model model) {
        model.addAttribute("cat", this.catService.getCatById(id));

        return "catdata";
    }
}


