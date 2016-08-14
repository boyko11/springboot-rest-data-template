package app.controllers;

import app.model.Donkey;
import app.repositories.DonkeyRepository;
import app.request_body_dtos.SearchDonkeyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/donkey")
public class DonkeyController {

    @Autowired
    DonkeyRepository donkeyRepository;

    @RequestMapping
    public List<Donkey> listAllDonkeys() {

        return StreamSupport.stream(donkeyRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @RequestMapping("/{id}")
    public Donkey getDonkeyById(@PathVariable Long id) {

        return donkeyRepository.findOne(id);
    }

    @RequestMapping("/name/{name}")
    public List<Donkey> getDonkeysByName(@PathVariable String name) {

        return StreamSupport.stream(donkeyRepository.findByName(name).spliterator(), false).collect(Collectors.toList());
    }

    @RequestMapping("/temper/{temper}")
    public List<Donkey> getDonkeysByTemper(@PathVariable String temper) {

        return StreamSupport.stream(donkeyRepository.findByTemper(temper).spliterator(), false).collect(Collectors.toList());
    }

    @RequestMapping("/age/{age}")
    public List<Donkey> getDonkeysByAge(@PathVariable int age) {

        return StreamSupport.stream(donkeyRepository.findByAge(age).spliterator(), false).collect(Collectors.toList());
    }

    @RequestMapping(value = "/search/default", method = RequestMethod.POST)
    public List<Donkey> searchDonkeysWithQuery(@RequestBody SearchDonkeyDTO searchDonkeyDTO) {

        String name = searchDonkeyDTO.getName();
        String temper = searchDonkeyDTO.getTemper();
        int age = searchDonkeyDTO.getAge();

        return StreamSupport.stream(donkeyRepository.findByNameAndAgeAndTemper(name, age, temper).spliterator(), false).collect(Collectors.toList());
    }

    @RequestMapping(value = "/search/query", method = RequestMethod.POST)
    public List<Donkey> searchDonkeysWithDefaultRepoDynamicFinder(@RequestBody SearchDonkeyDTO searchDonkeyDTO) {

        String name = searchDonkeyDTO.getName();
        String temper = searchDonkeyDTO.getTemper();
        int age = searchDonkeyDTO.getAge();

        return StreamSupport.stream(donkeyRepository.findByTheNameTheAgeAndTheTemper(name, age, temper).spliterator(), false).collect(Collectors.toList());
    }
}
