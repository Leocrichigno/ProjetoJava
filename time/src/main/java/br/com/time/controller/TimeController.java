package br.com.time.controller;

import br.com.time.model.Time;
import br.com.time.repository.TimeRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author leocr
 */
@Controller
public class TimeController {
    
    //Instancia um objeto(Nao precisa da New Objeto)
    @Autowired
    private TimeRepository timeRepository;

    //Passar uma url(get), passar um inf oculta atraves de formularios(post)
    @GetMapping("/gerenciarTimes")
    public String listarTimes(Model model) {
        model.addAttribute("listaTimes", timeRepository.findAll());
        return "gerenciar_times";
    }

    @GetMapping("/novoTime")
    public String novoTime(Model model) {
        model.addAttribute("time", new Time());
        return "editar_time";
    }

    @GetMapping("/editarTime/{id}")
    public String editarTime(@PathVariable("id") long idTime, Model model) {
        Optional<Time> time = timeRepository.findById(idTime);
        model.addAttribute("time", time.get());
        return "editar_time";
    }

    @PostMapping("/salvarTime")
    public String salvarTime(Time time, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_time";
        }
        timeRepository.save(time);
        return "redirect:/gerenciarTimes";
    }

    @GetMapping("/excluirTime/{id}")
    public String excluirTime(@PathVariable("id") long idTime) {
        timeRepository.deleteById(idTime);
        return "redirect:/gerenciarTimes";
    }
    
}
