package com.presidents.controller;

//Napisać aplikację, która wystawi API będące katalogiem prezydentów USA
//        1. Aplikacja ma na starcie swojego działania przechowywać obiekt reprezentujący pierwszego prezydenta USA +
//        2. Musi istnieć możliwość pobrania listy wszystkich prezydentów przechowywanych w aplikacji +
//        3. Musi istnieć możliwość dodania nowego prezydenta do statycznej listy prezydentów +
//        4. Musi istnieć możliwość edytowania obiektu reprezentującego prezydenta metodą PUT +
//        5.  Musi istnieć możliwość częściowego edytowania obiektu reprezentującego prezydenta metodą PATCH
//        6. Musi istnieć możliwość usunięcia dowolnego obiektu reprezentującego prezydenta po indeksie w statycznej liście +
//        NIE COMMITOWAĆ ZMIAN  🙂
import com.presidents.model.President;
import com.presidents.repository.PresidentsDB;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("presidents")
@RestController
public class PresidentsController {

    @GetMapping("/all")
    public List<President> getAll() {
        return PresidentsDB.presidentRepository;
    }

    @PostMapping("/save")
    public String save(@RequestBody President president) {
        president.setId((long) PresidentsDB.presidentRepository.size());
        PresidentsDB.presidentRepository.add(president);
        return "President " + president.getName() + " " + president.getSurname() + " saved.";
    }

    @PutMapping("/update")
    public String updateWithBodyOnly(@RequestBody President president) {
        if (PresidentsDB.presidentRepository.size() - 1 < president.getId()) {
            president.setId((long) PresidentsDB.presidentRepository.size());
            PresidentsDB.presidentRepository.add(president);
        } else {
            PresidentsDB.presidentRepository.set(Math.toIntExact(president.getId()), president);
        }
        return "Updated";
    }
    @PatchMapping("partial-update")
    public String updatePartial(@RequestBody President president) {
        President p = PresidentsDB.presidentRepository.get(Math.toIntExact(president.getId()));
        if (president.getName() != null) {
            p.setName(president.getName());
        }
        if (president.getSurname() != null) {
            p.setSurname(president.getSurname());
        }
        if (president.getTermFrom() != null) {
            p.setTermFrom(president.getTermFrom());
        }
        if (president.getTermTo() != null) {
            p.setTermTo(president.getTermTo());
        }
        if (president.getPoliticalParty() != null) {
            p.setPoliticalParty(president.getPoliticalParty());
        }
        return "Updated";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteByIndex(@PathVariable int id){
        PresidentsDB.presidentRepository.remove(id);
        return "Removed!";
    }


}
