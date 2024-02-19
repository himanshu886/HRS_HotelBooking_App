package com.himanshu.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HotelDto {
	
	    private Integer hotelId;
	    
	    @NotBlank
		@Size(min = 4, message = "Min size of hotel title is 4")
	    private String hotelName;

	    @NotBlank
		@Size(min = 4, message = "Min size of hotel location is 4")
	    private String location;

	    @NotBlank
		@Size(min = 100, message = "min size of hotel desc is 100")
	    private String description;
}
