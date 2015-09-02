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
public class WriteOffBean implements Serializable {
	private static final long serialVersionUID = 595258061255001368L;

	private List<FishItem> writeOffList;
	
	@Inject
	private FishItemService fishItemService;
	
	public void updateWriteOffList(){
		writeOffList = fishItemService.findWriteOffFishItems();
	}
	
	public String writeOff(FishItem fi){
		fi.setQuantity(0);
		fishItemService.save(fi);
		
		return "/csm/writeOff";		
	}

	public List<FishItem> getWriteOffList() {
		return writeOffList;
	}

	public void setWriteOffList(List<FishItem> writeOffList) {
		this.writeOffList = writeOffList;
	}
	
}
