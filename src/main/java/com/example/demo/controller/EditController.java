package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Address;
import com.example.demo.form.AddressEditForm;
import com.example.demo.service.EditService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EditController {
	
	private final EditService service;

	/*--- 編集画面表示リクエスト ---*/
	@PostMapping("/show-address-edit-form")
	public String showAddressEditForm(@ModelAttribute AddressEditForm form) {
		return "edit-address";
	}

	/*--- 編集画面表示リクエスト（確認画面からの戻り） ---*/
	@PostMapping("/show-address-edit-form-ret")
	public String showAddressEditFormRet(@ModelAttribute AddressEditForm form) {
		return "edit-address";
	}

	/*--- 更新リクエスト（登録画面より） ---*/
	// ！！バリデーション！！
	// 開発者ツールからの変更もエラーになる
	// @Validatedで入力内容と検証結果をaddressRegistFormモデルに格納
	@PostMapping("/edit-address")
	public String editAddress(
			@Validated @ModelAttribute AddressEditForm form,
			BindingResult result) {

		// 入力エラーがある場合には 編集画面に戻す
		if (result.hasErrors()) {
			return "edit-address";
		}
		
		// 正常な場合に 更新確認画面に 遷移する
		return "confirm-edit-address";
	}

	/*--- 更新リクエスト（更新確認画面より） ---*/
	@PostMapping("/confirm-edit-address")
	public String confirmEditAddress(
			@Validated AddressEditForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes) {

		// 入力エラーがある場合には 編集画面に戻す
		if (result.hasErrors()) {
			return "edit-address";
		}
		System.out.println(form.getAddressId());

		Address a = new Address();
		a.setAddressId(form.getAddressId());
		a.setLastName(form.getLastName());
		a.setFirstName(form.getFirstName());
		a.setCommonName(form.getCommonName());
		a.setTeam(form.getTeam());
		service.edit(a);

		// フラッシュスコープ
		redirectAttributes.addFlashAttribute("msg", "（更新）");
		
		// HTMLテンプレート名ではなくURLパターン
		return "redirect:/complete";
	}

}
