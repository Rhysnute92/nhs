package uk.ac.cf.spring.nhs.Calendar.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.spring.nhs.Common.util.DeviceDetector;
import uk.ac.cf.spring.nhs.Common.util.NavMenuItem;

import java.util.List;

@Controller
public class CalendarController {
    @GetMapping("/calendar")
    public ModelAndView Calendar(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (DeviceDetector.isMobile(request)) {
            modelAndView.setViewName("calendar/mobile/calendar");
        } else {
            modelAndView.setViewName("calendar/desktop/calendar");

        }
        return modelAndView;
    }

    @GetMapping("/addappointment")
    public ModelAndView getMobileAddAppt(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        if (DeviceDetector.isMobile(request)){
            modelAndView.setViewName("calendar/mobile/addappointment");
        } else {
            modelAndView.setViewName("calendar/desktop/addappointment");
        }
        return modelAndView;
    }

    @ModelAttribute("navMenuItems")
    public List<NavMenuItem> navMenuItems() {
        return List.of(
                new NavMenuItem("Schedule", "/calendar", "fa-regular fa-calendar-days"),
                new NavMenuItem("Add Appointment", "/mobileaddappt", "fa-solid fa-calendar-check")
        );
    }

}