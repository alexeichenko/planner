package com.travel.planner.controller;
import com.travel.planner.service.AddressService;
import com.travel.planner.dto.AddressDTO;
import com.travel.planner.dto.RouteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressController {
    private final AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/address/create")
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(addressService.createAddress(addressDTO));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/address/id/delete")
    public ResponseEntity<AddressDTO> deleteAddressRequestParam(@RequestParam("addressId") Long addressId) {
        return ResponseEntity.ok(addressService.deleteAddress(addressId));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/address/id/update")
    public ResponseEntity<AddressDTO> updateAddressRequestParam(@RequestParam("addressId") Long addressId) {
        AddressDTO addressDTO = new AddressDTO();
        return ResponseEntity.ok(addressService.updateAddress(addressId, addressDTO));
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/address/id/{addressId}")
    public ResponseEntity<Optional<AddressDTO>> getAddress(@PathVariable("addressId") Long addressId) {
        return ResponseEntity.ok(addressService.getAddress(addressId));
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/address/id/")
    public ResponseEntity<Optional<AddressDTO>> getAddressRequestParam(@RequestParam("addressId") Long addressId) {
        return ResponseEntity.ok(addressService.getAddress(addressId));
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/address/find")
    public ResponseEntity<AddressDTO> findAddressRequestParam(@RequestParam RouteDTO addressDTO) {
        return ResponseEntity.ok((AddressDTO) addressService.findAllAddresses());
    }
}

