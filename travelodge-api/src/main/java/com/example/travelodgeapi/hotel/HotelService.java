package com.example.travelodgeapi.hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
	@Autowired
	private HotelSpringDataJPARepository hotelRepository;
	@Autowired
	private DownloadHotelDetails downloadHotelDetails;

	public Iterable<Hotel> getHotels() {
		return hotelRepository.findAll();
	}

	public List<Hotel> getHotelsWithName(String name) {
		return hotelRepository.findByTitleContaining(name);
	}

	public void downloadAllHotelsDetails() {
		downloadHotelDetails.downloadAllHotelsDetails();
		hotelRepository.saveAll(downloadHotelDetails.getHotelsDetailsList());
	}

	public Hotel createHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	public Hotel updateHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	public void deleteHotelById(Long id) {
		hotelRepository.deleteById(id);
	}

	public Optional<Hotel> getHotelById(Long id) {
		return hotelRepository.findById(id);
	}

}