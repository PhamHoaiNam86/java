package com.example.phamhoainam_8871.controller;


import com.example.phamhoainam_8871.entity.NhanVien;
import com.example.phamhoainam_8871.services.NhanVienService;
import com.example.phamhoainam_8871.services.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/nhanVien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String showAllNhanVien(Model model) {
        List<NhanVien> nhanVien = nhanVienService.getALLNhanViens();
        model.addAttribute("nhanVien",nhanVien);
        return "nhanVien/list";
    }
    @GetMapping("/add")
    public String addNhanVienForm(Model model){
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBan", phongBanService.getAllPhongBan());
        return "nhanVien/add";
    }
    @PostMapping("/add")
    public String addNhanVien(@ModelAttribute("nhanVien")NhanVien nhanVien){
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanVien";
    }
    @GetMapping("/edit/{id}")
    public String editNhanVien(@PathVariable("id") Long id, Model model) {
        Optional<NhanVien> editNhanVien = nhanVienService.getALLNhanViens().stream()
                .filter(nhanVien -> nhanVien.getId().equals(id))
                .findFirst();
        if (editNhanVien.isPresent()) {
            model.addAttribute("nhanVien", editNhanVien);
            return "nhanVien/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editNhanVien(NhanVien nhanVien) {
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/phongBan";
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id")Long id){
        Iterator<NhanVien> iterator = nhanVienService.getALLNhanViens().iterator();
        while (iterator.hasNext()){
            NhanVien nhanVien = nhanVienService.getNhanVienById(id);
            if(nhanVien.getId() == id){
                nhanVienService.deleteNhanVien(id);
                break;
            }
        }
        return "redirect:/nhanVien";
    }
}
