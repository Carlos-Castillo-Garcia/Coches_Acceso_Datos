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

    @PostMapping("/listcochesdelpost")
    public String listcochesdelpost(@RequestParam (value = "borrado") ArrayList<Integer> ids){
        if(ids.size() == 0){
            return "redirect:/coches/listcoche";
        }else{
            return "redirect:/coches/delcochesget";
        }
    }

    @PostMapping("/listcochesupdatepost")
    public String listcochesupdatepost(@RequestParam (value = "update") Integer id, Model model){
        if (id == null){
            return "redirect:/coches/listcoche";
        }else{
            model.addAttribute("coche", cochesServiceImpl.findbyid(id));
            return COCHES_UPDATE;
        }
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

    @PostMapping("/updatecochespost")
    public String updatecochespost(@ModelAttribute Coches coche){
        cochesServiceImpl.updateCoches(coche);
        return "redirect:/coches/listcoche";
    }
}
