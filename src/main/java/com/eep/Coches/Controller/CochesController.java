package com.eep.Coches.Controller;

import com.eep.Coches.Component.CochesComponent;
import com.eep.Coches.Model.CocheModel;
import com.eep.Coches.ServiceImpl.CochesServiceImpl;
import com.eep.Coches.ServiceImpl.MarcaServiceImpl;
import com.eep.Coches.ServiceImpl.ModeloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    @Qualifier("CochesComponent")
    private CochesComponent cochesComponent;

    @GetMapping("/")
    public String listcoche(Model model) {
        model.addAttribute("coches", cochesServiceImpl.listAllCoches());
        cochesComponent.Correcto("Listado Correcto");
        return COCHES_LIST;
    }

    @PostMapping("/listcochesdelpost")
    public String listcochesdelpost(Model model, @RequestParam(value = "borrado") ArrayList<Integer> ids) {
        cochesServiceImpl.delbyid(ids);
        cochesComponent.Correcto("Borrado con exito");
        return "redirect:/";
    }

    @PostMapping("/listcochesupdatepost")
    public String listcochesupdatepost(@RequestParam(value = "update") Integer id, Model model) {
        if (id == null) {
            cochesComponent.Error("Registro no encontrado para update");
            return "redirect:/";
        } else {
            cochesComponent.Correcto("Registro encontrado para update");
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
        model.addAttribute("coche", new CocheModel());
        cochesComponent.Correcto("entrando Get de agregacion de coches");
        return COCHES_ADD;
    }

    @PostMapping("/addcochespost")
    public String addcochespost(@Valid @ModelAttribute("coche") CocheModel coche, BindingResult result) {
        if (result.hasErrors()) {
            cochesComponent.Error("Error en la agregacion de coches nuevos");
            return COCHES_ADD;
        } else {
            cochesServiceImpl.addCoches(cochesServiceImpl.ModelaEntityCoche(coche));
            cochesComponent.Correcto("Coche Agregado correctamente");
            return "redirect:/";
        }
    }

    @PostMapping("/updatecochespost")
    public String updatecochespost(@Valid @ModelAttribute CocheModel coche, BindingResult result) {
        if (result.hasErrors()) {
            cochesComponent.Error("Error en la actualizacion de coches");
            return COCHES_UPDATE;
        } else {
            cochesServiceImpl.updateCoches(cochesServiceImpl.ModelaEntityCoche(coche));
            cochesComponent.Correcto("Coche actualizado con exito");
            return "redirect:/";
        }
    }
}
