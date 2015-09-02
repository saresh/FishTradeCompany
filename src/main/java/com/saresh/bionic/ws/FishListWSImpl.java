package com.saresh.bionic.ws;

import java.io.StringWriter;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.saresh.bionic.entity.FishItem;
import com.saresh.bionic.service.FishItemService;

@WebService(endpointInterface = "com.saresh.bionic.ws.FishListWS")
@Named
public class FishListWSImpl implements FishListWS {
	private FishItemList fishList = new FishItemList();

	@Inject
	FishItemService fishItemService;

	@Override
	public String getFishList() {
		try {
			fishList.setFish(fishItemService.findFishAvaliableForSale());
			JAXBContext jc = JAXBContext.newInstance(FishItemList.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter sw = new StringWriter();
			m.marshal(fishList, sw);
			String txt = sw.toString();
			return txt;
		} catch(JAXBException e){ 
			System.out.println(e.getMessage());
			return null; 
		}
	}

	@Override
	public FishItem getFishItem(int id) {
		return fishItemService.findById(id);
	}

}
