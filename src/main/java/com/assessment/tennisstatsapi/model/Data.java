package com.assessment.tennisstatsapi.model;

import java.util.Arrays;
import java.util.Map;

public class Data {

    private Integer rank;
    private Integer points;
    private Integer weight;
    private Integer height;
 

	private Integer age;
   
    private int[] last = null;

   


    /**
     *
     * @param last
     * @param rank
     * @param weight
     * @param age
     * @param points
     * @param height
     */
  
    public Integer getRank() {
        return rank;
    }

    public Data(Integer rank, Integer points, Integer weight, Integer height, Integer age, int[] last) {
		super();
		this.rank = rank;
		this.points = points;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.last = last;
	}



    public Integer getPoints() {
        return points;
    }

 

    public Integer getWeight() {
        return weight;
    }



    public Integer getHeight() {
        return height;
    }


    public Integer getAge() {
        return age;
    }



  
	public int[] getLast() {
		return last;
	}



	public int getSumLast() {
		return Arrays.stream(this.last).sum();
	}
	
	
}
