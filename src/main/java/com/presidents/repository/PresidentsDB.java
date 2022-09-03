package com.presidents.repository;

import com.presidents.model.entity.President;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;

@Component
public class PresidentsDB implements CommandLineRunner {

    public static ArrayList<President> presidentRepository = new ArrayList<>();
    @Override
    public void run(String... args) throws Exception {
        presidentRepository.add(President.builder().id(0L).name("George").surname("Washington")
                .termFrom(Timestamp.valueOf("1789-04-30 00:00:00")).termTo(Timestamp.valueOf("1797-03-04 00:00:00")).
                politicalParty("None").build());


    }
}
