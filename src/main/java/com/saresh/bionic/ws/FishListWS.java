package com.saresh.bionic.ws;

import javax.jws.WebService;

import com.saresh.bionic.entity.FishItem;

@WebService
public interface FishListWS {
	public String getFishList();
	public FishItem getFishItem(int id);
}
