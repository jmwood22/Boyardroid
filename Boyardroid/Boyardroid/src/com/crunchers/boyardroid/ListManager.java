package com.crunchers.boyardroid;

import java.util.ArrayList;

public class ListManager 
{
	private static boolean fridge = true;
	private static boolean viewRecipes = false;
	private ArrayList<String> tempList = new ArrayList<String>();
	private static ArrayList<String> fridgeList = new ArrayList<String>();
	private static ArrayList<String> quickList = new ArrayList<String>();
	
	public ListManager() 
	{
		super();
	}
	
	
	public boolean getFlag()
	{
		return fridge;
	}
	
	public void FridgeListTrue()
	{
		ListManager.fridge = true;
	}
	
	public void FridgeListFalse()
	{
		ListManager.fridge= false;
	}
	
	public boolean getViewRecipes()
	{
		return viewRecipes;
	}
	
	public void setViewRecipes(boolean val)
	{
		viewRecipes = val;
	}
	
	public void addToTempList(String ingredient)
	{
		if(!this.tempList.contains(ingredient))
			this.tempList.add(ingredient);
	}
	
	public void removeFromTempList(String ingredient)
	{
		this.tempList.remove(ingredient);
	}

	public void clearTempList()
	{
		this.tempList.clear();
	}
	
	public int tempListSize()
	{
		return this.tempList.size();
	}
	
	public String getFromTempList(int index)
	{
		return this.tempList.get(index);
	}
	
	public ArrayList<String> getFridgeList()
	{
		return ListManager.fridgeList;
	}
	
	public void addToFridge(String ingredient)
	{
		ListManager.fridgeList.add(ingredient);
	}
	
	public void removeFromFridge(String ingredient)
	{
		ListManager.fridgeList.remove(ingredient);
	}

	public ArrayList<String> getQuickList()
	{
		return ListManager.quickList;
	}
	
	public void addToQuickList(String ingredient)
	{
		ListManager.quickList.add(ingredient);
	}
	
	public void removeFromQuickList(String ingredient)
	{
		ListManager.quickList.remove(ingredient);
	}

	public void mergeLists()
	{
		if(ListManager.fridge==true)
		{
			for(int i = 0; i<this.tempListSize(); i++)
				this.addToFridge(this.getFromTempList(i));
		}
		
		else
		{
			for(int i = 0; i<this.tempListSize(); i++)
				this.addToQuickList(this.getFromTempList(i));
		}
		
		this.clearTempList();
	}
}
