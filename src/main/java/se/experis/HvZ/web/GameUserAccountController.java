package se.experis.HvZ.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import se.experis.HvZ.domain.AccountCredentials;
import se.experis.HvZ.domain.ConfirmationToken;
import se.experis.HvZ.domain.ConfirmationTokenRepository;
import se.experis.HvZ.domain.GameUser;
import se.experis.HvZ.domain.GameUserRepository;
import se.experis.HvZ.service.EmailSenderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GameUserAccountController {

}
