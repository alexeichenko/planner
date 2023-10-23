package com.travel.planner.utils;

import com.travel.planner.dto.AddressDTO;
import com.travel.planner.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDTO toDTO (Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setName(address.getName());
        dto.setDescription(address.getDescription());
        return dto;
    }

    public Address toEntity (AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setName(addressDTO.getName());
        address.setDescription(addressDTO.getDescription());
        return address;
    }
}
