package com.example.ServiceBookingSystem.services.client;

import com.example.ServiceBookingSystem.dto.AdDTO;
import com.example.ServiceBookingSystem.dto.AdDetailsForClientDTO;
import com.example.ServiceBookingSystem.dto.ReservationDto;
import com.example.ServiceBookingSystem.dto.ReviewDto;
import com.example.ServiceBookingSystem.entity.Ad;
import com.example.ServiceBookingSystem.entity.Reservation;
import com.example.ServiceBookingSystem.entity.Review;
import com.example.ServiceBookingSystem.entity.User;
import com.example.ServiceBookingSystem.enums.ReservationStatus;
import com.example.ServiceBookingSystem.enums.ReviewStatus;
import com.example.ServiceBookingSystem.repository.AdRepository;
import com.example.ServiceBookingSystem.repository.ReservationRepository;
import com.example.ServiceBookingSystem.repository.ReviewRepository;
import com.example.ServiceBookingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public List<AdDTO> getAllAds() {
        return adRepository.findAll().stream().map(Ad::getAdDTO).toList();
    }

    public List<AdDTO> searchAdByName(String name) {
        return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getAdDTO).toList();
    }

    public boolean bookService(ReservationDto reservationDto) {
        Optional<Ad> optionalAd = adRepository.findById(reservationDto.getAdId());
        Optional<User> optionalUser = userRepository.findById(reservationDto.getUserId());

        if(optionalAd.isPresent() && optionalUser.isPresent()) {
            Reservation reservation = new Reservation();

            reservation.setBookDate(reservationDto.getBookDate());
            reservation.setReservationStatus(ReservationStatus.PENDING);
            reservation.setUser(optionalUser.get());
            reservation.setAd(optionalAd.get());
            reservation.setCompany(optionalAd.get().getUser());
            reservation.setReviewStatus(ReviewStatus.FALSE);

            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }

    public AdDetailsForClientDTO getAdDetailsByAdId(Long adId) {
        Optional<Ad> optionalAd = adRepository.findById(adId);
        AdDetailsForClientDTO adDetailsForClientDTO = new AdDetailsForClientDTO();
        if(optionalAd.isPresent()) {
            adDetailsForClientDTO.setAdDTO(optionalAd.get().getAdDTO());

            List<Review> reviewList = reviewRepository.findAllByAdId(adId);
            adDetailsForClientDTO.setReviewDtoList(reviewList.stream().map(Review::getReviewDto).toList());
        }
        return adDetailsForClientDTO;
    }

    public List<ReservationDto> getAllBookingsByUserId(Long userId) {
        return reservationRepository.findAllByUserId(userId).stream().map(Reservation::getReservationDto).toList();
    }

    public Boolean giveReview(ReviewDto reviewDto) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reviewDto.getReservationId());
        if(optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            Review review = new Review();
            review.setReviewDate(new Date());
            review.setReview(reviewDto.getReview());
            review.setRating(reviewDto.getRating());
            review.setReservation(reservation);
            review.setAd(reservation.getAd());

            reviewRepository.save(review);
            reservation.setReviewStatus(ReviewStatus.TRUE);

            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }
}
