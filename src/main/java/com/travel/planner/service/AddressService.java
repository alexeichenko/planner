package com.travel.planner.service;

import com.travel.planner.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    AddressDTO createAddress (AddressDTO addressDTO);
    Optional<AddressDTO> getAddress(Long id);
    AddressDTO updateAddress(Long id, AddressDTO addressDTO);
    AddressDTO deleteAddress(Long id);
    List<AddressDTO> findAllAddresses();
}
