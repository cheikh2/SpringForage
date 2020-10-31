package com.sid.web;

import com.sid.dao.VillageRepository;
import com.sid.entities.Village;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class VillageController {
    @Autowired
    private VillageRepository villageRepository;

    @RequestMapping(value="village")
    public String allVillage(Model model){
        List<Village> villages=villageRepository.findAll();
        model.addAttribute("listVillages",villages);
        return "village/villages";
        /*
        public String allClient(Model model,
                            @RequestParam(name = "page", defaultValue = "0") int p,
                            @RequestParam(name = "size", defaultValue = "5") int s) {
        Page<Client> pageClients;
        pageClients = clientRepository.findAll(new PageRequest(p, s));

        model.addAttribute("listClients", pageClients.getContent());
        int[] pages = new int[pageClients.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourant",p);
        return "clients";
    }
        */
    }
    @RequestMapping(value = "/delete1", method = RequestMethod.GET)
    public String delete(Long id){
        villageRepository.deleteById(id);
        return "redirect:/village";
    }

    // chargement du formulaire d'ajout de client
    @RequestMapping(value="/formVillage", method = RequestMethod.GET)
    public String addVillage(Model model){
        model.addAttribute("village", new Village());
        return "village/addVillage";
    }

    // methode d'ajout de client
    @RequestMapping(value="/saveV", method=RequestMethod.POST)
    public String save(Model model, Village village){
        villageRepository.save(village);
        return "redirect:/village";
    }
}
