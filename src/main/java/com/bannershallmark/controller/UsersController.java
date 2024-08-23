package com.bannershallmark.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bannershallmark.bean.DateTime;
import com.bannershallmark.bean.RandomString;
import com.bannershallmark.bean.SendMail;
import com.bannershallmark.config.MultipleWebSecurityConfig.WebSecurityConfig;
import com.bannershallmark.dao.UsersDao;
import com.bannershallmark.entity.ForgotPassword;
import com.bannershallmark.entity.Role;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.ForgotPasswordService;
import com.bannershallmark.service.UsersDetailsService;
import com.bannershallmark.util.AccessPermissionUtil;
import com.bannershallmark.util.Constants;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Value("${fromEmail}")
	private String fromEmail;
	@Value("${frompassword}")
	private String frompassword;
	@Value("${smtp}")
	private String smtp;
	@Value("${port}")
	private String port;
	@Value("${status}")
	private String status;

	@Autowired
	private UsersDetailsService usersDetailsService;

	@Autowired
	AccessPermissionUtil accessPermissionUtil;

	@Autowired
	UsersDao usersDao;
	@Autowired
	ForgotPasswordService forgotPasswordService;

	@Autowired
	HttpServletRequest request;

	private static Logger testNGlogger = Logger.getLogger(UsersController.class);

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	WebSecurityConfig webSecurityConfig;


	@GetMapping("/usersData")
	public String Paybys(Model model, RedirectAttributes redirectAttributes) throws Exception {

		try {
			boolean accessStatus = accessPermissionUtil.isAccessPermission("users/usersData");
			if (accessStatus) {
				try {

					List<Users> users = usersDetailsService.findAll();
					model.addAttribute("users", users);
				} catch (Exception e) {
					testNGlogger.info("users/usersData" + ",ERROR MESSAGES : " + e.getMessage());
					return "errorpage/error";
				}
				return "users/usersData";
			} else {
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE,
						Constants.Messages.PERMISSION_DENIED);
				return "redirect:" + "/";
			}
		} catch (Exception e) {
			testNGlogger.info("users/usersData" + ",ERROR MESSAGES : " + e.getMessage());
			return "errorpage/error";
		}

	}

	@GetMapping("/addUsers")
	public String addPayby(Model model, RedirectAttributes redirectAttributes) throws Exception {

		boolean accessStatus = accessPermissionUtil.isAccessPermission("users/addUsers");
		if (accessStatus) {
			try {
				Users users = new Users();
				model.addAttribute("users", users);
				List<Role> role = usersDetailsService.findAllRole();
				model.addAttribute("role", role);
			} catch (Exception e) {

				testNGlogger.info("users/usersData" + ",ERROR MESSAGES : " + e.getMessage());

				return "errorpage/error";
			}
			return "users/addUsers";
		} else {
			redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE,
					Constants.Messages.PERMISSION_DENIED);
			return "redirect:" + "/";
		}
	}

	@PostMapping("/addNewUsers")
	public String addNewPayby(@ModelAttribute Users users, RedirectAttributes redirectAttributes) throws Exception {

		boolean accessStatus = accessPermissionUtil.isAccessPermission("users/addNewUsers");
		if (accessStatus) {
			try {

				// Users user = usersDetailsService.getUserByUsername(users.getUsername());
				// System.out.println("============"+user);

				// if(user.getUsername().equals(users.getUsername()) ||
				// user.getEmail().equals(users.getEmail()))

				if (usersDetailsService.getUserByUsername(users.getUsername()) != null)

				{

					redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE, "Username  already exists");
					return "redirect:/users/usersData";
				} else {

					BCryptPasswordEncoder encryptPwd = webSecurityConfig.passwordEncoder();
					// System.out.println("================="+users.getPassword());

					
					users.setPassword(encryptPwd.encode(users.getPassword()));
					usersDetailsService.save(users);
					redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE,
							"New user successfully added");
					return "redirect:/users/usersData";
				}

			} catch (Exception e) {

				testNGlogger.info("payby/addNewPayby" + ",ERROR MESSAGES : " + e.getMessage());
				// testNGlogger.error(e.getMessage());

				return "errorpage/error";
			}
		} else {
			redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE,
					Constants.Messages.PERMISSION_DENIED);
			return "redirect:" + "/";
		}

	}

	@GetMapping("/getUsers")
	public String getPayby(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes)
			throws Exception {

		try {
			boolean accessStatus = accessPermissionUtil.isAccessPermission("users/getUsers");
			if (accessStatus) {
				try {
					String id = request.getParameter("id");
					if (!id.equals("")) {
						Users users = usersDetailsService.findById(Integer.parseInt(id));
						model.addAttribute("users", users);
						List<Role> role = usersDetailsService.findAllRole();
						model.addAttribute("role", role);
					} else {
						return "redirect:" + "/";
					}

				} catch (Exception e) {
					testNGlogger.info("users/getUses" + ",ERROR MESSAGES : " + e.getMessage());
					return "redirect:" + "/";
				}
				return "users/editUsers";

			} else {
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE,
						Constants.Messages.PERMISSION_DENIED);
				return "redirect:" + "/";
			}
		} catch (Exception e) {
			testNGlogger.info("users/getUses" + ",ERROR MESSAGES : " + e.getMessage());
			return "errorpage/error";
		}

	}

	@PostMapping("/updateUsers")
	public String updatePayby(@ModelAttribute Users users, RedirectAttributes redirectAttributes) throws Exception {

		boolean accessStatus = accessPermissionUtil.isAccessPermission("users/updateUsers");
		if (accessStatus) {
			try {
				usersDetailsService.save(users);
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE,
						"Users info updated successfully.");
				return "redirect:/users/usersData";

			} catch (Exception e) {

				testNGlogger.info("users/updatePayby" + ",ERROR MESSAGES : " + e.getMessage());
				// testNGlogger.error(e.getMessage());
				return "errorpage/error";
			}

		} else {
			redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE,
					Constants.Messages.PERMISSION_DENIED);
			return "redirect:" + "/";
		}

	}

	@GetMapping("/deleteUsers/{id}")
	public String deletePayby(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) throws Exception {

		boolean accessStatus = accessPermissionUtil.isAccessPermission("users/deleteUsers");
		if (accessStatus) {
			try {
				usersDetailsService.deleteById(id);
			} catch (Exception e) {
				testNGlogger.info("users/deleteUsers" + ",ERROR MESSAGES : " + e.getMessage());
				return "errorpage/error";
			}
			return "redirect:/users/usersData";
		} else {
			redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE,
					Constants.Messages.PERMISSION_DENIED);
			return "redirect:" + "/";
		}

	}

	@GetMapping("/changepassword")
	public String Changepass(Model model, RedirectAttributes redirectAttributes) throws Exception {
		try {
			boolean accessStatus = accessPermissionUtil.isAccessPermission("users/changepassword");
			if (accessStatus) {
				try {
					Users users = new Users();
					model.addAttribute("users", users);
				} catch (Exception e) {
					testNGlogger.info("users/changepassword" + ",ERROR MESSAGES : " + e.getMessage());
					return "errorpage/error";
				}
				return "users/changepass";

			} else {
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE,
						Constants.Messages.PERMISSION_DENIED);
				return "redirect:" + "/";
			}
		} catch (Exception e) {
			testNGlogger.info("users/changepassword" + ",ERROR MESSAGES : " + e.getMessage());
			return "/";
		}

	}

	@PostMapping("/updatepassword")
	public String UpadatePassword(@ModelAttribute Users users, Model model, RedirectAttributes redirectAttributes)
			throws Exception {

		try {
			boolean accessStatus = accessPermissionUtil.isAccessPermission("users/updatepassword");
			if (accessStatus) {
				try {
					Users byIddata = usersDetailsService.findById(users.getId());
					if (byIddata.getUsername().equals(users.getUsername()) && byIddata.getId() == users.getId()) {
						BCryptPasswordEncoder encryptPwd = webSecurityConfig.passwordEncoder();
						// System.out.println("================="+users.getPassword());
						byIddata.setPassword(encryptPwd.encode(users.getPassword()));
						usersDetailsService.save(byIddata);
						redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE,
								"Password changed successfully.");
						return "redirect:" + "/";
					} else {
						redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE, "Invalid password.");
						return "redirect:" + "/";
					}

				} catch (Exception e) {
					testNGlogger.info("users/updatepassword" + ",ERROR MESSAGES : " + e.getMessage());
					return "errorpage/error";
				}
			} else {
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE,
						Constants.Messages.PERMISSION_DENIED);
				return "redirect:" + "/";
			}

		} catch (Exception e) {
			testNGlogger.info("users/updatepassword" + ",ERROR MESSAGES : " + e.getMessage());
			return "/";
		}

	}

	//////////////////// from login page for forgot password/////////////////

	@GetMapping("/reset/forgot")
	public String forgotpage(Model model, RedirectAttributes redirectAttributes) {

		return "forgotpage";
	}

	@GetMapping("/reset/forgotpassword/{userName}")
	public String Forgotpassword(@PathVariable("userName") String userName, Model model,
			RedirectAttributes redirectAttributes) throws Exception {

		try {

			Users byIddata = usersDao.getUserByUsername(userName);
			if (byIddata != null) {
				System.out.println("=======================" + byIddata.getEmail());
				System.out.println("=======================" + byIddata.getPassword());
				RandomString randomString = new RandomString();

				String randomId = randomString.getRandomId();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Date date = new Date();
				System.out.println(formatter.format(date));

				ForgotPassword forgotPassword = new ForgotPassword();
				forgotPassword.setUserId(userName);
				forgotPassword.setRandomId(randomId);
				forgotPassword.setDataAndTime(formatter.format(date));
				forgotPasswordService.save(forgotPassword);

				// SendMail.sendMail(fromEmail,frompassword ,byIddata.getEmail(),randomId,smtp,
				// port, status) ;

				SendMail SendMail = new SendMail();

				SendMail.sendMail(fromEmail, frompassword, byIddata.getEmail(), randomId, smtp, port, status);

				// SendMail.sendMail(byIddata.getEmail(), randomId);
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE,
						"Please check your email and click the link to reset password.");
				return "redirect:/login";
			} else {

				/*
				 * System.out.println("==============error");
				 * redirectAttributes.addFlashAttribute("msg", "Invalid Username."); return
				 * "redirect:/login" ;
				 */

				System.out.println("==============error");
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE, "Invalid Username.");
				// System.out.println(" 1 :: " + request.getHeader("referer"));
				// System.out.println(" 2 :: " + request.getRequestURI());
				// return "redirect:"+ request.getHeader("referer");
				if (request.getHeader("referer").indexOf("/users/reset/forgot") >= 0) {
					return "redirect:" + request.getHeader("referer");
				} else {
					return "redirect:" + request.getHeader("referer") + "Bannershallmark/users/reset/forgot";
				}

			}

		} catch (Exception e) {
			testNGlogger.info("users/reset/forgotpassword/" + ",ERROR MESSAGES : " + e.getMessage());
			return "redirect:/login";
		}
	}

	@GetMapping("/reset/resetPassword/{randomId}")
	public String ChangetPassword(@PathVariable("randomId") String randomId, Model model,
			RedirectAttributes redirectAttributes) {

		try {
			ForgotPassword forgotPassword = forgotPasswordService.getByRandomId(randomId);
			System.out.println("=========forgotPassword======" + forgotPassword);
			Users users = new Users();
			model.addAttribute("users", users);
			model.addAttribute("randomId", randomId);
			return "changepass";
		} catch (Exception e) {
			testNGlogger.info("users/reset/resetPassword/" + ",ERROR MESSAGES : " + e.getMessage());
			return "redirect:/login";
		}
	}

	@PostMapping("/reset/newResetPassword/{randomId}")
	public String newChangetPassword(@ModelAttribute Users users, @PathVariable("randomId") String randomId,
			Model model, RedirectAttributes redirectAttributes) {

		try {

			ForgotPassword forgotPassword = forgotPasswordService.getByRandomId(randomId);

			forgotPassword.getDataAndTime();

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date curretdate = new Date();

			DateTime dateTime = new DateTime();

			long minutes = dateTime.findDifference(forgotPassword.getDataAndTime(), formatter.format(curretdate));

			System.out.println("=============minutes ===========" + minutes);

			if (minutes <= 15) {
				Users byuserId = usersDao.getUserByUsername(forgotPassword.getUserId());
				Users byIddata = usersDetailsService.findById(byuserId.getId());

				if (byIddata.getUsername().equals(forgotPassword.getUserId()) && byIddata.getId() == byuserId.getId()) {
					BCryptPasswordEncoder encryptPwd = webSecurityConfig.passwordEncoder();
					// System.out.println("================="+users.getPassword());
					byIddata.setPassword(encryptPwd.encode(users.getPassword()));
					usersDetailsService.save(byIddata);
					forgotPasswordService.deleteById(forgotPassword.getId());
					redirectAttributes.addFlashAttribute(Constants.AttributeNames.SUCCESS_MESSAGE,
							"Password changed successfully.");
					return "redirect:/login";
				} else {
					redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE, "Invalid password.");
					return "redirect:/login";
				}
			} else {
				redirectAttributes.addFlashAttribute(Constants.AttributeNames.MESSAGE, "Session timed out.");
				return "redirect:/login";
			}
		} catch (Exception e) {
			testNGlogger.info("users/reset/newResetPassword" + ",ERROR MESSAGES : " + e.getMessage());
			return "redirect:/login";
		}

	}

}
