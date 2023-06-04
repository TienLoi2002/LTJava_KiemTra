package com.kiemtra.nguyentienloi.controller;


import com.kiemtra.nguyentienloi.entity.PhongBan;
import com.kiemtra.nguyentienloi.service.NhanVienService;
import com.kiemtra.nguyentienloi.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/phongban")
public class PhongBanController {

    @Autowired
    private PhongBanService phongBanService;

    @Autowired
    private NhanVienService nhanVienService;
    @GetMapping
    public String showAllCategories(Model model) {
        model.addAttribute("categories", phongBanService.getAllPhongBan());
        model.addAttribute("title", "Categories List");
        return "category/list";
    }



    @GetMapping("/add")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new PhongBan());
        return "category/add";
    }


    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") PhongBan category, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "category/add";
        }
        phongBanService.addPhongBan(category);

        return "redirect:/categories";
    }


    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") String id, Model model){
        PhongBan editCategory = phongBanService.getPhongBanById(id);
        if(editCategory != null){
            model.addAttribute("category", editCategory);

            return "category/edit";
        }else {
            return "not-found";
        }
    }/*
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("book")Category updateCategory, BindingResult bindingResult ){
        if (bindingResult.hasErrors()){

            return "category/edit";
        }
        PhongBanService.getAllCategories().stream()
                .filter(category -> category.getId() == updateCategory.getId())
                .findFirst()
                .ifPresent(category -> {
                    PhongBanService.updateCategory(updateCategory);
                });
        return "redirect:/categories";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id){
        PhongBanService.deleteCategory(id);
        return "redirect:/categories";
    }

    @GetMapping ("/delete/{id}")
    public String deleteBook (@PathVariable ("id") Long id)  {

        PhongBanService.deleteCategory(id);
        return "redirect:/categories";
    }

    @GetMapping("/details/{id}")
    public String listByCategory(@PathVariable("id") long id, Model model){
        List<Book> list = bookService.getAllBooks().stream()
                .filter(book -> book.getCategory().getId() == id).toList();


        model.addAttribute("list",list);
        model.addAttribute("title", PhongBanService.getCategoryById(id).getName());
        return "category/details";
    }
    */
    
}
