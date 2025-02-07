package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Address;
import com.example.demo.form.AddressRegistForm;
import com.example.demo.service.RegistService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistController {
	
	private final RegistService service;

	/*--- 登録画面表示リクエスト ---*/
	@PostMapping("/show-address-form")
	public String showAddressForm(@ModelAttribute AddressRegistForm form) {
		return "regist-address";
	}

	/*--- 登録画面表示リクエスト（確認画面からの戻り） ---*/
	@PostMapping("/show-address-form-ret")
	public String showAddressFormRet(@ModelAttribute AddressRegistForm form) {
		return "regist-address";
	}

	/*--- 登録リクエスト（登録画面より） ---*/
	// ！！バリデーション！！
	// 開発者ツールからの変更もエラーになる
	// @Validatedで入力内容と検証結果をaddressRegistFormモデルに格納
	@PostMapping("/regist-address")
	public String registAddress(
			@Validated @ModelAttribute AddressRegistForm form,
			BindingResult result) {

		// 入力エラーがある場合には 登録画面に戻す
		if (result.hasErrors()) {
			return "regist-address";
		}
		
		// 正常な場合に 登録確認画面に 遷移する
		return "confirm-regist-address";
	}

	/*--- 登録リクエスト（登録確認画面より） ---*/
	@PostMapping("/confirm-regist-address")
	public String confirmRegistAddress(
			@Validated AddressRegistForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes) {

		// 入力エラーがある場合には 登録画面に戻す
		if (result.hasErrors()) {
			return "regist-address";
		}

		Address a = new Address();
		a.setLastName(form.getLastName());
		a.setFirstName(form.getFirstName());
		a.setCommonName(form.getCommonName());
		a.setTeam(form.getTeam());
		service.regist(a);

		// フラッシュスコープ
		redirectAttributes.addFlashAttribute("msg", "（登録）");
		
		// HTMLテンプレート名ではなくURLパターン
		return "redirect:/complete";
	}

}
