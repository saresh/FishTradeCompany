package com.saresh.bionic.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.saresh.bionic.entity.FishItem;

@XmlRootElement
public class FishItemList {
	private List<FishItem> fish;
	
	public FishItemList(){
		fish = new ArrayList<FishItem>();
	}

	@XmlElementWrapper(name = "fishList")
    @XmlElement(name = "fishItem", type = FishItem.class)
	public List<FishItem> getFish() {
		return fish;
	}

	public void setFish(List<FishItem> fish) {
		this.fish = fish;
	}
}
