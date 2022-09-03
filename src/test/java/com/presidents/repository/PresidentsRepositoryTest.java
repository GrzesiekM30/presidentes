package com.presidents.repository;

import com.presidents.model.entity.President;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class PresidentsRepositoryTest {

    @Autowired
    PresidentsRepository presidentsRepository;

    @Autowired
    TestEntityManager testEntityManager;


    @Test
    public void shouldFindAllPresidents_when_searchForAll(){
        //given
        testEntityManager.persist(President.builder()
                .name("President1").surname("Surname1").politicalParty("Party1").build());
        //when
        var presidents = presidentsRepository.findAll();
        //then
        Assertions.assertEquals(1,presidents.size());

    }
    @Test
    public void shouldFindPresidentByName_when_NameIsProvidedCorrectly(){
        //given
        testEntityManager.persist(President.builder()
                .name("President1").surname("Surname1").politicalParty("Party1").build());
        //when
        var presidents = presidentsRepository.findPresidentsByName("President1");
        //then
        Assertions.assertEquals(1,presidents.size());

    }
}