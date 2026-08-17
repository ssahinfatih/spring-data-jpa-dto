package com.fatihsahin.services.impl;

import com.fatihsahin.dto.DtoHome;
import com.fatihsahin.dto.DtoRoom;
import com.fatihsahin.entites.Home;
import com.fatihsahin.entites.Room;
import com.fatihsahin.repository.HomeRepository;
import com.fatihsahin.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome findDtoHomeById(Long id) {
        DtoHome dtoHome = new DtoHome();
        Optional<Home> optional = homeRepository.findById(id);//home id ile veritaanından buluyoruz.
        if (optional.isEmpty()) {//home yoksa null dön.
            return null;
        }
        Home home = optional.get(); // home veritabanından gelen gerçek home nesnesine eşitliyoruz.
        List<Room> dbRooms = home.getRoom();// home bağlı roomları alıyoruz.

        BeanUtils.copyProperties(home, dtoHome);//home u dto haline çeviriyoruz.

        if (dbRooms != null && !dbRooms.isEmpty()) {
            for (Room room : dbRooms) {//roomları tek tek dto hallerine çeviriyoruz.
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                dtoHome.getRoom().add(dtoRoom);
            }

        }
        return dtoHome;
    }
}
