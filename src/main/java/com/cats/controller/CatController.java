package com.cats.controller;

import com.cats.model.Cat;
import com.cats.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class CatController {

    private CatService catService;
    private static final String UPLOAD_DIRECTORY ="/resources/";

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

    @RequestMapping(value = "catdata/handleUpload/{id}", method = RequestMethod.POST)
    public String handleUpload( @PathVariable("id") int id,
            @RequestParam(value = "file", required = false) MultipartFile multipartFile,
            HttpServletResponse httpServletResponse) {

        String orgName = multipartFile.getOriginalFilename();
        String filePlaceToUpload = "/home/vlad/IdeaProjects/Cat/src/main/webapp/resources/";
        String filePath = filePlaceToUpload + orgName;
        File dest = new File(filePath);
        try {
            multipartFile.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Cat cat = this.catService.getCatById(id);
        cat.setPhoto(UPLOAD_DIRECTORY+orgName);
        this.catService.updateCat(cat);

        return "handleUpload";
    }


}


