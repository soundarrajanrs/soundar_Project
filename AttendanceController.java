package com.example.demoProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoProject.Model.ResponseData;
import com.example.demoProject.Model.SchoolHolidays;
import com.example.demoProject.Model.dto.AttendanceMultipleStudnetsSameDayDTO;
import com.example.demoProject.Model.dto.DailyAttendanceRegistrationDTO;
import com.example.demoProject.service.AttendanceService;
import com.example.demoProject.service.SchedulerService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
	AttendanceService service;
	
	@PostMapping("/declareholiday")
	public ResponseEntity<ResponseData> declareHoliday(@RequestBody SchoolHolidays holiday) {
		System.out.println("Declare holiday controller start.");
		ResponseData responseData = service.declareHoliday(holiday,false);
		System.out.println("Declare holiday controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@PostMapping("/declaremultipledayholiday")
	public ResponseEntity<ResponseData> declareMultipleDayHoliday(@RequestBody List<SchoolHolidays> holidays){
		System.out.println("Declare multiple day holiday controller start.");
		ResponseData responseData = service.declareMultipleDayHoliday(holidays,false);
		System.out.println("Declare multiple day holiday controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@PostMapping("/declare_all_sunday_as_holiday_by_year")
	public ResponseEntity<ResponseData> declareAllSundayHolidayByYear(@RequestParam String year){
		System.out.println("Declare all sunday as holiday by year controller start.");
		ResponseData responseData = service.declareAllSundayHolidayByYear(year);
		System.out.println("Declare all sunday as holiday by year controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	
	@PostMapping("/cancel_holiday")
	public ResponseEntity<ResponseData> cancelHoliday(@RequestBody SchoolHolidays holiday){
		System.out.println("Cancel holiday controller start.");
		ResponseData responseData = service.cancelHoliday(holiday);
		System.out.println("Cancel holiday controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@PostMapping("/cancel_multiple_holiday")
	public ResponseEntity<ResponseData> cancelmultipleHoliday(@RequestBody List<SchoolHolidays> holidays){
		System.out.println("Cancel multiple holiday controller start.");
		ResponseData responseData = service.cancelMultipleHoliday(holidays);
		System.out.println("Cancel multiple holiday controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@GetMapping("/list_holidays")
	public ResponseEntity<ResponseData> getAllHolidays(@RequestParam String monthYear){
		System.out.println("Get all holidays controller start.");
		ResponseData responseData = service.getAllHolidays(monthYear,false);
		System.out.println("Get all holidays controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@GetMapping("/list_cancelled_holidays")
	public ResponseEntity<ResponseData> getAllCancelledHolidays(@RequestParam String monthYear){
		System.out.println("Get all cancelled holidays controller start.");
		ResponseData responseData = service.getAllHolidays(monthYear,true);
		System.out.println("Get all cancelled holidays controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@PostMapping("/take_attendance_single_student")
	public ResponseEntity<ResponseData> takeAttendenceSingleStudent(@RequestBody DailyAttendanceRegistrationDTO  dailyAttendance){
		System.out.println("Take attendance single student controller start.");
		ResponseData responseData = service.takeAttendenceSingleStudent(dailyAttendance,true,true);
		System.out.println("Take attendance single student controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@PostMapping("/take_attendance_multiple_student_different_date")
	public ResponseEntity<ResponseData> takeAttenddanceMultipleStudentsDifferentDates(@RequestBody List<DailyAttendanceRegistrationDTO>  dailyAttendances){
		System.out.println("Take attendance multiple student diffrent dates controller start.");
		ResponseData responseData = service.takeAttenddanceMultipleStudentsDifferentDates(dailyAttendances,true,true);
		System.out.println("Take attendance multiple student diffrent dates controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@PostMapping("/take_attendance_multiple_student_same_date")
	public ResponseEntity<ResponseData> takeAttendanceMultipleStudentSameDate(@RequestBody AttendanceMultipleStudnetsSameDayDTO attendanceDetail){
		System.out.println("Take attendance multiple student same date controller start.");
		ResponseData responseData = service.takeAttendanceMultipleStudentSameDate(attendanceDetail);
		System.out.println("Take attendance multiple student same date controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@GetMapping("/list_students_not_takken_attendance")
	public ResponseEntity<ResponseData> listStudentsNotTakkenAttendance(@RequestParam String date) {
		System.out.println("List students not takken attendance controller start.");
		ResponseData responseData = service.listStudentsNotTakkenAttendance(date);
		System.out.println("List students not takken attendance controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@GetMapping("/list_students_not_takken_attendance_today")
	public ResponseEntity<ResponseData> listStudentsNotTakkenAttendanceToday(){
		System.out.println("List Students Not Takken Attendance Today controller start.");
		ResponseData responseData = service.listStudentsNotTakkenAttendanceToday();
		System.out.println("List Students Not Takken Attendance Today controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@GetMapping("/list_students_registered_attendance")
	public ResponseEntity<ResponseData> listStudentsRegisteredAttendance(@RequestParam String date){
		System.out.println("List students registered attendance controller start.");
		ResponseData responseData = service.listStudentsRegisteredAttendance(date);
		System.out.println("List students registered attendance controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	@GetMapping("/list_students_registered_attendance_today")
	public ResponseEntity<ResponseData> listStudentsRegisteredAttendanceToday(){
		System.out.println("List Students Registered Attendance Today controller start.");
		ResponseData responseData = service.listStudentsRegisteredAttendanceToday();
		System.out.println("List Students Registered Attendance Today controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
	
//	list of students by month exceeding more than three days of extra curricular activities
	@GetMapping("/list_students_exceeding_extra_curricular_limit_by_month")
	public ResponseEntity<ResponseData> listStudentsExceedingExtraCurricularLimit(@RequestParam String monthYear){
		System.out.println("List Students Exceeding Extra Curricular Limit controller start.");
		ResponseData responseData = service.listStudentsExceedingExtraCurricularLimit(monthYear);
		System.out.println("List Students Exceeding Extra Curricular Limit controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);
	}
	
//  list of students by month exceeding more than six days of sick leave
	@GetMapping("/list_students_exceeding_sick_leave_limit_by_month")
	public ResponseEntity<ResponseData> listStudentsExceedingSickLeaveLimitByMonth(@RequestParam String monthYear){
		System.out.println("List students exceeding sick leave limit by month controller start.");
		ResponseData responseData = service.listStudentsExceedingSickLeaveLimitByMonth(monthYear);
		System.out.println("List students exceeding sick leave limit by month controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);		
	}
	
// list of students by month absent for more than 50% of the school working days
	@GetMapping("/list_students_absent_more_than_fifty_percent_by_month")
	public ResponseEntity<ResponseData> listStudentsAbsentMoreThanFiftyPercentByMonth(@RequestParam String monthYear){
		System.out.println("List students absent more than fifty percent by month controller start.");
		ResponseData responseData = service.listStudentsAbsentMoreThanFiftyPercentByMonth(monthYear);
		System.out.println("List students absent more than fifty percent by month controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);		
	}
	
	@GetMapping("/list_students_not_compliance_quater_year")
	public ResponseEntity<ResponseData> listStudentsNotComplianceYearQuarter(@RequestParam String quarterYear){
		System.out.println("list students not compliance year quarter controller start.");
		ResponseData responseData = service.listStudentsNotComplianceYearQuarter(quarterYear);
		System.out.println("list students not compliance year quarter controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);		
	}
	
	@GetMapping("/list_students_compliance_quater_year")
	public ResponseEntity<ResponseData> listStudentsComplianceQuaterYear(@RequestParam String quarterYear){
		System.out.println("list students compliance year quarter controller start.");
		ResponseData responseData = service.listStudentsComplianceYearQuarter(quarterYear);
		System.out.println("list students compliance year quarter controller end.");
		return ResponseEntity.status(responseData.getStatus()).body(responseData);		
	}
	
	
	@Autowired
	SchedulerService scheduler;
	
	//cron
	@GetMapping("/cron_make_quaterly_attendance_report")
	public String cronJob() {
		System.out.println("cron controller start.");
		scheduler.makeQuarterlyAttendanceReport();
		System.out.println("cron controller stop.");
		return "success";
	}
	
	
	
	
}
