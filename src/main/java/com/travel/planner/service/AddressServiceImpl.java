package com.travel.planner.service;

import com.travel.planner.dto.AddressDTO;
import com.travel.planner.entity.Address;
import com.travel.planner.exception.CustomException;
import com.travel.planner.repository.AddressRepository;
import com.travel.planner.utils.AddressMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }
    @Transactional
    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = addressMapper.toEntity(addressDTO);
        address = addressRepository.save(address);
        return addressMapper.toDTO(address);
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<AddressDTO> getAddress(Long id) {
        return addressRepository.findById(id).map(addressMapper::toDTO);
    }
    @Transactional
    @Override
    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        if (addressRepository.existsById(id)) {
            Address address = addressMapper.toEntity(addressDTO);
            address.setId(id);
            address = addressRepository.save(address);
            return addressMapper.toDTO(address);
        }
        return null;
    }
    @Transactional(rollbackFor = CustomException.class, propagation = Propagation.REQUIRED)
    @Override
    public AddressDTO deleteAddress(Long id) {
        addressRepository.deleteById(id);
        throw new CustomException("deleted wrong should be rollback", 500);
    }
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<AddressDTO> findAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(addressMapper::toDTO)
                .collect(Collectors.toList());
    }
}
