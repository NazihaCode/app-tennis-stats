package com.assessment.tennisstatsapi.model;

import java.util.Map;

public class Player {
    private Integer id;
    private String firstname;
    private String lastname;
    private String shortname;
    private String sex;
    private Map<String, String> country;
	private String picture;
    private Data data;

    
    public Player() {
    }

    /**
     *
     * @param country
     * @param firstname
     * @param data
     * @param sex
     * @param id
     * @param shortname
     * @param picture
     * @param country
     * @param lastname
     */
   

  

	public Player(Integer id, String firstname, String lastname, String shortname, String sex,
			Map<String, String> country, String picture, Data data) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.shortname = shortname;
		this.sex = sex;
		this.country = country;
		this.picture = picture;
		this.data = data;
	}

	public Integer getId() {
        return id;
    }



    public String getFirstname() {
        return firstname;
    }



    public String getLastname() {
        return lastname;
    }



    public String getShortname() {
        return shortname;
    }



    public String getSex() {
        return sex;
    }


  
    public Map<String, String> getCountry() {
  		return country;
  	}

    public String getPicture() {
        return picture;
    }



    public Data getData() {
        return data;
    }


	/**
	 * Calculate IMC of player
	 * @return IMC Player
	 */
	public double getIMC() {
		return ((double)data.getWeight()/(double)(data.getHeight()*data.getHeight()))*10;
	}
}
