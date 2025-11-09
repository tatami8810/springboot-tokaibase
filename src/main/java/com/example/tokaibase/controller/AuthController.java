package com.example.tokaibase.controller;


import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.tokaibase.entity.User;
import com.example.tokaibase.form.SignupForm;
import com.example.tokaibase.service.UserService;

@Controller
public class AuthController {
    private final UserService userService;

    // SignupEventPublisher, VerificationTokenService は削除
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute @Validated SignupForm signupForm,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         HttpServletRequest httpServletRequest,
                         Model model) {

        // メールアドレスが登録済みか確認
        if (userService.isEmailRegistered(signupForm.getEmail())) {
            FieldError fieldError = new FieldError(bindingResult.getObjectName(), "email", "すでに登録済みのメールアドレスです。");
            bindingResult.addError(fieldError);
        }

        // パスワード確認
        if (!userService.isSamePassword(signupForm.getPassword(), signupForm.getPasswordConfirmation())) {
            FieldError fieldError = new FieldError(bindingResult.getObjectName(), "password", "パスワードが一致しません。");
            bindingResult.addError(fieldError);
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("signupForm", signupForm);
            return "auth/signup";
        }

        // ユーザー登録
        User createdUser = userService.createUser(signupForm);

        // 登録時にすぐ有効化
        userService.enableUser(createdUser);

        // 登録完了画面へリダイレクト
        return "redirect:/signup/complete";
    }

    // 登録完了画面
    @GetMapping("/signup/complete")
    public String signupComplete() {
        return "auth/complete";
    }
}
