package com.eep.Coches.Controller;

import com.eep.Coches.Entity.Coches;
import com.eep.Coches.ServiceImpl.CochesServiceImpl;
import com.eep.Coches.ServiceImpl.MarcaServiceImpl;
import com.eep.Coches.ServiceImpl.ModeloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CochesController {

    public final static String COCHES_ADD = "addcoche";
    public final static String COCHES_LIST = "index";
    public final static String COCHES_DELETE = "delcoche";
    public final static String COCHES_UPDATE = "updatecoche";

    @Autowired
    @Qualifier("CochesServiceImpl")
    private CochesServiceImpl cochesServiceImpl;

    @Autowired
    @Qualifier("MarcaServiceImpl")
    private MarcaServiceImpl marcaServiceImpl;

    @Autowired
    @Qualifier("ModeloServiceImpl")
    private ModeloServiceImpl modeloServiceImpl;


    @GetMapping("/listcoche")
    public String listcoche(Model model) {
        model.addAttribute("coches", cochesServiceImpl.listAllCoches());
        return COCHES_LIST;
    }

    @PostMapping("/listcochesdelpost")
    public String listcochesdelpost(Model model, @RequestParam(value = "borrado") ArrayList<Integer> ids) {
        cochesServiceImpl.delbyid(ids);
        return "redirect:/listcoche";
    }

    @PostMapping("/listcochesupdatepost")
    public String listcochesupdatepost(@RequestParam(value = "update") Integer id, Model model) {
        if (id == null) {
            return "redirect:/listcoche";
        } else {
            model.addAttribute("marcas", marcaServiceImpl.listallMarcas());
            model.addAttribute("modelos", modeloServiceImpl.listallmodelos());
            model.addAttribute("coche", cochesServiceImpl.findbyid(id));
            return COCHES_UPDATE;
        }
    }

    @GetMapping("/addcoches")
    public String addcochesget(Model model) {
        model.addAttribute("marcas", marcaServiceImpl.listallMarcas());
        model.addAttribute("modelos", modeloServiceImpl.listallmodelos());
        model.addAttribute("coche", new Coches());
        return COCHES_ADD;
    }

    @PostMapping("/addcochespost")
    public String addcochespost(@ModelAttribute Coches coche) {
        cochesServiceImpl.addCoches(coche);
        return "redirect:/listcoche";
    }

    @PostMapping("/updatecochespost")
    public String updatecochespost(@ModelAttribute Coches coche) {
        cochesServiceImpl.updateCoches(coche);
        return "redirect:/listcoche";
    }
}
