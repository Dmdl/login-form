package com.lakmal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lakmal.entity.Account;
import com.lakmal.entity.User;
import com.lakmal.service.AccountService;
import com.lakmal.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	@Autowired
	private MailSender mailSender;

	@RequestMapping
	public String account(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		User user = userService.findOne(userName);
		Account account = accountService.getAccountUser(user);
		model.addAttribute("account", account);
		return "account";
	}

	@RequestMapping("/create")
	public String createAccount() {
		return "create-account";
	}

	@RequestMapping("/email")
	public String sendMail() {
		System.out.println("in mail send method ......");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("lakmal@rcapl.com");
		message.setTo("dasanayaka70@gmail.com");
		message.setSubject("Test");
		message.setText("test mail gun mail server");
		mailSender.send(message);
		return "redirect:/account.html";
	}
}
