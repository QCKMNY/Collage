package Controller;


import DAO.PhotoDAO;
import DAO.UserDAO;
import Entity.PhotoEntity;
import Entity.UserEntity;
import IMAGE.Image;
import com.cloudinary.*;
import com.cloudinary.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;
import java.util.*;

@Controller
public class HelloController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private PhotoDAO photoDAO;

	@Autowired
	CloudinaryService cloudinaryService;
	@RequestMapping(method = RequestMethod.GET)
	public String printLoginPage( ModelMap model) throws Exception {
        List <String> endResult=new LinkedList<String>();
		List<PhotoEntity> photos= photoDAO.getPhotosByUser(userDAO.getUserByID("Jack"));
		for(PhotoEntity photo : photos) {
			endResult.add(cloudinaryService.imageHtml((String) photo.getPhotoID()));
		}
		model.addAttribute("images",endResult);
		//return "index";
		return "hello";
	}

	@RequestMapping(value="/registration",method = RequestMethod.GET)
	public String regisration(@RequestParam(defaultValue ="") String userID , @RequestParam(defaultValue ="") String password,
							  @RequestParam(defaultValue ="") String email, ModelMap model) {
		if (userID.length()!=0&&password.length()!=0&&email.length()>5) {
			userDAO.createUser(new UserEntity(userID, email, password));
			return "underConstruction";
		}
		return "registration";
	}
	@RequestMapping(value="/confirm",method = RequestMethod.GET)
	public String getEmailConfirmation(@RequestParam(defaultValue ="")String UUID, ModelMap model) {
		List<UserEntity> users=userDAO.getUsers();
		UserEntity user=userDAO.getUserByUniqueEmailCode(UUID);
		if (user!=null) {
				user.setConfirmation(true);
				userDAO.updateUser(user);
				return "underConstruction";
		}
		model.addAttribute("error", "Email doesn't pass validation.");
		return "login";
	}

	@RequestMapping(value="/loading", method = RequestMethod.GET)
	public String logIn(@RequestParam String userID, @RequestParam String password, ModelMap model){
		UserEntity user=userDAO.getUserByID(userID);
		if (user.isConfirmation()) {
			if (BCrypt.checkpw(password, user.getPasswordHash())) {
				model.addAttribute("error", "true");
				return "underConstruction";
			} else {
				model.addAttribute("errorText", "You enter wrong UserID or Password. Please try again.");
			}
		}
		else {
			model.addAttribute("errorText", "Your email doesn't pass validation. Please check you'r email.");
		}
		model.addAttribute("error", "false");
		return "login";
	}
}