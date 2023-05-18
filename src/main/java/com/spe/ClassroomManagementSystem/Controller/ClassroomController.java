package com.spe.ClassroomManagementSystem.Controller;

import com.spe.ClassroomManagementSystem.Models.ClassTiming;
import com.spe.ClassroomManagementSystem.Models.Classroom;
import com.spe.ClassroomManagementSystem.Models.Day;
import com.spe.ClassroomManagementSystem.Models.Internship;
import com.spe.ClassroomManagementSystem.Service.ClassroomService;
import com.spe.ClassroomManagementSystem.Utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

import java.io.File;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClassroomController {
    private static final Logger logger = LoggerFactory.getLogger(ClassroomController.class);

    @Autowired
    private ClassroomService classroomService;
    
    
  

    @RequestMapping("/classroom")
    public RedirectView addClassroom(@RequestParam("classCode") String classCode,
                                      @RequestParam("capacity") int capacity,
                                      @RequestParam("plugs") int plugs,
                                      @RequestParam(value = "projector", required = false) String projector,
                                      HttpSession session) {
        logger.trace("addClassroom called");
        boolean projectorAvailable = (projector == null) ? false : true;
        Classroom cr = new Classroom(classCode, capacity, projectorAvailable, plugs);
        String class_save_msg = classroomService.saveClassroom(cr);
        session.setAttribute("class_save_msg", class_save_msg);
        RedirectView rv = new RedirectView();
        rv.setUrl("/AddClassroom.jsp");
        return rv;
    }
    
    
    
    
    
    @RequestMapping("/internship")
    public RedirectView internship(@RequestParam("internname") String internname,
                                      @RequestParam("collegename") String collegename,
                                      @RequestParam("duration") Long duration,
                                      @RequestParam("noc") File noc,
                                      @RequestParam("resume") File resume,
                                      @RequestParam("professorEmail") String professorEmail,
                                      @RequestParam("mob") Long mob
                                      ) {
        logger.trace("addinternship called");
        
        Internship intern = new Internship(internname, collegename, duration, noc ,resume ,mob ,professorEmail);
        classroomService.saveInternship(intern);
       
        RedirectView rv = new RedirectView();
        rv.setUrl("index.html");
        return rv;
    }
    
    
    
    
    
    
    
    
    

    @RequestMapping("/getAllClassrooms")
    public RedirectView getAllClassrooms(HttpSession session){
        logger.trace("getAllClassroom called");
        List<Classroom> classroomList= classroomService.findAllClassrooms();
        session.setAttribute("classroomList", classroomList);
        RedirectView rv = new RedirectView();
        rv.setUrl("/AddTimetable.jsp");
        return rv;
    }

//
//    @RequestMapping("/getAvailableClasses")
//    public RedirectView getAvailableClasses(
//            @RequestParam("purpose") String purpose,
//            @RequestParam("capacity") long capacity,
//            @RequestParam("startTime")String startTime,
//            @RequestParam("endTime") String endTime,
////            @RequestParam("datepicker") Date date,
//            
//            
//            @RequestParam("startDate") Date startDate,
//            @RequestParam("endDate") Date endDate,
//            
//            @RequestParam("plugs") long plugs,
//            @RequestParam(value = "projectorCheck", defaultValue = "false") boolean projectorNeeded,
//            @RequestParam(value = "cleanCheck", defaultValue = "false") boolean cleaningNeeded,
//            HttpSession session
//    ){
//        logger.trace("getAvailableClasses called");
//        Time startTimeFormat = Time.valueOf(startTime +":00");
//        Time endTimeFormat = Time.valueOf(endTime +":00");
//        
//        
//        
//       List<Classroom> finalClassroomList = new ArrayList<>();
//
//    	
//
//        for (Date date = startDate; date.compareTo(endDate) <= 0; ) {
//            Day day = Day.SUNDAY; //random initialization
//            switch (DateUtils.getDayOfTheWeekFromDate(date)) {
//                case 1:
//                    day = Day.SUNDAY;
//                    break;
//                case 2:
//                    day = Day.MONDAY;
//                    break;
//                case 3:
//                    day = Day.TUESDAY;
//                    break;
//                case 4:
//                    day = Day.WEDNESDAY;
//                    break;
//                case 5:
//                    day = Day.THURSDAY;
//                    break;
//                case 6:
//                    day = Day.FRIDAY;
//                    break;
//                case 7:
//                    day = Day.SATURDAY;
//                    break;
//            }
//            if (purpose.equals("exams")) {
//                capacity = capacity * 2;
//            }
//            finalClassroomList.addAll(classroomService.getAvailableClassrooms(capacity, plugs, projectorNeeded, startTimeFormat, endTimeFormat, day, date));
//
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(date);
//            cal.add(Calendar.DATE, 1);
//            date = new java.sql.Date(cal.getTimeInMillis());
//        }
//  
//        
//        
//        session.removeAttribute("availableClassrooms");
//        session.setAttribute("availableClassrooms", finalClassroomList);
//
//        session.setAttribute("purpose", purpose);
//        session.setAttribute("reqStartTime", startTimeFormat);
//        session.setAttribute("reqEndTime", endTimeFormat);
//        session.setAttribute("cleaningNeeded", cleaningNeeded);
//        session.setAttribute("projectorNeeded", projectorNeeded);
//        session.setAttribute("reqPlugs", plugs);
//        session.setAttribute("reqDate", startDate);
//        session.setAttribute("reqCapacity", capacity);
//
//        RedirectView rv = new RedirectView();
//        rv.setUrl("/AvailableClassrooms.jsp");
//        return rv;
//    }
    
    
    
    

    @RequestMapping("/getAvailableClasses")
    public RedirectView getAvailableClasses(
            @RequestParam("purpose") String purpose,
            @RequestParam("capacity") long capacity,
            @RequestParam("startTime")String startTime,
            @RequestParam("endTime") String endTime,
//            @RequestParam("datepicker") Date date,

            @RequestParam("startDate") Date startDate,
            @RequestParam("endDate") Date endDate,
            @RequestParam("plugs") long plugs,
            @RequestParam(value = "projectorCheck", defaultValue = "false") boolean projectorNeeded,
            @RequestParam(value = "cleanCheck", defaultValue = "false") boolean cleaningNeeded,
            HttpSession session
    ){
        logger.trace("getAvailableClasses called");
        Time startTimeFormat = Time.valueOf(startTime +":00");
        Time endTimeFormat = Time.valueOf(endTime +":00");
//        Day day = Day.SUNDAY; //random initialization
//        switch (DateUtils.getDayOfTheWeekFromDate(date)) {
//            case 1:  day = Day.SUNDAY; break;
//            case 2:  day = Day.MONDAY; break;
//            case 3:  day = Day.TUESDAY; break;
//            case 4:  day = Day.WEDNESDAY; break;
//            case 5:  day = Day.THURSDAY; break;
//            case 6:  day = Day.FRIDAY; break;
//            case 7:  day = Day.SATURDAY; break;
//        }
//        List<Classroom> finalClassroomList;
//        if (purpose.equals("exams")) {
//            capacity = capacity * 2;
//        }
//        finalClassroomList = classroomService.getAvailableClassrooms(capacity, plugs, projectorNeeded, startTimeFormat, endTimeFormat, day,date);

        
    	
        Map<Date,List<Classroom>> finalClassroomList = new LinkedHashMap<>();

    	

        for (Date date = startDate; date.compareTo(endDate) <= 0; ) {
            Day day = Day.SUNDAY; //random initialization
            switch (DateUtils.getDayOfTheWeekFromDate(date)) {
                case 1:
                    day = Day.SUNDAY;
                    break;
                case 2:
                    day = Day.MONDAY;
                    break;
                case 3:
                    day = Day.TUESDAY;
                    break;
                case 4:
                    day = Day.WEDNESDAY;
                    break;
                case 5:
                    day = Day.THURSDAY;
                    break;
                case 6:
                    day = Day.FRIDAY;
                    break;
                case 7:
                    day = Day.SATURDAY;
                    break;
            }
            if (purpose.equals("exams")) {
                capacity = capacity * 2;
            }
            finalClassroomList.put(date,classroomService.getAvailableClassrooms(capacity, plugs, projectorNeeded, startTimeFormat, endTimeFormat, day, date));

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, 1);
            date = new java.sql.Date(cal.getTimeInMillis());
        }

    	
    	
    	
        
        
        
//        session.removeAttribute("availableClassrooms");
//        session.setAttribute("availableClassrooms", finalClassroomList);
//
//        session.setAttribute("purpose", purpose);
//        session.setAttribute("reqStartTime", startTimeFormat);
//        session.setAttribute("reqEndTime", endTimeFormat);
//        session.setAttribute("cleaningNeeded", cleaningNeeded);
//        session.setAttribute("projectorNeeded", projectorNeeded);
//        session.setAttribute("reqPlugs", plugs);
////        System.out.println(startDate);
//        session.setAttribute("reqDate", startDate);
//        session.setAttribute("endDate", endDate);
//        session.setAttribute("reqCapacity", capacity);
        
        
        session.removeAttribute("availableClassrooms");
        session.setAttribute("availableClassrooms", finalClassroomList);

        session.setAttribute("purpose", purpose);
        session.setAttribute("startTimeFormat", startTimeFormat);
        session.setAttribute("endTimeFormat", endTimeFormat);
        session.setAttribute("cleaningNeeded", cleaningNeeded);
        session.setAttribute("projectorNeeded", projectorNeeded);
        session.setAttribute("plugs", plugs);
        session.setAttribute("startDate", startDate);
        session.setAttribute("endDate", endDate);
        session.setAttribute("capacity", capacity);
        
        

        RedirectView rv = new RedirectView();
        rv.setUrl("/AvailableClassrooms.jsp");
        return rv;
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Redirrction to available classroom page
    
    
    @RequestMapping("/redirectAvailableClasses")
    public RedirectView redirectAvailableClasses(
            HttpSession session
    ){
        logger.trace("getAvailableClasses called");
        Time startTimeFormat = (Time) session.getAttribute("startTimeFormat");
        Time endTimeFormat = (Time) session.getAttribute("endTimeFormat") ;
        
    	
        Map<Date,List<Classroom>> finalClassroomList = new LinkedHashMap<>();

    	

        for (Date date = (Date) session.getAttribute("startDate"); date.compareTo((java.util.Date) session.getAttribute("endDate")) <= 0; ) {
            Day day = Day.SUNDAY; //random initialization
            switch (DateUtils.getDayOfTheWeekFromDate(date)) {
                case 1:
                    day = Day.SUNDAY;
                    break;
                case 2:
                    day = Day.MONDAY;
                    break;
                case 3:
                    day = Day.TUESDAY;
                    break;
                case 4:
                    day = Day.WEDNESDAY;
                    break;
                case 5:
                    day = Day.THURSDAY;
                    break;
                case 6:
                    day = Day.FRIDAY;
                    break;
                case 7:
                    day = Day.SATURDAY;
                    break;
            }
            Long capacity = (Long) session.getAttribute("capacity");
            if (session.getAttribute("purpose").equals("exams")) {
                capacity = capacity * 2;
            }
            finalClassroomList.put(date,classroomService.getAvailableClassrooms(capacity, (Long) session.getAttribute("plugs"), (Boolean) session.getAttribute("projectorNeeded"), startTimeFormat, endTimeFormat, day, date));

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, 1);
            date = new java.sql.Date(cal.getTimeInMillis());
        }
        
        
        RedirectView rv = new RedirectView();
        rv.setUrl("/AvailableClassrooms.jsp");
        rv.addStaticAttribute("refreshTime", 5); // add refresh time as a model attribute
        return rv;
        
        
        
    }
    
    
    
    
    
    @RequestMapping("/getInternship")
    public RedirectView InternshipRequest(HttpSession session) {
        logger.trace("internshipRequest called");
        List<Internship> internshipList = classroomService.getAllInternship();
//        List<ReturnableRequest> returnableRequestList = new ArrayList<>();
     
        RedirectView rv = new RedirectView();
        session.setAttribute("internshipList", internshipList);
        System.out.println(internshipList);
        rv.setUrl("/InternshipRequests.jsp");
        return rv;
    }
    
    
    
    
    
    
    
}