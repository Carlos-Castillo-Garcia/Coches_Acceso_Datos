package com.eep.Coches.Controller;

import com.eep.Coches.Entity.Coches;
import com.eep.Coches.ServiceImpl.CochesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/coches")
public class CochesController {

    public final static String COCHES_ADD = "addcoche";
    public final static String COCHES_LIST = "listcoche";
    public final static String COCHES_DELETE = "delcoche";
    public final static String COCHES_UPDATE = "updatecoche";

    @Autowired
    @Qualifier("CochesServiceImpl")
    private CochesServiceImpl cochesServiceImpl;

    @GetMapping("/listcoche")
    public String listcoche(Model model){
        model.addAttribute("coches", cochesServiceImpl.listAllCoches());
        return COCHES_LIST;
    }

    @GetMapping("/addcoches")
    public String addcochesget(Model model){
        model.addAttribute("coche", new Coches());
        return COCHES_ADD;
    }

    @PostMapping("/addcochespost")
    public String addcochespost(@ModelAttribute Coches coche){
        cochesServiceImpl.addCoches(coche);
        return "redirect:/coches/listcoche";
    }

    @PostMapping("/delcochesget")
    public String delcochesget(@RequestParam (value = "borrado") ArrayList<Integer> ids){
        if(ids.size() == 0){
            return "redirect:/coches/listcoche";
        }else{
            return COCHES_DELETE;
        }
    }

    @PostMapping("/updatecochesget")
    public String updatecochesget(Model model, @RequestParam (value = "update") Coches coche){
        System.out.println(coche.toString());
        model.addAttribute("coche", coche);
        return COCHES_UPDATE;
    }
}
