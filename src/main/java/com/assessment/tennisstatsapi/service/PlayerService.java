package com.assessment.tennisstatsapi.service;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assessment.tennisstatsapi.exceptions.InternalServerErrorErrorException;
import com.assessment.tennisstatsapi.model.Player;
import com.assessment.tennisstatsapi.util.DataUtil;

@Service
public class PlayerService<getCountriesRatio> {
	
	
    /**
	 * Function that returns the list of players sorted from best to worst
	 */
    public Optional<List<Player>> getPlayersOrderedByRank(){
        List<Player> players = null;
        
        try {
            players = DataUtil.getPlayers();
        } catch (IOException e) {
            throw new InternalServerErrorErrorException("An error occurred while trying to retrieve data");
        }
        
        Collections.sort(players,new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				return p1.getData().getRank().compareTo(p2.getData().getRank());
			}
		});
        
        return Optional.of(players);
    }
    
    
    
    /**
	 * Function that allows to return the information of a player thanks to his Id
	 */
    public Optional<Player> getPlayerById(Integer playerId) throws IOException  {
            return DataUtil.getPlayers().stream()
                    .filter(p -> p.getId() == playerId)
                    .findAny();
        
    }
    
    
    
    
    /**
	 * Function that calculates and returns all countries by their games won ratio
	 * @return Map
	 */
    
  	private Map<Map<String,String>, Double> getCountriesRatio(){
  		 List<Player> players = null;
         try {
             players = DataUtil.getPlayers();
         } catch (IOException e) {
             throw new InternalServerErrorErrorException("An error occurred while trying to retrieve data");
         }
  		
  		 Map<Map<String,String>, Double> map = null;
		try {
			map = players.stream().
					 collect(Collectors.groupingBy(p ->p.getCountry(),Collectors.averagingInt(p ->p.getData().getSumLast())));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
  						 
  	}
  	
  	
  	
        /**
    	 * Collecting the country with the highest win ratio
    	 * @return Map - Country information
    	 */
    	public Map<String, String> getCountryByMaxRatio() {
    		
    		Map<Map<String, String>,Double> coutriesByRatio= getCountriesRatio();
    		
    		for (Map.Entry<Map<String, String>,Double> entry : coutriesByRatio.entrySet()) {
    		     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    		}
    		
    		Map<String, String> maxRatio=Collections.max(coutriesByRatio.entrySet(), Map.Entry.comparingByValue()).getKey();
    		
    		return maxRatio;
    	}
    	
    	
    	
    	/**
    	 * Calculate  The average IMC  for player
    	 * @return Double - IMC value
    	 * @throws IOException 
    	 */
    	public double getIMCMoyenForAllPlayer() throws IOException {
    		
    		return DataUtil.getPlayers().stream()
    				.mapToDouble(p -> p.getIMC())
    	            .average().getAsDouble();
    	}
    	

    	/**
    	 * Calculate  The median  for players
    	 * @return Double - IMC value
    	 * @throws IOException 
    	 */
    	public double getMedianHeightOfPlayers() throws IOException {
    		
    		List<Player> players=DataUtil.getPlayers();
    		double median=0;
    		int medianPos=0;
    		
    		//If the size of the list is odd
    		if(players.size()%2 == 1) {
    			medianPos=(players.size()+1)/2;
    			median=players.get(medianPos).getData().getHeight();
    			
    		}else {
    			medianPos=players.size()/2;
    			median=(players.get(medianPos).getData().getHeight()
    					+players.get(medianPos+1).getData().getHeight()
    					/2);
    		}
    		
    		return median;
    	  }
    	
            
       
        

    }

