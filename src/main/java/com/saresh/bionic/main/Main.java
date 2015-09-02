package com.saresh.bionic.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.entity.FishItem;
import com.saresh.bionic.entity.Provider;
import com.saresh.bionic.entity.ProviderParcel;
import com.saresh.bionic.entity.Parcel;
import com.saresh.bionic.entity.ParcelItem;
import com.saresh.bionic.entity.Staff;
import com.saresh.bionic.entity.User;
import com.saresh.bionic.report.Result;
import com.saresh.bionic.report.ResultByDate;
import com.saresh.bionic.report.ResultByFish;
import com.saresh.bionic.service.CustomerService;
import com.saresh.bionic.service.FishItemService;
import com.saresh.bionic.service.ProviderParcelService;
import com.saresh.bionic.service.ParcelItemService;
import com.saresh.bionic.service.ParcelService;
import com.saresh.bionic.service.ProviderService;
import com.saresh.bionic.service.StaffService;
import com.saresh.bionic.service.UserService;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new 
				ClassPathXmlApplicationContext("spring//application-config.xml");
		
		CustomerService customerService = 
				context.getBean(CustomerService.class);
		
		StaffService staffService = 
				context.getBean(StaffService.class);
		
		FishItemService fishItemService = 
				context.getBean(FishItemService.class);
		
		ParcelService parcelService = 
				context.getBean(ParcelService.class);
		
		ParcelItemService parcelItemService = 
				context.getBean(ParcelItemService.class);
		
		ProviderParcelService fishProviderService = 
				context.getBean(ProviderParcelService.class);
		
		UserService userService = 
				context.getBean(UserService.class);
		
		ProviderService providerService = context.getBean(ProviderService.class);
		
//		User user = userService.fingById(2);
//		System.out.println(user.getUserRole());
		
//		Provider p = new Provider();
//		p.setName("Atlantic fresh");
//		p.setEmail("info@atlfresh.com");
//		p.setTelephone("+660458788778");
//		
//		providerService.save(p);
					
		
//		Result result = parcelService.getTotalReport(new java.sql.Date(10), 
//				new java.sql.Date(new java.util.Date().getTime()));	
//		
//		System.out.println(result.getWeight());
//		System.out.println(result.getIncome());
//		System.out.println(result.getProfit());
		
//		List<ResultByFish> result = parcelService.getReportByFish(new java.sql.Date(10), 
//				new java.sql.Date(new java.util.Date().getTime()));	
//		
//		for (ResultByFish res : result){
//			System.out.print(res.getFish());
//			System.out.print(" " + res.getWeight());
//			System.out.print(" " + res.getIncome());
//			System.out.println(" " + res.getProfit());
//		}
//		
//		List<ResultByDate> dateres = parcelService.getReportByDate(new java.sql.Date(10), 
//				new java.sql.Date(new java.util.Date().getTime()));	
//		
//		for (ResultByDate dr : dateres){
//			System.out.print(dr.getDate());
//			System.out.print(" " + dr.getWeight());
//			System.out.print(" " + dr.getIncome());
//			System.out.println(" " + dr.getProfit());
//		}
		
//		System.out.println(customerService.findById(1).getName());
				
//		for (Parcel p : parcelService.findParcelsByStatus("Client created order")){
//			System.out.println(p.getId());
//		}
		
//		System.out.println(parcelService.findById(1).getStatus());
		
//		for (ParcelItem pi : parcelService.findById(7).getParcelItems()){
//			System.out.println(pi.getFishItem().getName());
//		}
		
		
//		/* Create parcel */
//		Parcel parcel = new Parcel();
//		parcel.setCustomer(customerService.findById(1));
//		parcel.setStatus("Client created order");
//		parcel.setOrderDate(new java.sql.Date(10000000));
//		
//		List<ParcelItem> parcelItems = new ArrayList<ParcelItem>();
//				
//		ParcelItem pi = new ParcelItem();
//		pi.setFishItem(fishItemService.findById(1));
//		pi.setQuantity(20000);	
//		pi.setPrice(pi.getQuantity() * pi.getFishItem().getPrice());
//		
//		parcelItems.add(pi);
//				
//		parcelService.save(parcel, parcelItems);
		
				
				
//		/* When fish item arrives */
//		fishItemService.registerFishItemArrival(1, 35000);
//		fishItemService.updatePrice(1, 400);
//		fishItemService.setAvaliability(1, true);
		
		/*---------------------------------------------------------------------------------------------*/
		
//		/* Add fish item to DB # 2 */
//		FishItem fish = new FishItem();
//		fish.setName("Tuna");
//		fish.setDescription("Best tuna in the world");
//		fish.setPricePaidFor(200);
//		fish.setQuantityBought(50000);
//		fish.setAvaliable(false);
//		fish.setFishProvider(fishProviderService.findById(1));		
//		
//		fishItemService.save(fish);		
		
		
		
//		/* register new fish item company ordered */
//		FishProvider fp = new FishProvider();
//		fp.setName("Oceania");
//		
//		
//		/* Add fish item to DB */
//		FishItem fish = new FishItem();
//		fish.setName("Carp");
//		fish.setDescription("Delicious carp");
//		fish.setPricePaidFor(300);
//		fish.setQuantityBought(35000);
//		fish.setAvaliable(false);
//		fish.setFishProvider(fp);		
//		
//		fishItemService.save(fish);
				
		
		/* Add new staff to DB */
//		User user = new User();
//		user.setUsername("root");
//		user.setPassword("root");
//		user.setUserType("Staff");
//		
//		Staff staff = new Staff();
//		staff.setName("Ned");
//		staff.setSurname("Stark");
//		staff.setEmail("ned@stark.com");
//		staff.setTelephone("+389999847232");		
//		staff.setStaffRole("Security officer");
//		staff.setUser(user);
//		staff.setActive(true);		
//				
//		staffService.save(staff);				
		
		
//		/* Add new customer to DB */
//		User user = new User();
//		user.setUsername("johnsnow2");
//		user.setPassword("knownothing");
//		user.setUserType("Customer");
//		
//		Customer customer = new Customer();
//		customer.setName("John");
//		customer.setSurname("Snow");
//		customer.setEmail("john@snow.com");
//		customer.setTelephone("+389999385938");
//		customer.setUser(user);
//		
//		customerService.save(customer);
		
		
		
		
		
		

	}

}
