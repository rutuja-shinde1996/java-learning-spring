package com.learning.spring.web;

import com.learning.spring.business.domain.RoomReservation;
import com.learning.spring.business.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RoomReservationWebController.class)
public class RoomReservationWebControllerTests {
    @MockBean
    ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReservations() throws Exception{
        String dateString = "2020-01-01";
        Date date = DateUtil.createDateFromDateString(dateString);
        List<RoomReservation> roomReservationList = new ArrayList<>();
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setLastName("Unit");
        roomReservation.setReservationDate(date);
        roomReservation.setFirstName("Junit");
        roomReservation.setRoomId(100);
        roomReservation.setGuestId(1);
        roomReservation.setRoomNumber("J1");
        roomReservation.setRoomName("Junit Room");
        roomReservationList.add(roomReservation);
        given(reservationService.getRoomReservationsForDate(date)).willReturn(roomReservationList);

        this.mockMvc.perform(get("/reservations?date=2020-01-01")).andExpect(status().isOk()).andExpect(content().string(containsString("Unit, Junit")));
    }

}
