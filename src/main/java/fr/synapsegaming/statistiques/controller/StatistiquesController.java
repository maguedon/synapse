package fr.synapsegaming.statistiques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.synapsegaming.commons.controller.AbstractController;
import fr.synapsegaming.media.service.ArticleService;
import fr.synapsegaming.statistiques.service.StatistiquesService;
import fr.synapsegaming.ui.service.ResourceService;


/**
 * <b>HomeController</b> route every action made from the "Home" page
 * 
 * @author Meidi
 * 
 */
@Controller("StatistiquesController")
@SessionAttributes(value = { "resources", "userResources" })
@RequestMapping("/stats")
public class StatistiquesController extends AbstractController {

	@Autowired
	ResourceService resourceService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	StatistiquesService statistiquesService;
   
    /**
     * The default constructor to initialize the page
     * 
     * @param request
     *            : the HttpRequest sent
     * @return modelAndView
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home() {
        page = new ModelAndView();
        page.setViewName("Statistiques");
        page.addObject("resources", resourceService.listMainMenu());
        page.addObject("proms", articleService.getFiveLastProms());
        page.addObject("fiveClassesMostPlayed", statistiquesService.listFiveObjectsMostPlayed("Classes"));
        page.addObject("fiveRacesMostPlayed", statistiquesService.listFiveObjectsMostPlayed("Races"));
        page.addObject("fiveSpecMostPlayed", statistiquesService.listFiveObjectsMostPlayed("Specializations"));
        page.addObject("fiveUsersMostActive", statistiquesService.listUsersMostActive());

        if (user != null)
            page.addObject("userResources", resourceService.listUserResources(user.getGroup().getId()));
        return page;
    }

    
}
