package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;
import java.util.Objects;

public class Day1FileParser {
    String CurrentFile;

	List<Integer> FirstCol = new ArrayList<>();
	List<Integer> SecondCol = new ArrayList<>();
	
	int TotalSum;

    public Day1FileParser(String file){
        this.CurrentFile = file;
    }


    public int parseFile(){
        try {
            BufferedReader bfro = new BufferedReader(
									new FileReader(this.CurrentFile));
			// Declaring a string variable
			String st;

			while ((st = bfro.readLine()) != null){
				
				String[] numbers = st.trim().split(" +");
				this.FirstCol.add(Integer.valueOf(numbers[0]));
				this.SecondCol.add(Integer.valueOf(numbers[1]));
				}
				Collections.sort(this.FirstCol);
				Collections.sort(this.SecondCol);
				bfro.close();
			}
		catch(FileNotFoundException exc) {
			System.out.println(exc);
		}
		catch(IOException exc){
			System.out.println(exc);
		}

		this.calcSum();
		long totalsum = this.CalcUniqueValuesSum();
		return this.TotalSum;
    }

	public void calcSum(){
		for (int i=0; i < this.FirstCol.size(); i++){
			this.TotalSum += Math.abs(this.SecondCol.get(i) - this.FirstCol.get(i));
		}
	}


	private long CalcUniqueValuesSum(){
		long TotalUniqueSum = 0;
		for (int i=0; i < this.FirstCol.size(); i++){
			int currentSum = 0;
			for (int j=0; j < this.SecondCol.size(); j++){
				if (Objects.equals(this.FirstCol.get(i), this.SecondCol.get(j))){
					
					currentSum +=1;
					System.out.println(FirstCol.get(i));
					System.out.println(this.SecondCol.get(j));
					System.out.println(currentSum);
				}
				
			}
			System.out.println(currentSum * this.FirstCol.get(i));
			TotalUniqueSum += currentSum * this.FirstCol.get(i);
		}
		System.out.println(TotalUniqueSum);
		return TotalUniqueSum;
	}
	
}
