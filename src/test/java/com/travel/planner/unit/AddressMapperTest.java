package com.travel.planner.unit;

import com.travel.planner.dto.AddressDTO;
import com.travel.planner.entity.Address;
import com.travel.planner.utils.AddressMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressMapperTest {
    private AddressMapper addressMapper;
    @BeforeEach
    public void setUp() {
        addressMapper = new AddressMapper();
    }

    @Test
    public void testToDTO() {
        Address address = new Address();
        address.setId(1L);
        address.setName("Test Name");
        address.setDescription("Test Description");
        AddressDTO dto = addressMapper.toDTO(address);
        assertEquals(1L, dto.getId());
        assertEquals("Test Name", dto.getName());
        assertEquals("Test Description", dto.getDescription());
    }

    @Test
    public void testToEntity() {
        AddressDTO dto = new AddressDTO();
        dto.setId(1L);
        dto.setName("Test Name");
        dto.setDescription("Test Description");
        Address address = addressMapper.toEntity(dto);
        assertEquals(1L, address.getId());
        assertEquals("Test Name", address.getName());
        assertEquals("Test Description", address.getDescription());
    }
}
