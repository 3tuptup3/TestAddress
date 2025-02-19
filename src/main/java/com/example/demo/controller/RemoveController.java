package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Address;
import com.example.demo.form.AddressRemoveForm;
import com.example.demo.service.RemoveService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RemoveController {
	
	private final RemoveService service;

//	/*--- 削除画面表示リクエスト ---*/
//	@PostMapping("/show-address-remove-form")
//	public String showAddressEditForm(@ModelAttribute AddressRemoveForm form) {
//		return "remove-address";
//	}
//
//	/*--- 削除画面表示リクエスト（確認画面からの戻り） ---*/
//	@PostMapping("/show-address-remove-form-ret")
//	public String showAddressEditFormRet(@ModelAttribute AddressRemoveForm form) {
//		return "remove-address";
//	}

	/*--- 削除リクエスト（詳細画面より） ---*/
	// ！！バリデーション！！
	// 開発者ツールからの変更もエラーになる
	// @Validatedで入力内容と検証結果をaddressRegistFormモデルに格納
	@PostMapping("/remove-address")
	public String removeAddress(
			@Validated @ModelAttribute AddressRemoveForm form,
			BindingResult result) {

		// 入力エラーがある場合には 詳細画面に戻す
		if (result.hasErrors()) {
			return "address-detail";
		}
		
		// 正常な場合に 削除確認画面に 遷移する
		return "confirm-remove-address";
	}

	/*--- 削除リクエスト（削除確認画面より） ---*/
	@PostMapping("/confirm-remove-address")
	public String confirmRemoveAddress(
			@Validated AddressRemoveForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes) {

		// 入力エラーがある場合には 詳細画面に戻す
		if (result.hasErrors()) {
			return "address-detail";
		}

		Address a = new Address();
		a.setAddressId(form.getAddressId());
		service.remove(a);

		// フラッシュスコープ
		redirectAttributes.addFlashAttribute("msg", "（削除）");
		
		// HTMLテンプレート名ではなくURLパターン
		return "redirect:/complete";
	}

}
