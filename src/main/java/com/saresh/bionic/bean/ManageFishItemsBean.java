package com.saresh.bionic.bean;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.FishItem;
import com.saresh.bionic.service.FishItemService;

@Named
@Scope("session")
public class ManageFishItemsBean implements Serializable {
	
	private static final long serialVersionUID = 6112167376011029854L;

	private List<FishItem> receivedFishList = null;
	private List<FishItem> expectedFishList = null;
	
	private FishItem itemToEdit;
	
	@Inject
	FishItemService fishItemService;
		
	public void updateReceivedFishList(){
		receivedFishList = fishItemService.findAllReceived();
	}
	
	public void updateExpectedFishList(){
		expectedFishList = fishItemService.findAllExpected();
	}
	
	public String editFishItem(FishItem fishItem){
		itemToEdit = fishItem;
		return "/gm/editFishItem";
	}
	
	public String updateFishItem(){
		fishItemService.save(itemToEdit);
		return "/gm/manageReceivedFish";
		
	}
	
	public String changeAvaliability(String fishItemId){
		int id = Integer.parseInt(fishItemId);
		
		fishItemService.changeAvaliability(id);
		
		return "/gm/manageReceivedFish";
	}
	
	public String setWriteOff(String fishItemId){
		int id = Integer.parseInt(fishItemId);
		fishItemService.setAsWriteOff(id);
		return "/gm/manageReceivedFish";
	}

	public List<FishItem> getReceivedFishList() {
		return receivedFishList;
	}

	public void setReceivedFishList(List<FishItem> fishList) {
		this.receivedFishList = fishList;
	}

	public FishItem getItemToEdit() {
		return itemToEdit;
	}

	public void setItemToEdit(FishItem itemToEdit) {
		this.itemToEdit = itemToEdit;
	}

	public List<FishItem> getExpectedFishList() {
		return expectedFishList;
	}

	public void setExpectedFishList(List<FishItem> expectedFishList) {
		this.expectedFishList = expectedFishList;
	}

}
