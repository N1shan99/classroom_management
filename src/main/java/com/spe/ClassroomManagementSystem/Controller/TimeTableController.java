package com.spe.ClassroomManagementSystem.Controller;

import com.spe.ClassroomManagementSystem.Models.ClassTiming;
import com.spe.ClassroomManagementSystem.Models.Day;
import com.spe.ClassroomManagementSystem.Models.Request;
import com.spe.ClassroomManagementSystem.Service.ClassTimingService;
import com.spe.ClassroomManagementSystem.Service.ClassTimingServiceImpl;
import com.spe.ClassroomManagementSystem.Service.ReturnableRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

import static com.spe.ClassroomManagementSystem.Models.RequestStatus.REQUESTED;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TimeTableController {
    private static final Logger logger = LoggerFactory.getLogger(TimeTableController.class);

    @Autowired
    private ClassTimingService classTimingService;
    
  


    @RequestMapping("/saveInClassTimings")
    public RedirectView saveInClassTimings(
            @RequestParam("classCode") String classCode,
            @RequestParam("day") String day,
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            HttpSession session){
        logger.trace("saveInClassTimings called");
        Day day1 = Day.SUNDAY;//initialization
        switch (day){
            case "SUNDAY": day1=Day.SUNDAY;break;
            case "MONDAY": day1=Day.MONDAY;break;
            case "TUESDAY": day1=Day.TUESDAY;break;
            case "WEDNESDAY": day1=Day.WEDNESDAY;break;
            case "THURSDAY": day1=Day.THURSDAY;break;
            case "FRIDAY": day1=Day.FRIDAY;break;
            case "SATURDAY": day1=Day.SATURDAY;break;
        }
        Time startTimeFormat = Time.valueOf(startTime +":00");
        Time endTimeFormat = Time.valueOf(endTime +":00");

        boolean retVal = classTimingService.saveInClassTiming(classCode, startTimeFormat, endTimeFormat, day1, session);
        //System.out.println("retVal = " + retVal);
        //System.out.println(session.getAttribute("save_messsage"));
        RedirectView rv = new RedirectView();
        rv.setUrl("AddTimetable.jsp");
//        rv.setUrl("redirect:/gettimetable");

        return rv;

    }
    
//    @RequestMapping("/gettimetable")
//	public String listTimetable(Model model) {
//		
//		model.addAttribute("timetable", classTimingService.getAllTimetable());
//		return "AddTimetable";
//		
//	}
//    
    
    
    @RequestMapping("/gettimetable")
    public RedirectView TimetableRequest(HttpSession session) {
        logger.trace("timetableRequest called");
        List<ClassTiming> timetableList = classTimingService.getAllTimetable();
//        List<ReturnableRequest> returnableRequestList = new ArrayList<>();
     
        RedirectView rv = new RedirectView();
        session.setAttribute("timetableList", timetableList);
        System.out.println(timetableList);
        rv.setUrl("/ViewTimetable.jsp");
        return rv;
    }
    
    
    
	
    
  


    
    
    


    
    
    
  
    
    
    
    
}
