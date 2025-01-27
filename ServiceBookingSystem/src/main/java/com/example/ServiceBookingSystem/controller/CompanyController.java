package com.example.ServiceBookingSystem.controller;

import com.example.ServiceBookingSystem.dto.AdDTO;
import com.example.ServiceBookingSystem.dto.ReservationDto;
import com.example.ServiceBookingSystem.entity.Ad;
import com.example.ServiceBookingSystem.repository.AdRepository;
import com.example.ServiceBookingSystem.services.company.CompanyService;
import com.example.ServiceBookingSystem.services.company.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private AdRepository adRepository;

    @PostMapping("/ad/{userId}")
    public ResponseEntity<?> postAd(@PathVariable Long userId, @ModelAttribute AdDTO adDTO) throws IOException {
        boolean success = companyService.postAd(userId,adDTO);
        if(success) return ResponseEntity.status(HttpStatus.OK).build();
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

//    @PostMapping("/ad/{userId}")
//    public ResponseEntity<?> postAd(@PathVariable Long userId,
//                                    @RequestParam("serviceName") String serviceName,
//                                    @RequestParam("price") Double price,
//                                    @RequestParam("description") String description,
//                                    @RequestParam("img") MultipartFile img
//                                    ) throws IOException {
//        AdDTO adDTO = new AdDTO(serviceName,price,description,img);
//        boolean success = companyService.postAd(userId,adDTO);
//        if(success) return ResponseEntity.status(HttpStatus.OK).build();
//        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }

    @PostMapping("/download/{name}")
    public String download(@PathVariable String name) {
        int a = 6;
        return "Dhoni";
    }

    @GetMapping("/ads/{userId}")
    public ResponseEntity<?> getAllAdsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(companyService.getAllAds(userId));
    }

    @GetMapping("/ad/{adId}")
    public ResponseEntity<?> getAdById(@PathVariable Long adId) {
        AdDTO adDTO = companyService.getAdById(adId);
        if(adDTO != null) {
            return ResponseEntity.ok(adDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/ad/{adId}")
    public ResponseEntity<?> updateAd(@PathVariable Long adId, @ModelAttribute AdDTO adDTO) throws IOException {
        boolean success = companyService.updateAd(adId,adDTO);
        if(success) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/ad/{adId}")
    public ResponseEntity<?> deleteAd(@PathVariable Long adId) {
        boolean success = companyService.deleteAd(adId);
        if(success) return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/bookings/{companyId}")
    public ResponseEntity<List<ReservationDto>> getAllAdBookings(@PathVariable Long companyId) {
        return ResponseEntity.ok(companyService.getAllAdBooking(companyId));
    }

    @GetMapping("/booking/{bookingId}/{status}")
    public ResponseEntity<?> changeBookingStatus(@PathVariable Long bookingId,@PathVariable String status) {
        boolean success = companyService.changeBookingStatus(bookingId,status);
        if(success) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
