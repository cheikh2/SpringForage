package com.sid.web;

import com.sid.dao.ClientRepository;
import com.sid.dao.VillageRepository;
import com.sid.entities.Client;
import com.sid.entities.Village;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;


@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VillageRepository villageRepository;

    @RequestMapping(value="client")
    public String allClient(Model model){
        List<Client> clients=clientRepository.findAll();
        model.addAttribute("listClients",clients);
        return "client/clients";
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
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Long id){
        clientRepository.deleteById(id);
        return "redirect:/client";
    }

    // chargement du formulaire d'ajout de client
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String addClient(Model model){
        List<Village> villages=villageRepository.findAll();
        model.addAttribute("villages", villages);
        model.addAttribute("client", new Client());
        return "client/addClient";
    }

    // methode d'édition de client
    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String edit(Model model, Long id){
        Optional<Client> c=clientRepository.findById(id);
        model.addAttribute("client", c);
        return "client/editClient";
    }

    // methode d'ajout de client
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(Model model, Client client){
        clientRepository.save(client);
        return "redirect:/client";
    }

    @RequestMapping(value="/403")
    public String accessDenied(){return "403";}
}
