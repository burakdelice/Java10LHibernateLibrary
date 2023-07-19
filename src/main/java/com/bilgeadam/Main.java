package com.bilgeadam;

import com.bilgeadam.repository.AddressRepository;
import com.bilgeadam.repository.UserInformationRepository;
import com.bilgeadam.repository.UserRepository;
import com.bilgeadam.repository.entity.Address;
import com.bilgeadam.repository.entity.UserInformation;
import com.bilgeadam.repository.entity.Users;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserInformationRepository userInformationRepository = new UserInformationRepository();
        AddressRepository addressRepository = new AddressRepository();

        Address address = Address.builder().city("Ankara").country("Türkiye").build();
        addressRepository.save(address);
        UserInformation userInformation = UserInformation.builder().firstName("Mustafa").lastName("Ozturk").address(address).build();
        userInformationRepository.save(userInformation);

        Users user = Users.builder().password("123").username("musty")
                .userInformation(userInformation).build();
        userRepository.save(user);

        Users user2 = Users.builder().password("456").username("mustafa").build();
        userRepository.save(user2);
    }
}