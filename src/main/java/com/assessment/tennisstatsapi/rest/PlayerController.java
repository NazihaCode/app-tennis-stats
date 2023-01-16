package com.assessment.tennisstatsapi.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.tennisstatsapi.exceptions.ResourceNotFoundException;
import com.assessment.tennisstatsapi.model.Player;
import com.assessment.tennisstatsapi.service.PlayerService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600,allowCredentials = "false" , methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping(value = "/tennis-stats/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    @Autowired
    private PlayerService<?> playerService;
    
    @RequestMapping("/") 
    public String Welcome() {
        return "Tennis statistiques Api";
    }
    
    
    
    /**
	 * Return the list of players sorted from best to worst
	 */
    @GetMapping("/players")
    public Optional<List<Player>> getPlayers() {
        return playerService.getPlayersOrderedByRank();

    }
    
    
    
    
    /**
	 * Return the information of a player thanks to his Id
	 */
    @GetMapping(path="/player/{id}")
    public  @ResponseBody Player getPlayerById(@PathVariable Integer id)  {
    	Optional<Player> player = null;
    	
		try {
			player = playerService.getPlayerById(id);
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
    	
    	if (!player.isPresent()) {throw new ResourceNotFoundException("Player not found with id "+id);}
    	else
    	return player.get();
    }
    
    
    
	/**
	 * Read - Get Country with the highest win ratio
	 * @return - A Map object of Country full filled
	 */
	@GetMapping("/countryByTheBestRatio")
	public Map<String, String> getCountryByMaxRatio(){
		
	       return playerService.getCountryByMaxRatio();
	}
	
	
	
	/**
	 * Read - Get Average IMC of all players
	 * @return Double - IMC value
	 * @throws IOException 
	 */
	@GetMapping("/imcAverage")
	public Double getIMCMoyenForAllPlayer() throws IOException {
		
		return playerService.getIMCMoyenForAllPlayer();
	}
	
	
	
	
	/**
	 * Read - Get The median player height
	 * @return Double - Median value
	 * @throws IOException 
	 */
	@GetMapping("/median")
	public Double getMedianeHeightOfPlayers() throws IOException {
		
		return playerService.getMedianHeightOfPlayers();
	}
}
