package com.travel.planner.unit;

import com.travel.planner.dto.AddressDTO;
import com.travel.planner.entity.Address;
import com.travel.planner.repository.AddressRepository;
import com.travel.planner.service.AddressServiceImpl;
import com.travel.planner.utils.AddressMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class AddressServiceImplTest {
    @Mock
    private AddressRepository addressRepository;
    @Spy
    private AddressMapper addressMapper;
    @InjectMocks
    private AddressServiceImpl addressService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateRoute() {
        Address address = new Address();
        address.setId(1L);
        address.setName("Test name");
        address.setDescription("Test description");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(1L);
        addressDTO.setName("Test name");
        addressDTO.setDescription("Test description");
        when(addressRepository.save(any())).thenReturn(address);
        AddressDTO resultDTO = addressService.createAddress(addressDTO);
        verify(addressRepository, times(1)).save(any(Address.class));
        assertEquals(1L, resultDTO.getId());
        verify(addressMapper, times(1)).toEntity(addressDTO);
        verify(addressMapper, times(1)).toDTO(address);
    }

    @Test
    public void testGetRoute() {
        Address address = new Address();
        address.setId(1L);
        address.setName("Test name");
        address.setDescription("Test description");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(1L);
        addressDTO.setName("Test name");
        addressDTO.setDescription("Test description");
        given(addressRepository.findById(1L)).willReturn(Optional.of(address));
        Optional<AddressDTO> resultDTO = addressService.getAddress(1L);
        assertTrue(resultDTO.isPresent());
        assertEquals(1L, resultDTO.get().getId());
        verify(addressMapper, times(1)).toDTO(address);
    }
}
