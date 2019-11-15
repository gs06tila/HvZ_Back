package se.experis.HvZ.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import se.experis.HvZ.domain.ConfirmationToken;
import se.experis.HvZ.domain.ConfirmationTokenRepository;
import se.experis.HvZ.domain.GameUserRepository;
import se.experis.HvZ.service.EmailSenderService;
import se.experis.HvZ.domain.GameUser;

@RestController
public class GameUserController {

    @Autowired
    private GameUserRepository gameuserRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, GameUser user)
    {
        System.out.println(user + "HEJ----------------------------->");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, GameUser user)
    {
        System.out.println(modelAndView + " HEJDÅ----------------------------->");

        GameUser existingUser = gameuserRepository.findByEmailIgnoreCase(user.getEmail());
        System.out.println(user.getEmail() + " WTF --------------------------------------------->");
        if(existingUser != null)
        {
            modelAndView.addObject("message","This email already exists!");
            modelAndView.setViewName("error");
        }
        else
        {
            gameuserRepository.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);
            System.out.println(confirmationToken.getConfirmationToken() + "->>>>>>>----token" + user.getEmail());
            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("hvzpelt@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            modelAndView.addObject("email", user.getEmail());

            modelAndView.setViewName("successfulRegisteration");
        }

        return modelAndView;
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            GameUser user = gameuserRepository.findByEmailIgnoreCase(token.getUser().getEmail());
            user.setEnabled(true);
            gameuserRepository.save(user);
            modelAndView.setViewName("accountVerified");
        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }

    public GameUserRepository getGameuserRepository() {
        return gameuserRepository;
    }

    public void setGameUserRepository(GameUserRepository gameuserRepository) {
        this.gameuserRepository = gameuserRepository;
    }

    public ConfirmationTokenRepository getConfirmationTokenRepository() {
        return confirmationTokenRepository;
    }

    public void setConfirmationTokenRepository(ConfirmationTokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    public EmailSenderService getEmailSenderService() {
        return emailSenderService;
    }

    public void setEmailSenderService(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }
}
