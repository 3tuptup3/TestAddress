package com.example.demo.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Address;
import com.example.demo.form.AddressDetailForm;
import com.example.demo.form.AddressSearchForm;
import com.example.demo.service.AddressListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AddressListController {
	
	private final AddressListService service;
	
	/*--- 最初のリクエスト ---*/
	@GetMapping("/top")
	private String addressList(
			@ModelAttribute AddressSearchForm form) {
		return "address-list";
	}
	
	/*--- 検索リクエスト ---*/
	@PostMapping("/address-search")
	private String addressSearch(
			@ModelAttribute AddressSearchForm form,
			Model model) {
		
//		List<Address> list = service.findByNameWildcard(form.getLastName());
		List<Address> list = service.findByNameWildcard(form);
		
		model.addAttribute("addressList", list);
		
		return "address-list";
		
	}
	
	/*--- 詳細画面表示リクエスト ---*/
	@PostMapping("/address-detail")
	private String addressDetail(
			@ModelAttribute AddressDetailForm form) {

//		List<Address> list = service.findByAddressId(form.getAddressId());
//		
//		// →address-list.html
//		// 		th:if="${addressList} == null"
//		if (list.size() > 0) {
//			model.addAttribute("addressList", list);
//		}
		return "address-detail";
	}
	
	/*--- 詳細画面表示リクエスト（編集/削除確認画面からの戻り） ---*/
	@PostMapping("/address-detail-ret")
	private String addressDetailRet(
			@ModelAttribute AddressDetailForm form) {

//		List<Address> list = service.findByAddressId(form.getAddressId());
//		
//		// →address-list.html
//		// 		th:if="${addressList} == null"
//		if (list.size() > 0) {
//			model.addAttribute("addressList", list);
//		}
		return "address-detail";
	}

}
